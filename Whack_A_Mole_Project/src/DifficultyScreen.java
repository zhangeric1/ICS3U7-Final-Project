import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class DifficultyScreen extends ScreenFrame implements ActionListener{
	private ImageIcon bg;
	private JButton btn1, btn2, btn3, btn4;
	PaintPanel canvas = new PaintPanel(); //all components are put on a PaintPanel which holds the background image
	
	private JLabel bgLabel;
	
	/**  constructor */
	DifficultyScreen(){
		super();
		
		canvas.setLayout(null);
		this.add(canvas);
		
		//Label prompting the user to press a button
		bgLabel = addCustomLabel("Select The Difficulty", Color.black, new Font("MV Boli", Font.BOLD, 50));
		bgLabel.setBounds(100, -200, this.getWidth() - 1, this.getHeight() - 1 );
		canvas.add(bgLabel);
		//Button for easy mode
		btn1 = addCustomButton("Easy", 25, 300, 300, 200, Color.blue, Color.cyan, new Font("Comic Sans MS", Font.PLAIN, 25));
		btn1.addActionListener(this);
		canvas.add(btn1);
		//Button for medium mode
		btn2 = addCustomButton("Medium", 350, 300, 300, 200, Color.blue, Color.cyan, new Font("Comic Sans MS", Font.PLAIN, 25));
		btn2.addActionListener(this);
		canvas.add(btn2);
		//Button for hard mode
		btn3 = addCustomButton("Hard", 675, 300, 300, 200, Color.blue, Color.cyan, new Font("Comic Sans MS", Font.PLAIN, 25));
		btn3.addActionListener(this);
		canvas.add(btn3);
		//Return to menu button
		btn4 = addCustomButton("Menu", 750, 650, 200, 80, Color.blue, Color.cyan, new Font("Comic Sans MS", Font.PLAIN, 25));
		btn4.addActionListener(this);
		canvas.add(btn4);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			
		}
		else if(e.getSource() == btn2) {
			
		}
		else if(e.getSource() == btn3) {
			
		}
		else if(e.getSource() == btn4) {
			new MenuScreen();
			this.dispose();
		}

	}
	
	class PaintPanel extends JPanel{
		protected void paintComponent(Graphics g){
			//Prints the canvas that holds the buttons and label
			super.paintComponent(g);
			
		}
	}

}
