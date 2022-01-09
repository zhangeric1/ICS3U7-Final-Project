/**
 * This class is the menu screen of our game. It has 4 buttons that perform different actions (exiting, commencing gameplay, etc.).
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MenuScreen extends ScreenFrame implements ActionListener{
	//Instance variables
	private ImageIcon bg;
	private JButton btn1 ,btn2, btn3, btn4;
	//PaintPanel canvas = new PaintPanel(); //all components are put on a PaintPanel which holds the background image but it doesn't work
	
	private JLabel bgLabel;
	
	/**  constructor */
	MenuScreen(String title){
		super(title);
		
		//This block of code is for setting an image in the screen (I do not know how to set a background image)
		bg = new ImageIcon("images/mole1.jpg");
		bgLabel = addCustomLabel("Welcome to Whack-A-Mole!", Color.black, new Font("MV Boli", Font.BOLD, 50));
		bgLabel.setIcon(bg);
		bgLabel.setHorizontalTextPosition(JLabel.CENTER);
		bgLabel.setVerticalTextPosition(JLabel.TOP);
		bgLabel.setIconTextGap(150);
		this.add(bgLabel);
		bgLabel.setBounds(50, 0, this.getWidth() - 1, this.getHeight() - 1 );
		this.getContentPane().setBackground(Color.lightGray);
		
		//This code was to create a PaintPanel which I made at the bottom of the code but it doesn't work for some reason
		//canvas = new PaintPanel();
		//this.add(canvas, BorderLayout.CENTER);
		//canvas.setLayout(null);
		
		//set null layout manager ofr MenuScreen so we can manually place buttons
		this.setLayout(null);	
		
		//add the Play button
		btn1 = addCustomButton("Play", 750, 180, 200, 80, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn1.addActionListener(this);
		add(btn1);
		
		//add the Instructions button
		btn2 = addCustomButton("Instructions", 750, 300, 200, 80, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn2.addActionListener(this);
		add(btn2);

		//add the Highscores button
		btn3 = addCustomButton("Highscores", 750, 420, 200, 80, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn3.addActionListener(this);
		add(btn3);

		//add the Exit button
		btn4 = addCustomButton("Exit", 750, 540, 200, 80, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn4.addActionListener(this);
		add(btn4);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//different scenarios for each button
		if(e.getSource() == btn1) {
			new DifficultyScreen("Play");
			this.dispose();
		}
		else if(e.getSource() == btn2) {
			
		}
		else if(e.getSource() == btn3) {
			//create new instance of ScoreScreen
			new ScoreScreen("High Scores");
			this.dispose(); //get rid of current JFrame
		}
		//exit button exits the program
		else if(e.getSource() == btn4) {
			//exit the game
			this.dispose();
		}
	}
	
	//This is a class that uses paintComponent to make a background image but it doesn't work for some reason
	//What I did was make an instance of this PaintPanel, then add everything on to it (buttons, etc) but it doesn't work
	//So I deleted the code which is why you only see it here
	/*class PaintPanel extends JPanel{
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(bg.getImage(),0,0,this.getWidth(),this.getHeight(),null);
		}
	}*/
	
	//I tried something different here I found online but it still doesn't work
	/*
	class PaintPanel extends JPanel{
		public void paint(Graphics g){
			Graphics2D g2D = (Graphics2D) g;
			g2D.drawImage(bg.getImage(),0,0,this.getWidth(),this.getHeight(),null);
		}
	}*/

}
