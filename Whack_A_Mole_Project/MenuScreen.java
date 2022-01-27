/**
 * This class is the menu screen of our game. It has 4 buttons that perform different actions (exiting, commencing game, etc.).
 */
//import necessary packages
import java.awt.*; 
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MenuScreen extends ScreenFrame implements ActionListener{
	//Instance variables
	private ImageIcon bgGif; //background GIF to be put on a label on the main menu
	private JButton jbtPlay, jbtInstructions, jbtScores, jbtExit; //action buttons
	private JLabel heading, labelGif; //the heading label of the Main Menu and the label that will hold bgGif
	private final Color MENU_COLOR_FG = Color.blue, MENU_COLOR_BG = Color.cyan; //constant colors of menu button foreground and background respectively
	private final Font MENU_FONT = new Font("Comic Sans MS", Font.PLAIN, 25); //constant font of menu buttons

	/**
	 * Constructor for MenuScreen
	 */
	public MenuScreen(){	
		//*********************************************************************Start of taken code
		/*This code plays a sound effect when the mole is hit. I took the code from 1st answer on:
		 * https://stackoverflow.com/questions/15526255/best-way-to-get-sound-on-button-press-for-a-java-calculator
		 * I edited it using Eclipse's suggestions
		 */
		String soundName = "sounds/MainMenu.wav";   
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
		clip.loop(Clip.LOOP_CONTINUOUSLY);//loops music continuously
		clip.start();
		//*************************************************************End of taken code
		
		//set layout manager of JFrame as null so we can manually place buttons.
		this.setLayout(null);
		//set background color of JFrame
		this.getContentPane().setBackground(BG_COLOR);

		//A background GIF
		bgGif = new ImageIcon("images/gifMenu.gif"); //set image of bgGif
		labelGif = new JLabel(bgGif); //GIFs must be placed on JLabels for successful animation
		labelGif.setBounds(130, 250, 500, 400); //set bounds of bgGif
		this.add(labelGif); //add to frame

		//add a custom label for the heading
		this.add(heading = addCustomLabel("Welcome to Whack-A-Mole!", Color.cyan, new Font("Comic Sans MS", Font.BOLD, 60)));
		heading.setBounds(50, 25, 900, 150); //set bounds for the heading on the frame

		//add the Play button
		jbtPlay = addCustomButton("Play", 750, 180, 200, 80, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		jbtPlay.addActionListener(this); //register action listener
		this.add(jbtPlay); //add to frame

		//add the Instructions button
		jbtInstructions = addCustomButton("Instructions", 750, 300, 200, 80, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		jbtInstructions.addActionListener(this); //register action listener
		this.add(jbtInstructions); //add to frame

		//add the Scores button
		jbtScores = addCustomButton("Scores", 750, 420, 200, 80, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		jbtScores.addActionListener(this); //register action listener
		this.add(jbtScores); //add to frame

		//add the Exit button
		jbtExit = addCustomButton("Exit", 750, 540, 200, 80, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		jbtExit.addActionListener(this); //register action listener
		this.add(jbtExit); //add to frame

	}//end of MenuScreen constructor

	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//different scenarios for each button
		if(e.getSource() == jbtPlay) {
			//create new instance of DifficultyScreen
			new DifficultyScreen();
			this.dispose(); //get rid of current frame
		}
		else if(e.getSource() == jbtInstructions) {
			//create new instance of InstructionsScreen
			new InstructionsScreen();
			this.dispose(); //get rid of current frame
		}
		else if(e.getSource() == jbtScores) {
			//create new instance of ScoreScreen
			new ScoreScreen();
			this.dispose(); //get rid of current frame
		}
		//exit button exits the program
		else if(e.getSource() == jbtExit) {
			//exit the program
			System.exit(0);
		}
	}//end of actionPerformed method

}