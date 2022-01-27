/**
 * This class creates a default normal Mole that is hidden (in its hole). It can toggle between mole types (normal, super, or sabotage) and has different sprites for each.
 * each mole type results in a different number of points incremented/decremented.
 */
//import necessary packages
import javax.swing.*;

@SuppressWarnings("serial")
public class Mole extends JButton{
	private ImageIcon imgNormalUp = new ImageIcon("images/normalMoleUp.PNG"); //sprite for normal mole
	private ImageIcon imgSuperUp = new ImageIcon("images/superMoleUp.PNG");//sprite for super mole
	private ImageIcon imgSabotageUp = new ImageIcon("images/sabotageMoleUp.PNG");//sprite for sabotage mole
	private ImageIcon imgDown = new ImageIcon("images/moleDown.PNG");//sprite for hidden mole
	public boolean isUp; //if mole is up
	//booleans show the state of the mole
	private boolean isSuper;
	private boolean isSabotage;
	private boolean isNormal;

	/**
	 * Constructor for Mole
	 */
	public Mole() {
		this.setDown(); //set mole down by default
		this.isNormal = true; //set as normal type by default
		this.isSuper = false;
		this.isSabotage = false;
	}

	/**
	 * This method sets the mole down by changing its icon and status
	 */
	public void setDown() {
		this.setIcon(imgDown); //switch icon
		isUp = false; //switch status
	}//end of setDown method

	/**
	 * This method sets the mole up by changing its icon and status
	 */
	public void setUp() {
		//each mole type has its own icon
		if(this.isNormal) { 
			this.setIcon(imgNormalUp); //set as normal mole icon
		}
		else if(this.isSuper) {
			this.setIcon(imgSuperUp);//set as super mole icon
		}
		else if(this.isSabotage) {
			this.setIcon(imgSabotageUp);//set as sabotage mole icon
		}
		isUp = true; //switch status
	}//end of setUp method

	/**
	 * This method sets the mole's state as normal
	 */
	public void setNormal() {
		this.isNormal = true;
		this.isSuper = false;
		this.isSabotage = false;
	}//end of setNormal method

	/**
	 * This method sets the mole's state as super
	 */
	public void setSuper() {
		this.isNormal = false;
		this.isSuper = true;
		this.isSabotage = false;
	}//end of setSuper method

	/**
	 * This method sets the mole's state as super
	 */
	public void setSabotage() {
		this.isNormal = false;
		this.isSuper = false;
		this.isSabotage = true;
	}//end of setSabotage method

	/**
	 * This method retrieves the state of a mole
	 * @return an integer representing the mole's state
	 */
	public int getState() {
		if(this.isNormal) { //normal state returns 1
			return 1;
		}
		else if(this.isSuper) {//super state return 2
			return 2;
		}
		else{//sabotage state returns 3
			return 3;
		}
	}//end of getState method
}