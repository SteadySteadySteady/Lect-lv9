package models;

import javax.swing.JFrame;

public class Frame extends JFrame{
	MenuPanel menuPanel = new MenuPanel();
	public Frame() {
		setLayout(null);
		setBounds(100,100,600,900);
		setVisible(true);
		add(menuPanel);
	}
}
