package paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener{
	private Panel panel = new Panel();
	public MyFrame() {
		setLayout(null);
		setBounds(100,100,1500,900);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.close.addActionListener(this);
		add(panel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}
}
