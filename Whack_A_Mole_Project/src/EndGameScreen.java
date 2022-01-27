/**
 *  This is our screen that displays the end game message and allows the user to play again or return to the menu. Their current score is stored into a text file.
 */
//import necessary packages
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class EndGameScreen extends ScreenFrame implements ActionListener{
	private JButton jbtPlayAgain, jbtMenu; //buttons to play again or return to menu
	private JLabel score, label; //text labels
	private final Color ENDGAME_COLOR_FG = Color.blue, ENDGAME_COLOR_BG = Color.cyan; //constant colors of difficulty button foreground and background respectively
	private final Font ENDGAME_FONT = new Font("Comic Sans MS", Font.PLAIN, 25); //constant font of difficulty buttons
	public static int timeleft, points; //points and time left

	/**
	 * Constructor for EndGameScreen
	 */
	EndGameScreen(){
		//set layout manager as null so we can manually place components
		this.setLayout(null);
		this.getContentPane().setBackground(BG_COLOR); //set background color
		
		//Retrieve score for the play screen
		getPoints();

		//label to display score
		score = addCustomLabel("Score: " + points, Color.cyan, new Font("Comic Sans MS", Font.BOLD, 50));
		//Sets bounds of the label
		score.setBounds(400, -200, this.getWidth() - 1, this.getHeight() - 1 );
		this.add(score); //add label

		//label to display end message
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
			if(checkNewHigh(ScoreScreen.getEasyFileName(), points)) { //check if new score is a high score
				score.setText("New Highscore: " + points); //update label for new message
				score.setLocation(300, -200); //set new location for longer JLabel
			}
			writeScoreToFile(ScoreScreen.getEasyFileName(), String.valueOf(points)); //write score to easy text file
			break;
		case 2: //medium level
			if(checkNewHigh(ScoreScreen.getMediumFileName(), points)) {//check if new score is a high score
				score.setText("New Highscore: " + points); //update label for new message
				score.setLocation(300, -200); //set new location for longer JLabel
			}
			writeScoreToFile(ScoreScreen.getMediumFileName(), String.valueOf(points)); //write score to medium text file
			break;
		case 3: //hard level
			if(checkNewHigh(ScoreScreen.getHardFileName(), points)) {//check if new score is a high score
				score.setText("New Highscore: " + points); //update label for new message
				score.setLocation(300, -200); //set new location for longer JLabel
			}
			writeScoreToFile(ScoreScreen.getHardFileName(), String.valueOf(points)); //write score to hard text file
			break;
		}
	}//end of EndGameScreen constructor

	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtPlayAgain) { //Play again button
			new DifficultyScreen(); //new instance of DifficultyScreen
			resetScore(); //reset the score and time
			resetTime();
			this.dispose(); //dispose of current frame
		}
		else if(e.getSource() == jbtMenu) { //Menu button
			new MenuScreen();//new instance of MenuScreen class
			resetScore(); //reset the score and time
			resetTime();
			this.dispose(); //dispose of current frame
		}
	}//end of actionPerformed method

	/**
	 * This method gets the points of the play screen and stores it in the points variable of EndGameScreen
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

	/**
	 * This method resets the timer for each play screen
	 */
	public static void resetTime() {
		EasyPlayScreen.timeLeft = 60;
		MediumPlayScreen.timeLeft = 60;
		HardPlayScreen.timeLeft = 60;
	}//end of resetTime method

	/**
	 * This method resets each play screen's score for the next game
	 */
	public static void resetScore() {
		EasyPlayScreen.points = 0;
		MediumPlayScreen.points = 0;
		HardPlayScreen.points = 0;
	}//end of resetScore method

	/**
	 * This method checks if a score is a new high score in a text file
	 * @param fileName Name of text file
	 * @param score Score to be checked
	 * @return true if the score is a new high score, false otherwise
	 */
	public boolean checkNewHigh(String fileName, int score) {
		String line; //line of input
		try {
			@SuppressWarnings("resource")
			BufferedReader read = new BufferedReader(new FileReader(fileName));
			line = read.readLine(); //read the first line
			while(line != null) { //continue until end of file
				if(Integer.parseInt(line) >= score) { //if the score in the text file is greater than the current score to be checked
					return false; //Immediately stop once a higher score is found
				}
				line = read.readLine(); //continue reading the next line
			}
			read.close(); //close BufferedReader instance
		}
		//catch the IOException
		catch(IOException iox) {
			System.out.println("Problem reading " + fileName + " when checking highscore.");
		}
		return true; //no scores are greater than current score
	}//end of checkNewHigh method

	/**
	 * This method writes a score into a text file
	 * @param fileName name of text file
	 * @param score score to be entered
	 */
	private void writeScoreToFile(String fileName, String txt) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
			writer.write(txt); //write the new score into the text file
			writer.newLine(); //write a new line
			writer.close(); //close writer instance
		}
		//catch the IOException
		catch(IOException iox) {
			System.out.println("Problem writing to " + fileName + " when storing score");
		}
	}//end of writeScoreToFile method	
}