/**
 * This class is the Instructions screen. It has information on controls, game modes, and general game utility.
 */
//import necessary packages
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class InstructionsScreen extends ScreenFrame implements ActionListener{
	private ImageIcon bg; //background image
	private PaintPanel canvas; //PaintPanel that the background image will be drawn on
	private JButton jbtMenu; //button to return to menu

	/**
	 * Constructor for InstructionsScreen
	 */
	public InstructionsScreen() {
		bg = new ImageIcon("images/bgInstructions.png"); //set background image
		canvas = new PaintPanel();
		canvas.setLayout(null); //set layout of canvas to null so we can manually set buttons
		//add a Menu button
		canvas.add(jbtMenu = addCustomButton("Menu", 750, 650, 200, 80, Color.blue, Color.cyan, new Font("Comic Sans MS", Font.PLAIN, 25)));
		//register Action Listener for menu button
		jbtMenu.addActionListener(this);
		//add canvas to JFrame
		this.add(canvas);
	}//end of InstructionsScreen constructor

	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtMenu) { //menu button
			new MenuScreen(); //new MenuScreen instance
			this.dispose(); //dispose of current frame
		}
	}//end of actionPerformed method

	/**
	 * This class is a canvas that draws the background image. All components are added to this Panel, then the
	 * PaintPanel is added to the JFrame.
	 */
	class PaintPanel extends JPanel{
		protected void paintComponent(Graphics g){
			super.paintComponent(g); //override the paintComponent method
			//draw the background image
			g.drawImage(bg.getImage(),0,0,this.getWidth(),this.getHeight(),null);
		}//end of paintComponent method
	}
}