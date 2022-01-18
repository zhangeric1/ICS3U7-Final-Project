/**
 * This class creates a SabotageMole which inherits information from Mole but has a different sprite when visible and takes away 2
 * points when hit.
 */
//import necessary packages
import java.awt.event.*;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class SabotageMole extends Mole implements ActionListener{
	private ImageIcon imgUp = new ImageIcon("images/sabotageMoleUp.PNG"); ; //sprite for when mole is up
	
	public SabotageMole() {
		super(); //calls default mole constructor
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//when a mole is clicked
		if(e.getSource() == this) {
			//if the mole is up
			if(isUp) {
				EasyPlayScreen.points -= 2; //subtract points by 2
				this.setDown(); //set the mole down
			}
		}
		
	}
	
	/**
	 * This method sets the mole up by changing its icon and status. We override it in teh child class because we have a different imgUp
	 */
	public void setUp() {
		this.setIcon(imgUp);
		isUp = true;
	}
}
