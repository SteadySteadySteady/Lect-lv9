package paint;

import java.awt.Color;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	private Panel panel = new Panel();
	public MyFrame() {
		setLayout(null);
		setBounds(100,100,1500,900);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
	}
}
