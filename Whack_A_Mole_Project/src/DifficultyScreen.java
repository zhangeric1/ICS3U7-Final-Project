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
	//private ImageIcon bg; //bg will be used once an appropriate image is found
	private JButton jbtEasy, jbtMedium, jbtHard, jbtMenu;
	private PaintPanel canvas = new PaintPanel(); //all components are put on a PaintPanel which holds the background image (bg)
	private JLabel label; //text label
	private final Color DIFFICULTY_COLOR_FG = Color.blue, DIFFICULTY_COLOR_BG = Color.cyan; //constant colors of difficulty button foreground and background respectively
	private final Font DIFFICULTY_FONT = new Font("Comic Sans MS", Font.PLAIN, 25); //constant font of difficulty buttons
	
	//Constructor for DifficultyScreen:
	DifficultyScreen(){
		super(); //calls ScreenFrame constructor creating a new ScreenFrame
		
		//set layout of canvas so we can add buttons manually
		canvas.setLayout(null);
		this.add(canvas); //add canvas to DifficultyScreen
		
		//Label prompting the user to press a button
		label = addCustomLabel("Select The Difficulty", Color.black, new Font("MV Boli", Font.BOLD, 50));
		//Sets bounds of the label
		label.setBounds(100, -200, this.getWidth() - 1, this.getHeight() - 1 );
		canvas.add(label); //add label to canvas
		
		//Add custom button for easy mode
		jbtEasy = addCustomButton("Easy", 25, 300, 300, 200, DIFFICULTY_COLOR_FG, DIFFICULTY_COLOR_BG, DIFFICULTY_FONT);
		jbtEasy.addActionListener(this); //register action listener
		canvas.add(jbtEasy); //add button to canvas
		
		//Add custom button for medium mode
		jbtMedium = addCustomButton("Medium", 350, 300, 300, 200, DIFFICULTY_COLOR_FG, DIFFICULTY_COLOR_BG, DIFFICULTY_FONT);
		jbtMedium.addActionListener(this); //register action listener
		canvas.add(jbtMedium); //add button to canvas
		
		//Add custom button for hard mode
		jbtHard = addCustomButton("Hard", 675, 300, 300, 200, DIFFICULTY_COLOR_FG, DIFFICULTY_COLOR_BG, DIFFICULTY_FONT);
		jbtHard.addActionListener(this); //register action listener
		canvas.add(jbtHard); //add button to canvas
		
		//Add custom button to return to menu
		jbtMenu = addCustomButton("Menu", 750, 650, 200, 80, DIFFICULTY_COLOR_FG, DIFFICULTY_COLOR_BG, DIFFICULTY_FONT);
		jbtMenu.addActionListener(this); //register action listener
		canvas.add(jbtMenu); //add button to canvas
		
	}//end of DifficultyScreen constructor

	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtEasy) {
			
		}
		else if(e.getSource() == jbtMedium) {
			
		}
		else if(e.getSource() == jbtHard) {
			
		}
		else if(e.getSource() == jbtMenu) {
			//create new instance of MenuScreen class
			new MenuScreen();
			this.dispose(); //get rid of current frame
		}

	}//end of actionPerformed method
	
	/*
	 * This class is a canvas that draws the background image. All components are added to this Panel, then the
	 * PaintPanel is added to the JFrame.
	 */
	class PaintPanel extends JPanel{
		protected void paintComponent(Graphics g){
			//Prints the canvas that holds the buttons and label
			super.paintComponent(g);
			
		}//end of paintComponent method
	}

}