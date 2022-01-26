/**
 * This is our hard play screen for the hard difficulty, the user can pause and return to menu using the pause button
 */
//import necessary packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class HardPlayScreen extends ScreenFrame implements ActionListener{
	public static int points = 0, timeLeft = 60;
	private ImageIcon bg;
	private JLabel scorelbl, timelbl;
	private JPanel headingPanel;
	private JPanel grid;
	private final Color HARDPLAY_COLOR_FG = Color.blue, HARDPLAY_COLOR_BG = Color.cyan; //constant colors of button foreground and background respectively
	private final Font HARDPLAY_FONT = new Font("Comic Sans MS", Font.PLAIN, 25); //constant font of buttons
	Mole[] moles = new Mole[16];
	private Timer timer;
	JButton jbtPause;
	
	//Constructor for HardPlayScreen:
	HardPlayScreen(){
		
			bg = new ImageIcon("images/bgPlay.jpg");

			scorelbl = addCustomLabel("    Score: " + points, Color.cyan, new Font("Comic Sans MS", Font.BOLD, 35));
			timelbl = addCustomLabel("    Time left: " + timeLeft + " seconds", Color.cyan, new Font("Comic Sans MS", Font.BOLD, 35));
			
			headingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			headingPanel.setBackground(BG_COLOR);
			jbtPause = addCustomButton("||", 10, 10, 75, 75, HARDPLAY_COLOR_FG, HARDPLAY_COLOR_BG, HARDPLAY_FONT);
			jbtPause.addActionListener(this); //register action listener
			headingPanel.add(jbtPause);
			headingPanel.add(scorelbl);
			headingPanel.add(timelbl);
			this.add(headingPanel, BorderLayout.NORTH);
			
			timer();
			timer.start();
			
			grid = new PaintPanel();
			grid.setLayout(null);
			for(int i = 0; i < moles.length; i++) {
				moles[i] = new Mole();
				moles[i].addActionListener(this);
				grid.add(moles[i]);
			}
			moles[0].setBounds(100, 110, 100, 90);
			moles[1].setBounds(300, 110, 100, 90);
			moles[2].setBounds(500, 110, 100, 90);
			moles[3].setBounds(700, 110, 100, 90);
			moles[4].setBounds(150, 260, 100, 90);
			moles[5].setBounds(350, 260, 100, 90);
			moles[6].setBounds(550, 260, 100, 90);
			moles[7].setBounds(750, 260, 100, 90);
			moles[8].setBounds(100, 410, 100, 90);
			moles[9].setBounds(300, 410, 100, 90);
			moles[10].setBounds(500, 410, 100, 90);
			moles[11].setBounds(700, 410, 100, 90);
			moles[12].setBounds(150, 560, 100, 90);
			moles[13].setBounds(350, 560, 100, 90);
			moles[14].setBounds(550, 560, 100, 90);
			moles[15].setBounds(750, 560, 100, 90);

			this.add(grid, BorderLayout.CENTER);
	        
			//pre-set some moles
	        moles[4].setUp();
	        moles[7].setUp();
	        moles[2].setUp();

		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtPause) {
			new PauseScreen();
			timer.stop();
			this.dispose();
		}
		else {
			for(int i = 0; i < 16; i++) {
				if(e.getSource() == moles[i] && moles[i].isUp) {
					switch(moles[i].getState()) {
					case 1: 
						points++;
						break;
					case 2: 
						points += 2;
						break;
					case 3: 
						if(points >= 2) {
							points -= 2;
						}
						else {
							points = 0;
						}
						break;
					}
					int hole;
					do {
						hole = (int)(Math.random() * 16);
					}while(moles[hole].isUp); //keep generating random holes if the mole on that hole is already up (no duplicates)
					
					int type = (int)((Math.random() * 100) + 1);
					if(type <= 70) {
						moles[hole].setNormal();
					}
					else if(type >= 85) {
						moles[hole].setSuper();
					}
					else {
						moles[hole].setSabotage();
					}
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
