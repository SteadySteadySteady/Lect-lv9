package models;

import javax.swing.JFrame;

public class Frame extends JFrame{
	private Panel panel = new Panel();
	public Frame() {
		super("Sokoban");
		setLayout(null);
		setBounds(100, 100, 900, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
	}
}
