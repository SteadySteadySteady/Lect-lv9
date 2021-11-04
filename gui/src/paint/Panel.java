package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Panel extends Listener {
	private ArrayList<Rect> rect = new ArrayList<>();
	private int rectNum = -1;
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
		rectNum += 1;
		rect.add(new Rect());
		rect.get(rectNum).setWidth(0);
		rect.get(rectNum).setHeight(0);
		rect.get(rectNum).setY(0);
		rect.get(rectNum).setX(0);
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
			rect.get(rectNum).setY(startY);
			rect.get(rectNum).setHeight(gapY*-1);
		}
		else if(gapY > 0) {
			rect.get(rectNum).setY(dragY);
			rect.get(rectNum).setHeight(gapY);
		}
		if(gapX < 0) {
			rect.get(rectNum).setX(startX);
			rect.get(rectNum).setWidth(gapX*-1);
		}
		else if(gapX > 0) {
			rect.get(rectNum).setX(dragX);
			rect.get(rectNum).setWidth(gapX);
		}
		if(shift) {
			if(gapY < 0 && gapX < 0) {
				if(rect.get(rectNum).getHeight() > rect.get(rectNum).getWidth()) {
					rect.get(rectNum).setWidth(rect.get(rectNum).getHeight());
				} else {
					rect.get(rectNum).setHeight(rect.get(rectNum).getWidth());
				}
			} else if(gapY < 0 && gapX > 0) {
				if(rect.get(rectNum).getHeight() > gapX) {
					rect.get(rectNum).setX(startX - rect.get(rectNum).getHeight());
					rect.get(rectNum).setWidth(rect.get(rectNum).getHeight());
				} else {
					rect.get(rectNum).setHeight(rect.get(rectNum).getWidth());
				}
			} else if(gapY > 0 && gapX < 0) {
				if(rect.get(rectNum).getWidth() > gapY) {
					rect.get(rectNum).setY(startY - rect.get(rectNum).getWidth());
					rect.get(rectNum).setHeight(rect.get(rectNum).getWidth());
				} else {
					rect.get(rectNum).setWidth(rect.get(rectNum).getHeight());
				}
			} else if(gapY > 0 && gapY > 0) {
				if(rect.get(rectNum).getHeight() > gapX) {
					rect.get(rectNum).setX(startX - rect.get(rectNum).getHeight());
					rect.get(rectNum).setWidth(rect.get(rectNum).getHeight());
				} else if(rect.get(rectNum).getWidth() > gapY) {
					rect.get(rectNum).setY(startY - rect.get(rectNum).getWidth());
					rect.get(rectNum).setHeight(rect.get(rectNum).getWidth());
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
		if(rectNum != -1) {
			for(int i = 0; i < rectNum+1; i += 1) {
				g.drawRect(rect.get(i).getX(), rect.get(i).getY(), rect.get(i).getWidth(), rect.get(i).getHeight());			
			}
		}
		repaint();
	}
}
