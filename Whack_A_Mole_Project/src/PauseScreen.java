/**
 * This is our pause screen, the user may resume their game or return to the menu.
 */
//import necessary packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PauseScreen extends ScreenFrame implements ActionListener{
	private JButton jbtResume, jbtEndGame; //buttons to resume or quit the game
	private JLabel label, scorelbl, timelbl; //text label
	private final Color PAUSE_COLOR_FG = Color.blue, PAUSE_COLOR_BG = Color.cyan; //constant colors of button foreground and background respectively
	private final Font PAUSE_FONT = new Font("Comic Sans MS", Font.PLAIN, 25); //constant font of buttons
	public static int points, timeLeft; //number of points and time remaining
	private JPanel headingPanel; //acts as a heading

	/**
	 * Constructor for PauseScreen:
	 */
	public PauseScreen(){
		//set layout of canvas so we can add buttons manually
		this.setLayout(null);
		this.getContentPane().setBackground(BG_COLOR); //set background color of frame

		//label to show some text
		label = addCustomLabel("Paused", Color.cyan, new Font("Comic Sans MS", Font.BOLD, 150));
		//Sets bounds of the label
		label.setBounds(250, -100, this.getWidth() - 1, this.getHeight() - 1 );
		this.add(label); //add label

		//Get the time and score from the play screen
		getTime();
		getPoints();

		//labels to show score and time left
		scorelbl = addCustomLabel("    Score: " + points, Color.cyan, new Font("Comic Sans MS", Font.BOLD, 35));
		timelbl = addCustomLabel("    Time left: " + timeLeft + " seconds", Color.cyan, new Font("Comic Sans MS", Font.BOLD, 35));

		//heading panel holds the score and time
		headingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); //set layout manager
		headingPanel.setBackground(BG_COLOR); //set background color of header
		headingPanel.add(scorelbl); //add score
		headingPanel.add(timelbl); //add time left
		headingPanel.setBounds(0, 0, 1000, 60); //set bounds of header
		this.add(headingPanel); //add to frame

		//Add custom button to resume game
		jbtResume = addCustomButton("Resume", 50, 600, 200, 80, PAUSE_COLOR_FG, PAUSE_COLOR_BG, PAUSE_FONT);
		jbtResume.addActionListener(this); //register action listener
		this.add(jbtResume); //add button

		//Add custom button to end the game
		jbtEndGame = addCustomButton("End Game", 750, 600, 200, 80, PAUSE_COLOR_FG, PAUSE_COLOR_BG, PAUSE_FONT);
		jbtEndGame.addActionListener(this); //register action listener
		this.add(jbtEndGame); //add button to canvas
	}//end of PauseScreen constructor

	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtResume) { //resume button
			if (DifficultyScreen.diff == 1) { //difficulty level easy
				new EasyPlayScreen(); //new EasyPlayScreen
			}
			else if (DifficultyScreen.diff == 2) {//difficulty level medium
				new MediumPlayScreen();//new MediumPlayScreen
			}
			else if (DifficultyScreen.diff == 3){//difficulty level hard
				new HardPlayScreen();//new HardPlayScreen
			}
			this.dispose();//get rid of current frame
		}

		else if(e.getSource() == jbtEndGame) { //end game button
			new EndGameScreen();//new EndGameScreen
			this.dispose(); //dispose of current frame
		}
	}//end of actionPerformed method

	/**
	 * This method gets the time of the play screen and stores it in the timeLeft variable of PauseScreen
	 */
	public static void getTime() {
		if (DifficultyScreen.diff == 1){ //easy difficulty
			timeLeft = EasyPlayScreen.timeLeft; //set the time left as the time from EasyPlayScreen
		}
		else if (DifficultyScreen.diff == 2){//medium difficulty
			timeLeft = MediumPlayScreen.timeLeft;//set the time left as the time from MediumPlayScreen
		}
		else if (DifficultyScreen.diff == 3){//hard difficulty
			timeLeft = HardPlayScreen.timeLeft;//set the time left as the time from HardPlayScreen
		}
	}//end of getTime method

	/**
	 * This method gets the points of the play screen and stores it in the points variable of PauseScreen
	 */
	public static void getPoints() { 
		if (DifficultyScreen.diff == 1){ //easy difficulty
			points = EasyPlayScreen.points; //set points as the score from EasyPlayScreen
		}
		else if (DifficultyScreen.diff == 2){ //medium difficulty
			points = MediumPlayScreen.points; //set points as the score from MediumPlayScreen
		}
		else if (DifficultyScreen.diff == 3){ //hard difficulty
			points = HardPlayScreen.points; //set points as the score from HardPlayScreen
		}
	}//end of getPoints method
}