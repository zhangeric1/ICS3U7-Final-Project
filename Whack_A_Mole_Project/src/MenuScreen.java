import javax.swing.*;
import java.awt.*;

public class MenuScreen extends ScreenFrame{
	private ImageIcon bg;
	private JButton btn1 ,btn2, btn3, btn4;
	
	/**  constructor */
	MenuScreen(String title){
		super(title);
		
		bg = new ImageIcon("images/download.jpg");
		setLayout(null);
		btn1 = new JButton("Play");
		btn1.setLocation (750, 180);
		btn1.setSize (200, 80) ;
		add(btn1);

		btn2 = new JButton("Instructions");
		btn2.setLocation (750, 300);
		btn2.setSize (200, 80) ;
		add(btn2);

		btn3 = new JButton("Highscores");
		btn3.setLocation (750, 420);
		btn3.setSize (200, 80) ;
		add(btn3);

		btn4 = new JButton("Exit");
		btn4.setLocation (750, 540);
		btn4.setSize (200, 80) ;
		add(btn4);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bg.getImage(),0,0,this.getWidth(),this.getHeight(),null);

	}

}
