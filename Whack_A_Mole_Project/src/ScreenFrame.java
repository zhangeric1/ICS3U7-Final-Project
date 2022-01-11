/**
 * This class is a general format for all screens (which will be JFames) in our game. For example, it sets
 * a definite size, default close operation, etc. It also contains general methods for creating custom JButtons
 * and JLabels that all game screens may use.
 */
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public abstract class ScreenFrame extends JFrame{
	
	//Constructor: Defines state/behavior that all child frames will inherit
	public ScreenFrame() {
		super("Whack-a-Mole"); //creates a JFrame with specified title
		this.setSize(1000, 800); //setting size of all game screens
		this.setResizable(false); //user cannot resize frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set default close operation
		this.setVisible(true); //set visibility
	}
	
	/**
	 * This method creates a custom JButton
	 * @param text Text to be put on button
	 * @param x X coordinate of button
	 * @param y Y coordinate of button
	 * @param width Width of button
	 * @param height Height of button
	 * @param fg Foreground color
	 * @param bg Background color
	 * @param font Font of button
	 * @return Customized JButton
	 */
	protected JButton addCustomButton(String text, int x, int y, int width, int height, Color fg, Color bg, Font font) {
		JButton button = new JButton(text);
		button.setBounds(x, y, width, height);
		button.setForeground(fg);
		button.setBackground(bg);
		button.setFont(font);
		button.setFocusable(false);
		return button;
	}//end of addCustomButton method
	
	/**
	 * This method creates a custom JButton without x and y coordinates in case the JButton is being 
	 * placed with a layout manager
	 * @param text Text to be put on button
	 * @param width Width of button
	 * @param height Height of button
	 * @param fg Foreground color
	 * @param bg Background color
	 * @param font Font of button
	 * @return Customized JButton
	 */
	protected JButton addCustomButton(String text, int width, int height, Color fg, Color bg, Font font) {
		JButton button = new JButton(text);
		button.setPreferredSize(new Dimension(width, height));
		button.setForeground(fg);
		button.setBackground(bg);
		button.setFont(font);
		button.setFocusable(false);
		return button;
	}//end of addCustomButton method
	
	/**
	 * This method creates a custom JLabel
	 * @param text Text to be put on label
	 * @param fg Foreground color
	 * @param font Font of label
	 * @return Customized JLabel
	 */
	protected JLabel addCustomLabel(String text, Color fg, Font font) {
		JLabel label = new JLabel(text);
		label.setForeground(fg);
		label.setFont(font);
		return label;
	}//end of addCustomLabel method
	
}
