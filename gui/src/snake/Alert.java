package snake;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Alert extends JFrame{
	
	JLabel text = new JLabel();
	
	public Alert() {
		setLayout(null);
		setBounds(100,100,200,100);
		setVisible(true);
		
		text.setBounds(0,0,200,100);
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setVerticalAlignment(JLabel.TOP);
		text.setVisible(true);
		text.setText("ав╬З╢ы");
		add(text);
	}
}
