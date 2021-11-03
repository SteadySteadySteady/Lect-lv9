package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Panel extends Listener {
	private int startY, startX, width, height, tempY, tempX;
	private JButton close;
	public Panel() {
		setLayout(null);
		setBounds(0,0,1500,900);
//		setBackground(new Color(137, 181, 175));
		setCloseButton();
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setVisible(true);
	}

	private void setCloseButton() {
		JLabel text = new JLabel();
		close = new JButton();
		close.setLayout(null);
		close.setBounds(1400,800,50,50);
		close.setBackground(new Color(150, 199, 193));
		text.setBounds(0,0,50,50);
		text.setText("Close");
		text.setHorizontalAlignment(JLabel.CENTER);
		close.setVisible(true);
		close.add(text);
		add(close);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		width = 0;
		height = 0;
		startY = e.getY();
		startX = e.getX();
		tempY = startY;
		tempX = startX;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getY() - startY < 0) {
			startY = e.getY();
			height = tempY - startY;
		} else {
			height = e.getY() - startY;
		}
		if(e.getX() - startX < 0) {
			startX = e.getX();
			width = tempX - startX;
		} else {
			width = e.getX() - startX;
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(startX, startY, width, height);
		repaint();
	}
}
