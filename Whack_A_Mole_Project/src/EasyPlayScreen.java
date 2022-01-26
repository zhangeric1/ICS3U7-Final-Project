/**
 * This is our play screen for the easy difficulty, the user can pause and return to menu using the pause button
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class EasyPlayScreen extends ScreenFrame implements ActionListener{
	public static int points = 0, timeLeft = 60;
	private ImageIcon bg;
	private JLabel scorelbl, timelbl;
	private JPanel headingPanel;
	private JPanel grid;
	private final Color EASYPLAY_COLOR_FG = Color.blue, EASYPLAY_COLOR_BG = Color.cyan; //constant colors of button foreground and background respectively
	private final Font EASYPLAY_FONT = new Font("Comic Sans MS", Font.PLAIN, 25); //constant font of buttons
	Mole[] moles = new Mole[9];
	private Timer timer;
	JButton jbtPause;

	public EasyPlayScreen() {
		bg = new ImageIcon("images/bgPlay.jpg");

		scorelbl = addCustomLabel("    Score: " + points, Color.cyan, new Font("Comic Sans MS", Font.BOLD, 35));
		timelbl = addCustomLabel("    Time left: " + timeLeft + " seconds", Color.cyan, new Font("Comic Sans MS", Font.BOLD, 35));
		
		headingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		headingPanel.setBackground(BG_COLOR);
		jbtPause = addCustomButton("||", 10, 10, 75, 75, EASYPLAY_COLOR_FG, EASYPLAY_COLOR_BG, EASYPLAY_FONT);
		jbtPause.addActionListener(this); //register action listener
		headingPanel.add(jbtPause);
		headingPanel.add(scorelbl);
		headingPanel.add(timelbl);
		this.add(headingPanel, BorderLayout.NORTH);
		
		timer();//call the timer method
		timer.start();//start the timer
		
		grid = new PaintPanel();
		grid.setLayout(null);
		for(int i = 0; i < moles.length; i++) {
			moles[i] = new Mole();
			moles[i].addActionListener(this);
			grid.add(moles[i]);
		}
		moles[0].setBounds(150, 200, 100, 90);
		moles[1].setBounds(450, 200, 100, 90);
		moles[2].setBounds(750, 200, 100, 90);
		moles[3].setBounds(150, 350, 100, 90);
		moles[4].setBounds(450, 350, 100, 90);
		moles[5].setBounds(750, 350, 100, 90);
		moles[6].setBounds(150, 500, 100, 90);
		moles[7].setBounds(450, 500, 100, 90);
		moles[8].setBounds(750, 500, 100, 90);
		
		this.add(grid, BorderLayout.CENTER);
        
		//pre-set some moles
        MoleRandomizer();
        

	}
	
	private void MoleRandomizer() {//randomizes the placements of the moles
		int a;
		int b;
		int c;
		do {
			a = (int) (Math.random()*9);
			b = (int) (Math.random()*9);
			c = (int) (Math.random()*9);
		}while(a == b || b == c || c == a);//while two of the values oare the same continue randomizing until all 3 are different
		
		
		moles[a].setUp();
        moles[b].setUp();
        moles[c].setUp();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtPause) {
			timer.stop();
			new PauseScreen();
			this.dispose();
		}
		else {
			for(int i = 0; i < 9; i++) {
				if(e.getSource() == moles[i] && moles[i].isUp) {
					points++;
					int hole;
					do {
						hole = (int)(Math.random() * 9);
					}while(moles[hole].isUp); //keep generating random holes if the mole on that hole is already up (no duplicates)
					moles[hole].setUp();
					moles[i].setDown();
					scorelbl.setText("    Score: " + points);
					break;
				}
			}
		}
	}
	
	public void timer() {//Timer method
		timer = new Timer(1000, new ActionListener() {//Creates a new timer object
	        public void actionPerformed(ActionEvent evt) {
	            if(timeLeft == 0){//when the timer reaches 0
	            	timelbl.setText("    Time left: " + timeLeft + " seconds");
	                timer.stop();
	                new EndGameScreen();//Create the end game screen and dispose this one
	                dispose();
	            }
	            timeLeft--;
	            timelbl.setText("    Time left: " + timeLeft + " seconds");
	        }
	    });
	}
	/*
	 * This class is a canvas that draws the background image. All components are added to this Panel, then the
	 * PaintPanel is added to the JFrame.
	 */
	class PaintPanel extends JPanel{
		protected void paintComponent(Graphics g){
			super.paintComponent(g); //override the paintComponent method
			//draw the background image
			g.drawImage(bg.getImage(),0,0,this.getWidth(),this.getHeight(),null);
		}//end of paintComponent method
	}
}