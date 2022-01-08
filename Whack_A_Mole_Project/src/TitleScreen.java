import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class TitleScreen extends ScreenFrame implements ActionListener{
	private JLabel label;
	private JButton jbtNxt;
	private Font titleFont;
	private Color titleColor;
	
	public TitleScreen(String title) {
		super(title);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 400, 30));
		this.getContentPane().setBackground(Color.lightGray);
		
		titleColor = Color.black;
		titleFont = new Font("Comic Sans", Font.BOLD, 40);
		this.add(label = addCustomLabel("Final Project: Whack-a-Mole!", titleColor, titleFont));
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label = addCustomLabel("Students: Eric Zhang and Victor Zhang", titleColor, titleFont));
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label = addCustomLabel("Teacher: Ms. Xie", titleColor, titleFont));
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label = addCustomLabel("Jan 28, 2022", titleColor, titleFont));
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label = addCustomLabel("ICS3U7-01", titleColor, titleFont));
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		jbtNxt = addCustomButton("Next", 200, 75, Color.black, Color.cyan, new Font("Comic Sans", Font.BOLD, 20));
		jbtNxt.addActionListener(this);
		this.add(jbtNxt);
		
		//Set Visible again because FlowLayout needs it to be set last
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtNxt) {
			this.dispose();
			new MenuScreen("Menu");
		}
	}
	
}

