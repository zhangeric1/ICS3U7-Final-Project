/**
 * This is our play screen for the medium difficulty The user can pause and return to menu using the pause button
 */
//import necessary packages
import java.awt.*;
import java.awt.event.*;
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
	Mole[] moles = new Mole[12]; //array of 12 moles
	private Timer timer; //timer to control game time limit
	JButton jbtPause; //pause button

	/**
	 * Constructor for MediumPlayScreen
	 */
	MediumPlayScreen(){
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
		MoleRandomizer();
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
	private void MoleRandomizer() {
		int m1; //2 random moles
		int m2;
		do {
			m1 = (int)(Math.random() * 9); //generate random moles
			m2 = (int)(Math.random() * 9);
		}while(m1 == m2);//while two of the values are the same continue randomizing until all moles are different
		moles[m1].setUp(); //set the moles up
		moles[m2].setUp();
	}//end of MoleRandomizer method

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