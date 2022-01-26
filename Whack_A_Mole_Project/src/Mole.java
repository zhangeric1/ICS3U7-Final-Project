/**
 * This class creates a default Mole that is hidden (its is down in its hole). It can toggle between up and down sprites and gives 1 point
 * when hit.
 */
import javax.swing.*;

@SuppressWarnings("serial")
public class Mole extends JButton{
	private ImageIcon imgNormalUp = new ImageIcon("images/normalMoleUp.PNG"), imgDown = new ImageIcon("images/moleDown.PNG");//sprites for different actions
	private ImageIcon imgSuperUp = new ImageIcon("images/superMoleUp.PNG");
	private ImageIcon imgSabotageUp = new ImageIcon("images/sabotageMoleUp.PNG");
	public boolean isUp; //if mole is up
	private boolean isSuper;
	private boolean isSabotage;
	private boolean isNormal;
	
	//constructor for making a any Mole instance
	public Mole() {
		this.setDown(); //set mole down by default
		this.isNormal = true;
		this.isSuper = false;
		this.isSabotage = false;
	}
	
	
	/**
	 * This method sets the mole down by changing its icon and status
	 */
	public void setDown() {
		this.setIcon(imgDown);
		isUp = false;
	}
	
	/**
	 * This method sets the mole up by changing its icon and status
	 */
	public void setUp() {
		if(this.isNormal) {
			this.setIcon(imgNormalUp);
		}
		else if(this.isSuper) {
			this.setIcon(imgSuperUp);
		}
		else if(this.isSabotage) {
			this.setIcon(imgSabotageUp);
		}
		isUp = true;
	}
	
	public void setNormal() {
		this.isNormal = true;
		this.isSuper = false;
		this.isSabotage = false;
	}
	
	public void setSuper() {
		this.isSuper = true;
		this.isNormal = false;
		this.isSabotage = false;
	}
	
	public void setSabotage() {
		this.isSuper = false;
		this.isNormal = false;
		this.isSabotage = true;
	}
	
	public int getState() {
		if(this.isNormal) {
			return 1;
		}
		else if(this.isSuper) {
			return 2;
		}
		else{
			return 3;
		}
	}
}