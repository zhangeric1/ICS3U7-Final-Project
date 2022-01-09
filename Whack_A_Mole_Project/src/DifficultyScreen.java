import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class DifficultyScreen extends ScreenFrame implements ActionListener{
	private ImageIcon bg;
	private JButton btn1 ,btn2, btn3, btn4;
	//PaintPanel canvas = new PaintPanel(); //all components are put on a PaintPanel which holds the background image
	
	private JLabel bgLabel;
	
	/**  constructor */
	DifficultyScreen(String title){
		super(title);
		
		//bg = new ImageIcon("images/MBackground.jpg");
		bgLabel = addCustomLabel("Select The Difficulty", Color.black, new Font("MV Boli", Font.BOLD, 50));
		bgLabel.setIcon(bg);
		bgLabel.setHorizontalTextPosition(JLabel.CENTER);
		bgLabel.setVerticalTextPosition(JLabel.TOP);
		bgLabel.setIconTextGap(190);
		this.add(bgLabel);
		bgLabel.setBounds(100, -200, this.getWidth() - 1, this.getHeight() - 1 );
		this.getContentPane().setBackground(Color.lightGray);
		
		//canvas = new PaintPanel();
		//this.add(canvas, BorderLayout.CENTER);
		//canvas.setLayout(null);
		this.setLayout(null);		
		btn1 = addCustomButton("Easy", 25, 300, 300, 200, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn1.addActionListener(this);
		add(btn1);
		
		btn2 = addCustomButton("Medium", 350, 300, 300, 200, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn2.addActionListener(this);
		add(btn2);
		
		btn3 = addCustomButton("Hard", 675, 300, 300, 200, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn3.addActionListener(this);
		add(btn3);
		
		btn4 = addCustomButton("Back", 750, 650, 200, 80, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn4.addActionListener(this);
		add(btn4);
		
		this.setResizable(false);
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
			new MenuScreen("Back");
			this.dispose();
		}

	}
	
	/*class PaintPanel extends JPanel{
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(bg.getImage(),0,0,this.getWidth(),this.getHeight(),null);
		}
	}*/
	class PaintPanel extends JPanel{
		public void paint(Graphics g){
			Graphics2D g2D = (Graphics2D) g;
			g2D.drawImage(bg.getImage(),0,0,this.getWidth(),this.getHeight(),null);
		}
	}

}
