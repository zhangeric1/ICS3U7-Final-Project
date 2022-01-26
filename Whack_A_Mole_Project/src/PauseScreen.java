/**
 * This is our pause screen, the user may resume or return to the menu
 */
//import necessary packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PauseScreen extends ScreenFrame implements ActionListener{
	private JButton jbtResume, jbtEndGame;
	private JLabel label, scorelbl, timelbl; //text label
	private final Color PAUSE_COLOR_FG = Color.blue, PAUSE_COLOR_BG = Color.cyan; //constant colors of button foreground and background respectively
	private final Font PAUSE_FONT = new Font("Comic Sans MS", Font.PLAIN, 25); //constant font of buttons
	public static int points, timeLeft; 
	private JPanel headingPanel;
	
	//Constructor for PauseScreen:
	PauseScreen(){
		super(); //calls ScreenFrame constructor creating a new ScreenFrame
		
		//set layout of canvas so we can add buttons manually
		this.setLayout(null);
		this.getContentPane().setBackground(BG_COLOR); //set background color of frame
		
		label = addCustomLabel("Paused", Color.cyan, new Font("Comic Sans MS", Font.BOLD, 50));
		//Sets bounds of the label
		label.setBounds(375, -200, this.getWidth() - 1, this.getHeight() - 1 );
		this.add(label); //add label
		
		//Get the time and score from the play screen
		getTime();
		getPoints();
		
		scorelbl = addCustomLabel("    Score: " + points, Color.cyan, new Font("Comic Sans MS", Font.BOLD, 35));
		timelbl = addCustomLabel("    Time left: " + timeLeft + " seconds", Color.cyan, new Font("Comic Sans MS", Font.BOLD, 35));
		
		headingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		headingPanel.setBackground(BG_COLOR);
		headingPanel.add(scorelbl);
		headingPanel.add(timelbl);
		headingPanel.setBounds(0, 0, 1000, 60);
		this.add(headingPanel);
		
		//Add custom button to resume mode
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
		if(e.getSource() == jbtResume) {
			if (DifficultyScreen.diff == 1) {
				new EasyPlayScreen();
			}
			else if (DifficultyScreen.diff == 2) {
				new MediumPlayScreen();
			}
			else if (DifficultyScreen.diff == 3){
				new HardPlayScreen();
			}
			this.dispose();//get rid of current window
		}

		else if(e.getSource() == jbtEndGame) {
			new EndGameScreen();
			this.dispose();
		}

	}//end of actionPerformed method
	
	public static void getTime() {
		if (DifficultyScreen.diff == 1){
			timeLeft = EasyPlayScreen.timeLeft;
		}
		else if (DifficultyScreen.diff == 2){
			timeLeft = MediumPlayScreen.timeLeft;
		}
		else if (DifficultyScreen.diff == 3){
			timeLeft = HardPlayScreen.timeLeft;
		}
	}
	
	public static void getPoints() {
		if (DifficultyScreen.diff == 1){
			points = EasyPlayScreen.points;
		}
		else if (DifficultyScreen.diff == 2){
			points = MediumPlayScreen.points;
		}
		else if (DifficultyScreen.diff == 3){
			points = HardPlayScreen.points;
		}
	}
}