/**
 * This is our hard play screen for the hard difficulty. The user can pause and return to menu using the pause button
 */
//import necessary packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class HardPlayScreen extends ScreenFrame implements ActionListener{
	public static int points = 0, timeLeft = 60; //points and timeLeft during game
	private ImageIcon bg; //background image
	private JLabel scorelbl, timelbl; //labels to hold score and time
	private JPanel headingPanel; //header to hold score, time, and pause button
	private JPanel grid; //grid to hold moles
	private final Color HARDPLAY_COLOR_FG = Color.blue, HARDPLAY_COLOR_BG = Color.cyan; //constant colors of button foreground and background respectively
	private final Font HARDPLAY_FONT = new Font("Comic Sans MS", Font.PLAIN, 25); //constant font of buttons
	Mole[] moles = new Mole[16]; //array of 16 moles
	private Timer timer; //timer to control game time limit
	JButton jbtPause; //pause button

	/**
	 * Constructor for HardPlayScreen
	 */
	HardPlayScreen(){
		//set the background image
		bg = new ImageIcon("images/bgPlay.jpg");

		//set JLabels for score and time remaining
		scorelbl = addCustomLabel("    Score: " + points, Color.cyan, new Font("Comic Sans MS", Font.BOLD, 35));
		timelbl = addCustomLabel("    Time left: " + timeLeft + " seconds", Color.cyan, new Font("Comic Sans MS", Font.BOLD, 35));
		//JButton for pause button
		jbtPause = addCustomButton("||", 10, 10, 75, 75, HARDPLAY_COLOR_FG, HARDPLAY_COLOR_BG, HARDPLAY_FONT);
		jbtPause.addActionListener(this); //register action listener
		
		//the heading panel holds the score, time, and pause button
		headingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));//set layout manager
		headingPanel.setBackground(BG_COLOR); //set background color
		headingPanel.add(jbtPause);//add buttons and labels
		headingPanel.add(scorelbl);
		headingPanel.add(timelbl);
		//add heading panel to the top of the frame
		this.add(headingPanel, BorderLayout.NORTH);

		timer();//call the timer method
		timer.start();//start the timer

		//this grid holds all the moles
		grid = new PaintPanel(); //Grid is a PaintPanel so we can use custom background
		grid.setLayout(null); //set layout to null so we can manually place moles
		for(int i = 0; i < moles.length; i++) { //setting all 16 moles
			moles[i] = new Mole(); //new instance of Mole class
			moles[i].addActionListener(this);//add action listener
			grid.add(moles[i]);//add mole to the grid
		}
		//Setting bounds for each mole
		moles[0].setBounds(100, 110, 100, 90);
		moles[1].setBounds(300, 110, 100, 90);
		moles[2].setBounds(500, 110, 100, 90);
		moles[3].setBounds(700, 110, 100, 90);
		moles[4].setBounds(150, 260, 100, 90);
		moles[5].setBounds(350, 260, 100, 90);
		moles[6].setBounds(550, 260, 100, 90);
		moles[7].setBounds(750, 260, 100, 90);
		moles[8].setBounds(100, 410, 100, 90);
		moles[9].setBounds(300, 410, 100, 90);
		moles[10].setBounds(500, 410, 100, 90);
		moles[11].setBounds(700, 410, 100, 90);
		moles[12].setBounds(150, 560, 100, 90);
		moles[13].setBounds(350, 560, 100, 90);
		moles[14].setBounds(550, 560, 100, 90);
		moles[15].setBounds(750, 560, 100, 90);

		//add grid to the center of the frame
		this.add(grid, BorderLayout.CENTER);

		//randomly set 3 moles
		MoleRandomizer();
	}//end of HardPlayScreen constructor

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
		else {//a mole is clicked
			for(int i = 0; i < 16; i++) { //check each mole until the clicked mole is found
				if(e.getSource() == moles[i] && moles[i].isUp) { //if mole is clicked and is up
					switch(moles[i].getState()) { //get the state of the mole to determine how many points should be incremented/decremented
					case 1://normal state
						points++;
						break;
					case 2: //super state
						points += 2;
						break;
					case 3: //sabotage state
						if(points >= 2) { //if points are greater or equal to 2, decrement 2
							points -= 2;
						}
						else { //make points 0 so we don't go into negatives
							points = 0;
						}
						break;
					}
					//a random hole for the next mole to appear from
					int hole;
					//loop to generate random hole location
					do {
						hole = (int)(Math.random() * 16);
					}while(moles[hole].isUp); //keep generating random holes if the mole on that hole is already up (no duplicates)

					//generate a random type of mole to pop up (different percent chance for each)
					int type = (int)((Math.random() * 100) + 1);
					if(type <= 70) { //70% chance for normal mole
						moles[hole].setNormal(); //set the state of mole
					}
					else if(type >= 85) {//15% chance for super mole
						moles[hole].setSuper();//set the state of mole
					}
					else { //15% chance for sabotage mole
						moles[hole].setSabotage();//set the state of mole
					}
					moles[hole].setUp(); //set new mole up
					moles[i].setDown(); //set hit mole down
					scorelbl.setText("    Score: " + points); //update score label
					break;//break the for loop
				}
			}
		}
	}//end of actionPerformed method

	/**
	 * This method determines a random placement of 3 moles
	 */
	private void MoleRandomizer() {
		int m1; //random moles
		int m2;
		int m3;
		do {
			m1 = (int)(Math.random() * 16); //generate random moles
			m2 = (int)(Math.random() * 16);
			m3 = (int)(Math.random() * 16);
		}while(m1 == m2 || m1 == m3 || m2 == m3);//while two or more of the values are the same continue randomizing until all 3 are different

		moles[m1].setUp(); //set up moles
		moles[m2].setUp();
		moles[m3].setUp();
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
	}//end of PaintPanel class
}