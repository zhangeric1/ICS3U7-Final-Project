/**
 * This class is the menu screen of our game. It has 4 buttons that perform different actions (exiting, commencing gameplay, etc.).
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MenuScreen extends ScreenFrame implements ActionListener{
	//Instance variables//background image of menu screen
	private ImageIcon bg;
	private JButton jbtPlay ,jbtInstructions, jbtScores, jbtExit;
	private PaintPanel canvas; //all components are put on a PaintPanel which holds the background image
	private JLabel heading;
	
	/**  constructor */
	MenuScreen(String title){
		super(title);
		
		//set a background image
		bg = new ImageIcon("images/mole1.jpg");
		//instantiate canvas and set null layout manager of canvas so we can manually place buttons
		canvas = new PaintPanel();
		canvas.setLayout(null);
		this.add(canvas);
		
		//add a custom label for the heading
		canvas.add(heading = addCustomLabel("Welcome to Whack-A-Mole!", Color.black, new Font("Comic Sans MS", Font.BOLD, 60)));
		heading.setBounds(50, 25, 900, 150);
		
		//add the Play button
		jbtPlay = addCustomButton("Play", 750, 180, 200, 80, Color.blue, Color.green, new Font("Comic Sans MS", Font.PLAIN, 25));
		jbtPlay.addActionListener(this);
		canvas.add(jbtPlay);
		
		//add the Instructions button
		jbtInstructions = addCustomButton("Instructions", 750, 300, 200, 80, Color.blue, Color.green, new Font("Comic Sans MS", Font.PLAIN, 25));
		jbtInstructions.addActionListener(this);
		canvas.add(jbtInstructions);

		//add the Highscores button
		jbtScores = addCustomButton("Highscores", 750, 420, 200, 80, Color.blue, Color.green, new Font("Comic Sans MS", Font.PLAIN, 25));
		jbtScores.addActionListener(this);
		canvas.add(jbtScores);

		//add the Exit button
		jbtExit = addCustomButton("Exit", 750, 540, 200, 80, Color.blue, Color.green, new Font("Comic Sans MS", Font.PLAIN, 25));
		jbtExit.addActionListener(this);
		canvas.add(jbtExit);
		
	}

	/**
	 * This method is implemented from the ActionListener interface. Each button click decides a different scenario
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//different scenarios for each button
		if(e.getSource() == jbtPlay) {
			//create new instance of DifficultyScreen
			new DifficultyScreen("Difficulty Selection");
			this.dispose();
		}
		else if(e.getSource() == jbtInstructions) {
			
		}
		else if(e.getSource() == jbtScores) {
			//create new instance of ScoreScreen
			new ScoreScreen("High Scores");
			this.dispose(); //get rid of current JFrame
		}
		//exit button exits the program
		else if(e.getSource() == jbtExit) {
			//exit the game
			this.dispose();
		}
	}
	
	/*
	 * This class is a canvas that draws the background image. All components are added to this Panel, then the
	 * PaintPanel is added to the JFrame.
	 */
	class PaintPanel extends JPanel{
		protected void paintComponent(Graphics g){
			super.paintComponent(g); //override the paintComponent method
			//draw the background image
			g.drawImage(bg.getImage(),0,0,this.getWidth(),this.getHeight(),null);
		}
	}

}
