/**
 * This class is the Instructions screen. It has information on controls, game modes, and over all game utility.
 * A button allows users to return to the main menu.
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class InstructionsScreen extends ScreenFrame implements ActionListener{
	private ImageIcon bg; //background image
	private PaintPanel canvas; //PaintPanel that the background image will be drawn on
	private JButton jbtMenu; //button to return to menu
	
	public InstructionsScreen(String title) {
		super(title);
		bg = new ImageIcon("images/bgInstructions.png"); //set background image
		canvas = new PaintPanel();
		canvas.setLayout(null); //set layout of canvas to null so we can manually set buttons
		//add a Menu button
		canvas.add(jbtMenu = addCustomButton("Menu", 700, 650, 150, 75, Color.blue, Color.green, new Font("Comic Sans MS", Font.BOLD, 25)));
		//register Action Listener for menu button
		jbtMenu.addActionListener(this);
		//add canvas to JFrame
		this.add(canvas);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtMenu) {
			new MenuScreen("Main Menu");
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
