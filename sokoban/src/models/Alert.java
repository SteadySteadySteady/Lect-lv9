package models;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLabel;

public class Alert extends JFrame{
	
	JLabel text = new JLabel();
	
	public Alert() {
		setLayout(null);
		setBounds(500, 500, 200, 100);
		setVisible(true);
		
		text.setBounds(0, 0, 200, 100);
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setVisible(true);
		text.setText("Player Tile Already Exists");
		add(text);
	}
}
