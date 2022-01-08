/**
 * This class is the Title Screen of our game. It has information on our project name, team members, teacher,
 * date, and course code. It also has a button to transport the user to the menu screen. This screen cannot be
 * returned to and only displays once every game.
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class TitleScreen extends ScreenFrame implements ActionListener{
	//instance variables
	private JLabel label;
	private JButton jbtNxt;
	//Constants for the title font and color so we can change them easily if needed
	private final Font TITLE_FONT = new Font("Comic Sans", Font.BOLD, 40);
	private final Color TITLE_COLOR = Color.black;
	
	public TitleScreen(String title) {
		super(title); //calls ScreenFrame constructor creating a new JFrame
		
		//set layout manager and background color of TitleScreen
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 400, 30));
		this.getContentPane().setBackground(Color.lightGray);
		
		//Add labels (title, students, teacher, date, course code) and align them
		this.add(label = addCustomLabel("Final Project: Whack-a-Mole!", TITLE_COLOR, TITLE_FONT));
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label = addCustomLabel("Students: Eric Zhang and Victor Zhang", TITLE_COLOR, TITLE_FONT));
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label = addCustomLabel("Teacher: Ms. Xie", TITLE_COLOR, TITLE_FONT));
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label = addCustomLabel("Jan 28, 2022", TITLE_COLOR, TITLE_FONT));
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label = addCustomLabel("ICS3U7-01", TITLE_COLOR, TITLE_FONT));
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		//Next button to go to MenuScreen
		jbtNxt = addCustomButton("Next", 200, 75, Color.black, Color.cyan, new Font("Comic Sans", Font.BOLD, 20));
		jbtNxt.addActionListener(this);
		this.add(jbtNxt);
		
		//Set Visible again because FlowLayout needs it to be set last
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//clicking on jbtNxt will take user to MenuScreen
		if(e.getSource() == jbtNxt) {
			this.dispose();
			new MenuScreen("Menu");
		}
	}
	
}
