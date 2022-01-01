import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class TitleScreen extends ScreenFrame implements ActionListener{
	JPanel txtPanel;
	JLabel label;
	JButton jbtNxt;
	
	public TitleScreen(String title) {
		super(title);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 400, 30));
		this.getContentPane().setBackground(Color.blue);
		
		txtPanel = new JPanel();
		this.add(label = new JLabel("Final Project: Whack-a-Mole!"));
		label.setFont(new Font("Comic Sans", Font.BOLD, 40));
		label.setForeground(Color.green);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label = new JLabel("Students: Eric Zhang and Victor Zhang"));
		label.setFont(new Font("Comic Sans", Font.BOLD, 40));
		label.setForeground(Color.green);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label = new JLabel("Teacher: Ms. Xie"));
		label.setFont(new Font("Comic Sans", Font.BOLD, 40));
		label.setForeground(Color.green);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label = new JLabel("Jan 28, 2022"));
		label.setFont(new Font("Comic Sans", Font.BOLD, 40));
		label.setForeground(Color.green);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label = new JLabel("ICS3U7-01"));
		label.setFont(new Font("Comic Sans", Font.BOLD, 40));
		label.setForeground(Color.green);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		jbtNxt = new JButton("Next");
		jbtNxt.setPreferredSize(new Dimension(200, 75));
		jbtNxt.setForeground(Color.red);
		jbtNxt.setBackground(Color.cyan);
		jbtNxt.setFocusable(false);
		jbtNxt.setFont(new Font("Comic Sans", Font.BOLD, 20));
		jbtNxt.addActionListener(this);
		this.add(jbtNxt);
		
		//Set Visible again because FlowLayout needs it to be set last
		this.setVisible(true);
		//this.add(txtPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtNxt) {
			MenuScreen menu = new MenuScreen("Menu");
		}
	}
}
