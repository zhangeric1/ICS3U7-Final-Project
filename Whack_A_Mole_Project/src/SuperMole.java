/**
 * This class creates a SuperMole which inherits information from Mole but has a different sprite when visible and gives 2 points when hit.
 */
//import necessary packages
import java.awt.event.*;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class SuperMole extends Mole implements ActionListener{
	private ImageIcon imgUp = new ImageIcon("images/superMoleUp.PNG"); ; //sprite for when mole is up
	
	public SuperMole() {
		super(); //calls default mole constructor
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//when a mole is clicked
		if(e.getSource() == this) {
			//if the mole is up
			if(isUp) {
				EasyPlayScreen.points += 2; //accumulate points by 2
				this.setDown(); //set the mole down
			}
		}
		
	}
	
	/**
	 * This method sets the mole up by changing its icon and status. We override it in the child class because we have a different imgUp
	 */
	public void setUp() {
		this.setIcon(imgUp);
		isUp = true;
	}
}
