/**
 * This class is the play screen for the Medium difficulty. It consists of a 3x4 grid of holes and a heading displaying the score and time remaining. 2 moles are
 * visible in the grid: moles earn 1 point each. When the timer runs out or if the player quits the game, they are brought to a Game Over screen.
 */
//import necessary packages
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MediumPlayScreen extends ScreenFrame implements ActionListener{
	public static int points = 0, timeLeft = 60; //points and timeLeft during game
	private ImageIcon bg; //background image
	private JLabel scorelbl, timelbl; //labels to hold score and time
	private JPanel headingPanel; //header to hold score, time, and pause button
	private JPanel grid; //grid to hold moles
	private final Color MEDIUMPLAY_COLOR_FG = Color.blue, MEDIUMPLAY_COLOR_BG = Color.cyan; //constant colors of button foreground and background respectively
	private final Font MEDIUMPLAY_FONT = new Font("Comic Sans MS", Font.PLAIN, 25); //constant font of buttons
	private Mole[] moles = new Mole[12]; //array of 12 moles
	private Timer timer; //timer to control game time limit
	private JButton jbtPause; //pause button

	/**
	 * Constructor for MediumPlayScreen
	 */
	public MediumPlayScreen(){
		//set background image
		bg = new ImageIcon("images/bgPlay.jpg");

		//set JLabels for score and time remaining
		scorelbl = addCustomLabel("    Score: " + points, Color.cyan, new Font("Comic Sans MS", Font.BOLD, 35));
		timelbl = addCustomLabel("    Time left: " + timeLeft + " seconds", Color.cyan, new Font("Comic Sans MS", Font.BOLD, 35));
		//JButton for pause button
		jbtPause = addCustomButton("||", 10, 10, 75, 75, MEDIUMPLAY_COLOR_FG, MEDIUMPLAY_COLOR_BG, MEDIUMPLAY_FONT);
		jbtPause.addActionListener(this); //register action listener

		//the heading panel holds the score, time, and pause button
		headingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); //set layout manager of header
		headingPanel.setBackground(BG_COLOR); //set background color
		headingPanel.add(jbtPause); //add buttons and labels
		headingPanel.add(scorelbl);
		headingPanel.add(timelbl);
		this.add(headingPanel, BorderLayout.NORTH); //add header to top of frame
		
		timer();//call the timer method
		timer.start();//start the timer

		//this grid holds all the moles
		grid = new PaintPanel(); //Grid is a PaintPanel so we can use custom background
		grid.setLayout(null); //set layout to null so we can manually place moles
		for(int i = 0; i < moles.length; i++) { //setting all 9 moles
			moles[i] = new Mole(); //new instance of Mole class
			moles[i].addActionListener(this);//add action listener
			grid.add(moles[i]);//add mole to the grid
		}
		//Setting bounds for each mole
		moles[0].setBounds(100, 200, 100, 90);
		moles[1].setBounds(300, 200, 100, 90);
		moles[2].setBounds(500, 200, 100, 90);
		moles[3].setBounds(700, 200, 100, 90);
		moles[4].setBounds(150, 350, 100, 90);
		moles[5].setBounds(350, 350, 100, 90);
		moles[6].setBounds(550, 350, 100, 90);
		moles[7].setBounds(750, 350, 100, 90);
		moles[8].setBounds(100, 500, 100, 90);
		moles[9].setBounds(300, 500, 100, 90);
		moles[10].setBounds(500, 500, 100, 90);
		moles[11].setBounds(700, 500, 100, 90);

		this.add(grid, BorderLayout.CENTER); //add grid to center of frame

		//set 2 moles up randomly
		moleRandomizer();
	}//end of MediumPlayScreen constructor

	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtPause) {//pause button
			timer.stop(); //stop timer
			new PauseScreen(); //create pause screen
			this.dispose(); //dispose of current frame
		}
		else { //a mole is clicked
			for(int i = 0; i < 12; i++) { //check each mole until clicked mole is found
				if(e.getSource() == moles[i] && moles[i].isUp) {//if mole is clicked and is up
					//*********************************************************************Start of taken code
					/*This code plays a sound effect when the mole is hit. I took the code from 1st answer on:
					 * https://stackoverflow.com/questions/15526255/best-way-to-get-sound-on-button-press-for-a-java-calculator
					 * I edited it using Eclipse's suggestions
					 */
					String soundName = "sounds/NormalMole.wav";   
					AudioInputStream audioInputStream = null;
					try {
						audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
					} catch (UnsupportedAudioFileException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					} catch (IOException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					Clip clip = null;
					try {
						clip = AudioSystem.getClip();
					} catch (LineUnavailableException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						clip.open(audioInputStream);
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					clip.start();
					//*************************************************************End of taken code
					points++; //increment points
					int hole; //random hole for next mole to appear from
					//loop to generate random hole location
					do {
						hole = (int)(Math.random() * 9);
					}while(moles[hole].isUp); //keep generating random holes if the mole on that hole is already up (no duplicates)
					moles[hole].setUp(); //set new mole up
					moles[i].setDown(); //set hit mole down
					scorelbl.setText("    Score: " + points); //update score label
					break; //break for loop
				}
			}
		}
	}//end of actionPerformed method

	/**
	 * This method determines a random placement of 2 moles
	 */
	private void moleRandomizer() {
		int m1; //2 random moles
		int m2;
		do {
			m1 = (int)(Math.random() * 9); //generate random moles
			m2 = (int)(Math.random() * 9);
		}while(m1 == m2);//while two of the values are the same continue randomizing until all moles are different
		moles[m1].setUp(); //set the moles up
		moles[m2].setUp();
	}//end of moleRandomizer method

	/**
	 * This method is a timer for controlling the time limit of our game
	 */
	public void timer() {
		timer = new Timer(1000, new ActionListener() {//Creates a new timer object
			public void actionPerformed(ActionEvent evt) {
				if(timeLeft == 0){//when the timer reaches 0
					timelbl.setText("    Time left: " + timeLeft + " seconds"); //update JLabel
					timer.stop(); //stop the timer
					new EndGameScreen();//Create the end game screen and dispose this one
					dispose();
				}
				timeLeft--; //decrement timeLeft
				timelbl.setText("    Time left: " + timeLeft + " seconds"); //update JLabel
			}
		});
	}//end of timer method

	/**
	 * This class is a canvas that draws the background image. All components are added to this Panel, then the
	 * PaintPanel is added to the JFrame.
	 */
	class PaintPanel extends JPanel{
		protected void paintComponent(Graphics g){
			super.paintComponent(g); //override the paintComponent method
			//draw the background image
			g.drawImage(bg.getImage(),0,0,this.getWidth(),this.getHeight(),null);
		}//end of paintComponent method
	}
}