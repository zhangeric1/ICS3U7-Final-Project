import javax.swing.JFrame;

public class ScreenFrame extends JFrame{
	
	//Constructor: Defines state/behavior that all child frames will inherit
	public ScreenFrame(String title) {
		super(title);
		this.setSize(1000, 800);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
