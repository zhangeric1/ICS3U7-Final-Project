import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class NumOfPlayersScreen extends ScreenFrame implements ActionListener{
	private ImageIcon bg;
	private JButton btn1 ,btn2, btn3;
	//PaintPanel canvas = new PaintPanel(); //all components are put on a PaintPanel which holds the background image
	
	private JLabel bgLabel;
	
	/**  constructor */
	NumOfPlayersScreen(String title){
		super(title);
		
		//bg = new ImageIcon("images/MBackground.jpg");
		bgLabel = addCustomLabel("Select The Number of Players", Color.black, new Font("MV Boli", Font.BOLD, 50));
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
		btn1 = addCustomButton("Singleplayer", 100, 300, 300, 200, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn1.addActionListener(this);
		add(btn1);
		
		btn2 = addCustomButton("2 players", 600, 300, 300, 200, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn2.addActionListener(this);
		add(btn2);
		
		btn3 = addCustomButton("Back", 750, 650, 200, 80, Color.blue, Color.green, new Font("Comic Sans", Font.PLAIN, 25));
		btn3.addActionListener(this);
		add(btn3);
		
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			new DifficultyScreen("SinglePlayer");
			this.dispose();
		}
		else if(e.getSource() == btn2) {
			
		}
		else if(e.getSource() == btn3) {
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