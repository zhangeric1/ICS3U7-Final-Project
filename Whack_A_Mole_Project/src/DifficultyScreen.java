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
		
		
		canvas = new PaintPanel();
		canvas.setLayout(null);
		this.add(canvas);
		
		bgLabel = addCustomLabel("Select The Difficulty", Color.black, new Font("MV Boli", Font.BOLD, 50));
		bgLabel.setBounds(100, -200, this.getWidth() - 1, this.getHeight() - 1 );
		canvas.add(bgLabel);
		
		btn1 = addCustomButton("Easy", 25, 300, 300, 200, Color.blue, Color.cyan, new Font("Comic Sans MS", Font.PLAIN, 25));
		btn1.addActionListener(this);
		canvas.add(btn1);
		
		btn2 = addCustomButton("Medium", 350, 300, 300, 200, Color.blue, Color.cyan, new Font("Comic Sans MS", Font.PLAIN, 25));
		btn2.addActionListener(this);
		canvas.add(btn2);
		
		btn3 = addCustomButton("Hard", 675, 300, 300, 200, Color.blue, Color.cyan, new Font("Comic Sans MS", Font.PLAIN, 25));
		btn3.addActionListener(this);
		canvas.add(btn3);
		
		btn4 = addCustomButton("Back", 750, 650, 200, 80, Color.blue, Color.cyan, new Font("Comic Sans MS", Font.PLAIN, 25));
		btn4.addActionListener(this);
		canvas.add(btn4);
		
		//this.setResizable(false);
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
			super.paintComponent(g);
			
		}
	}

}
