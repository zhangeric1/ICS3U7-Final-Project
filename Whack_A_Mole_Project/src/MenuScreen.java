import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MenuScreen extends ScreenFrame implements ActionListener{
	private ImageIcon bg;
	private JButton btn1 ,btn2, btn3, btn4;
	//PaintPanel canvas = new PaintPanel(); //all components are put on a PaintPanel which holds the background image
	
	private JLabel bgLabel;
	
	/**  constructor */
	MenuScreen(String title){
		super(title);
		
		bg = new ImageIcon("images/mole1.jpg");
		bgLabel = addCustomLabel("Welcome to Whack-A-Mole!", Color.black, new Font("MV Boli", Font.BOLD, 50));
		bgLabel.setIcon(bg);
		bgLabel.setHorizontalTextPosition(JLabel.CENTER);
		bgLabel.setVerticalTextPosition(JLabel.TOP);
		bgLabel.setIconTextGap(150);
		this.add(bgLabel);
		bgLabel.setBounds(50, 0, this.getWidth() - 1, this.getHeight() - 1 );
		this.getContentPane().setBackground(Color.lightGray);
		
		//canvas = new PaintPanel();
		//this.add(canvas, BorderLayout.CENTER);
		//canvas.setLayout(null);
		this.setLayout(null);		
		btn1 = addCustomButton("Play", 750, 180, 200, 80, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn1.addActionListener(this);
		add(btn1);
		
		btn2 = addCustomButton("Instructions", 750, 300, 200, 80, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn2.addActionListener(this);
		add(btn2);

		btn3 = addCustomButton("Highscores", 750, 420, 200, 80, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn3.addActionListener(this);
		add(btn3);

		btn4 = addCustomButton("Exit", 750, 540, 200, 80, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn4.addActionListener(this);
		this.add(btn4);
		
		
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			
		}
		else if(e.getSource() == btn2) {
			
		}
		else if(e.getSource() == btn3) {
			new ScoreScreen("High Scores");
			this.dispose();
		}
		//exit button exits the program
		else if(e.getSource() == btn4) {
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
