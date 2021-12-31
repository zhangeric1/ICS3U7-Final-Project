import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;



public class Main {
	public static void main (String args[]) {
		JFrame f = new JFrame("Layout example");
		
		Container cont = f.getContentPane();
		cont.setLayout(new BorderLayout());
		
		Main_Panel mgp= new Main_Panel();
		cont.add(mgp, BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 f.setVisible(true); 
		 f.setSize(1000, 800); 
		 f.setResizable(false);
	}
}


class Main_Panel extends JPanel{
		private ImageIcon bg;
	   JButton btn1 ,btn2, btn3, btn4;
	      /**  constructor */
	  public Main_Panel() {
		
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