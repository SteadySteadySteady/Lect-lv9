package horse;

import javax.swing.JFrame;

public class Frame extends JFrame{
	private Panel panel = new Panel();
	public Frame() {
		setLayout(null);
		setBounds(100,100,1200,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
	}
}
