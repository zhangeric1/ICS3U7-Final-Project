/**
 * This is our difficulty selection screen. After selecting a difficulty level, the user is moved into that game mode.
 * The user can also choose to move back to the main menu.
 */
//import necessary packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class DifficultyScreen extends ScreenFrame implements ActionListener{
	//Instance variables
	private JButton jbtEasy, jbtMedium, jbtHard, jbtMenu; //buttons for different actions
	private JLabel label; //text label
	private static final Color DIFFICULTY_COLOR_FG = Color.blue, DIFFICULTY_COLOR_BG = Color.cyan; //constant colors of difficulty button foreground and background respectively
	private static final Font DIFFICULTY_FONT = new Font("Comic Sans MS", Font.PLAIN, 25); //constant font of difficulty buttons
	public static int diff; //variable to store the difficulty levelfor later use

	/**
	 * Constructor for DifficultyScreen
	 */
	DifficultyScreen(){		
		//set background color of frame
		this.getContentPane().setBackground(BG_COLOR);
		//set layout of frame to null so we can add buttons manually
		this.setLayout(null);

		//Label prompting the user to press a button
		label = addCustomLabel("Select the Difficulty", Color.cyan, new Font("Comic Sans MS", Font.BOLD, 50));
		//Sets bounds of the label
		label.setBounds(100, -200, this.getWidth() - 1, this.getHeight() - 1 );
		this.add(label); //add label to frame

		//Add custom button for easy mode
		jbtEasy = addCustomButton("Easy", 25, 300, 300, 200, DIFFICULTY_COLOR_FG, DIFFICULTY_COLOR_BG, DIFFICULTY_FONT);
		jbtEasy.addActionListener(this); //register action listener
		this.add(jbtEasy); //add button to frame

		//Add custom button for medium mode
		jbtMedium = addCustomButton("Medium", 350, 300, 300, 200, DIFFICULTY_COLOR_FG, DIFFICULTY_COLOR_BG, DIFFICULTY_FONT);
		jbtMedium.addActionListener(this); //register action listener
		this.add(jbtMedium); //add button to frame

		//Add custom button for hard mode
		jbtHard = addCustomButton("Hard", 675, 300, 300, 200, DIFFICULTY_COLOR_FG, DIFFICULTY_COLOR_BG, DIFFICULTY_FONT);
		jbtHard.addActionListener(this); //register action listener
		this.add(jbtHard); //add button to frame

		//Add custom button to return to menu
		jbtMenu = addCustomButton("Menu", 750, 650, 200, 80, DIFFICULTY_COLOR_FG, DIFFICULTY_COLOR_BG, DIFFICULTY_FONT);
		jbtMenu.addActionListener(this); //register action listener
		this.add(jbtMenu); //add button to frame
	}//end of DifficultyScreen constructor

	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtEasy) {//easy button
			diff = 1; //set the difficulty (will be used to determine later actions)
			new EasyPlayScreen(); //new instance of EasyPlayScreen
			this.dispose(); //dispose of current frame
		}
		if(e.getSource() == jbtMedium) {//medium button
			diff = 2; //set the difficulty
			new MediumPlayScreen();//new instance of MediumPlayScreen
			this.dispose();//dispose of current frame
		}
		if(e.getSource() == jbtHard) {//hard button
			diff = 3; //set the difficulty
			new HardPlayScreen();//new instance of HardPlayScreen
			this.dispose();//dispose of current frame
		}
		if(e.getSource() == jbtMenu) {//menu button
			//create new instance of MenuScreen class
			new MenuScreen();
			this.dispose(); //get rid of current frame
		}
	}//end of actionPerformed method
}