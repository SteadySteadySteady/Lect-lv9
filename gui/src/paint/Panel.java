package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Panel extends Listener {
	private Rect rect = new Rect();
	private boolean shift;
	private int dragY, dragX, startY, startX, gapY, gapX;
	public JButton close;
	public Panel() {
		setLayout(null);
		setBounds(0,0,1500,900);
//		setBackground(new Color(137, 181, 175));
		setCloseButton();
		setFocusable(true);
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
		rect.setWidth(0);
		rect.setHeight(0);
		rect.setY(0);
		rect.setX(0);
		startY = e.getY();
		startX = e.getX();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		dragY = e.getY();
		dragX = e.getX();
		gapY = startY - dragY;
		gapX = startX - dragX;
		if(gapY < 0) {
			rect.setY(startY);
			rect.setHeight(gapY*-1);
		}
		else if(gapY > 0) {
			rect.setY(dragY);
			rect.setHeight(gapY);
		}
		if(gapX < 0) {
			rect.setX(startX);
			rect.setWidth(gapX*-1);
		}
		else if(gapX > 0) {
			rect.setX(dragX);
			rect.setWidth(gapX);
		}
		if(shift) {
			if(gapY < 0 && gapX < 0) {
				if(rect.getHeight() > rect.getWidth()) {
					rect.setWidth(rect.getHeight());
				} else {
					rect.setHeight(rect.getWidth());
				}
			} else if(gapY < 0 && gapX > 0) {
				if(rect.getHeight() > gapX) {
					rect.setX(startX - rect.getHeight());
					rect.setWidth(rect.getHeight());
				} else {
					rect.setHeight(rect.getWidth());
				}
			} else if(gapY > 0 && gapX < 0) {
				if(rect.getWidth() > gapY) {
					rect.setY(startY - rect.getWidth());
					rect.setHeight(rect.getWidth());
				} else {
					rect.setWidth(rect.getHeight());
				}
			} else if(gapY > 0 && gapY > 0) {
				if(rect.getHeight() > gapX) {
					rect.setX(startX - rect.getHeight());
					rect.setWidth(rect.getHeight());
				} else if(rect.getWidth() > gapY) {
					rect.setY(startY - rect.getWidth());
					rect.setHeight(rect.getWidth());
				}
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_SHIFT) {
			shift = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		shift = false;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		requestFocusInWindow();
		g.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
		repaint();
	}
}
