/**
 *  This is our play screen for the hard difficulty, the user can pause and return to menu using the pause button
 */
//import necessary packages
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class EndGameScreen extends ScreenFrame implements ActionListener{
	private JButton jbtPlayAgain, jbtMenu;
	private JLabel score, label; //text label
	private final Color ENDGAME_COLOR_FG = Color.blue, ENDGAME_COLOR_BG = Color.cyan; //constant colors of difficulty button foreground and background respectively
	private final Font ENDGAME_FONT = new Font("Comic Sans MS", Font.PLAIN, 25); //constant font of difficulty buttons
	public static int timeleft;
	private static int highscore;
	private static int points;
	
	//Constructor for EndGameScreen:
	EndGameScreen(){
		super(); //calls ScreenFrame constructor creating a new ScreenFrame

		this.setLayout(null);
		this.getContentPane().setBackground(BG_COLOR);
		//Get score for the play screen
		getPoints();
		
		//Label prompting the user to press a button
		score = addCustomLabel("Score: " + points, Color.cyan, new Font("Comic Sans MS", Font.BOLD, 50));
		//Sets bounds of the label
		score.setBounds(400, -200, this.getWidth() - 1, this.getHeight() - 1 );
		this.add(score); //add label
		
		label = addCustomLabel("Game Over!", Color.cyan, new Font("Comic Sans MS", Font.BOLD, 50));
		//Sets bounds of the label
		label.setBounds(375, -350, this.getWidth() - 1, this.getHeight() - 1 );
		this.add(label); //add label
		
		//Add custom button to play again
		jbtPlayAgain = addCustomButton("Play Again", 50, 600, 200, 80, ENDGAME_COLOR_FG, ENDGAME_COLOR_BG, ENDGAME_FONT);
		jbtPlayAgain.addActionListener(this); //register action listener
		this.add(jbtPlayAgain); //add button
		
		//Add custom button to return to menu
		jbtMenu = addCustomButton("Menu", 750, 600, 200, 80, ENDGAME_COLOR_FG, ENDGAME_COLOR_BG, ENDGAME_FONT);
		jbtMenu.addActionListener(this); //register action listener
		this.add(jbtMenu); //add button

		//write score into text files to be stored
		switch(DifficultyScreen.diff) {//write to appropriate text file based on difficulty level
		case 1: //easy level
			writeScoreToFile(ScoreScreen.getEasyFileName(), String.valueOf(EasyPlayScreen.points)); //write score to easy text file
			break;
		case 2: //medium level
			writeScoreToFile(ScoreScreen.getMediumFileName(), String.valueOf(MediumPlayScreen.points)); //write score to medium text file
			break;
		case 3: //hard level
			writeScoreToFile(ScoreScreen.getHardFileName(), String.valueOf(HardPlayScreen.points)); //write score to hard text file
			break;
		}
	}//end of EndGameScreen constructor

	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtPlayAgain) {
			new DifficultyScreen();
			resetScore();
			resetTime();
			this.dispose();
		}

		else if(e.getSource() == jbtMenu) {
			//create new instance of MenuScreen class
			new MenuScreen();
			resetScore();
			resetTime();
			this.dispose(); //get rid of current frame
		}

	}//end of actionPerformed method
	
	//Method that gets points from the play screen
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
	
	//Method that resets the timer
	public static void resetTime() {
		EasyPlayScreen.timeLeft = 60;
		MediumPlayScreen.timeLeft = 60;
		HardPlayScreen.timeLeft = 60;
	}
	
	
	//Method that reset's the current game's score for the next game
	public static void resetScore() {
		EasyPlayScreen.points = 0;
		MediumPlayScreen.points = 0;
		HardPlayScreen.points = 0;
	}
	
	/**
	 * This method writes a score into a text file
	 * @param fileName name of text file
	 * @param score score to be entered
	 */
	public void writeScoreToFile(String fileName, String txt) {
		try {//append characters to the file
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
			writer.write(txt); //write the new score into the text file
			writer.newLine(); //write a new line
			writer.close(); //close writer instance
		}
		//catch the IOException
		catch(IOException iox) {
			System.out.println("Problem writing " + fileName);
		}
	}//end of writeScoreToFile method	
}