package snake;

import javax.swing.JFrame;

public class Frame extends JFrame {
	Panel panel = new Panel();
	public Frame() {
		super("Snake");
		setLayout(null);
		setBounds(50,50,1200,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		add(panel);
	}
}
