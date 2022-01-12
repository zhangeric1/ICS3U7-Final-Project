/**
 * This class is the Title Screen of our game. It has information on our project name, team members, teacher,
 * date, and course code. It also has a button to transport the user to the menu screen. This screen cannot be
 * returned to and only displays once every game.
 */
//import necessary packages
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class TitleScreen extends ScreenFrame implements ActionListener{
	//instance variables
	private JButton jbtNxt; //Next button
	//Constants for the title font and color so we can change them easily if needed
	private final Font TITLE_FONT = new Font("Comic Sans MS", Font.BOLD, 40);
	private final Color TITLE_COLOR = Color.black;
	
	//Constructor for TitleScreen
	public TitleScreen() {
		super(); //calls ScreenFrame constructor creating a new ScreenFrame
		
		//set layout manager and background color of TitleScreen
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 400, 30));
		this.getContentPane().setBackground(Color.lightGray);
		
		//This line creates a header line
		this.add(addDividerLabel());
		
		//Add Project name as a custom label (addCustomLabel was declared in ScreenFrame class so we inherit it)
		this.add(addCustomLabel("Final Project: Whack-a-Mole!", TITLE_COLOR, TITLE_FONT));
		//Add Students' names as a custom label
		this.add(addCustomLabel("Students: Eric Zhang and Victor Zhang", TITLE_COLOR, TITLE_FONT));
		//Add Teacher name as a custom label
		this.add(addCustomLabel("Teacher: Ms. Xie", TITLE_COLOR, TITLE_FONT));
		//Add Date of Completion as a custom label
		this.add(addCustomLabel("Jan 28, 2022", TITLE_COLOR, TITLE_FONT));
		//Add Course Code as a custom label
		this.add(addCustomLabel("ICS3U7-01", TITLE_COLOR, TITLE_FONT));
		
		//Button to go to MenuScreen
		jbtNxt = addCustomButton("Next", 200, 75, Color.blue, Color.cyan, new Font("Comic Sans MS", Font.BOLD, 20));
		jbtNxt.addActionListener(this); //register action listener so actions can be performed when pressed
		this.add(jbtNxt); //add Next button to the frame
		
		//This line creates a footer line
		this.add(addDividerLabel());	
		
		//Set Visible again because FlowLayout needs it to be set last
		this.setVisible(true);
	}//end of TitleScreen constructor

	/**
	 * This method returns a JLabel as a divider
	 * @return A cyan-colored divider label with the same font as the title font
	 */
	private JLabel addDividerLabel() {
		//create the custom divider using addCustomLabel method
		JLabel label = addCustomLabel("___________________________________", Color.cyan, TITLE_FONT);
		return label; //return divider label
	}//end of addDividerLabel method
	
	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//clicking on jbtNxt will take user to MenuScreen
		if(e.getSource() == jbtNxt) {
			this.dispose(); //get rid of current frame
			new MenuScreen(); //create new instance of MenuScreen with title
		}
	}//end of actionPerformed method
	
}
