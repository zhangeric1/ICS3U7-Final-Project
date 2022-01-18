/**
 * This class creates a default Mole that is hidden (its is down in its hole). It can toggle between up and down sprites and gives 1 point
 * when hit.
 */
//import necessary packages
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Mole extends JButton implements ActionListener{
	private ImageIcon imgUp = new ImageIcon("images/normalMoleUp.PNG"), imgDown = new ImageIcon("images/moleDown.PNG");//sprites for different actions
	protected boolean isUp; //if mole is up
	
	//constructor for making a any Mole instance
	public Mole() {
		this.setDown(); //set mole down by default
		this.addActionListener(this); //register action listener with mole
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//when a mole is clicked
		if(e.getSource() == this) {
			//if the mole is up
			if(isUp) {
				EasyPlayScreen.points++; //accumulate points by 1
				this.setDown(); //set the mole down
			}
		}
		
	}
	
	/**
	 * This method sets the mole down by changing its icon and status
	 */
	protected void setDown() {
		this.setIcon(imgDown);
		isUp = false;
	}
	
	/**
	 * This method sets the mole up by changing its icon and status
	 */
	public void setUp() {
		this.setIcon(imgUp);
		isUp = true;
	}
	
}
