import javax.swing.*;

@SuppressWarnings("serial")
public class MenuScreen extends ScreenFrame{
	ImageIcon bg;
	JButton btn1 ,btn2, btn3, btn4;
	//JPanel canvas = new paintPanel(); //all components are put on a paintPanel which holds the background image
	
	/**  constructor */
	MenuScreen(String title){
		super(title);
		bg = new ImageIcon("images/download.jpg");
		//canvas = new paintPanel();
		//this.add(canvas, BorderLayout.CENTER);
		//canvas.setLayout(null);
		this.setLayout(null);
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
		this.add(btn4);
		
		// Problem: without this line, the program gets weird. Instead of showing all the 4 buttons, they only appear when you hover over them, so I added this line and
		it works okay but I don't understand the problem because this property should have been inherited from the ScreenFrame superclass.
		this.setResizable(false);
	}
	
	//This is supposed to be an inner class to paint the background image on top of but it doesn't work for some reason
	/*class paintPanel extends JPanel{
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(bg.getImage(),0,0,this.getWidth(),this.getHeight(),null);
		}
	}*/

}
