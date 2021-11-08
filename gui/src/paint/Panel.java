package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Panel extends Listener {
	private ArrayList<Rect> rect;
	private ArrayList<Rect> circle;
	private ArrayList<Polygon> poly;
	private int rectNum, polyNum, cirNum = 0;
	private boolean shift, rec, tri, cir;
	private int dragY, dragX, startY, startX, gapY, gapX;
	public JButton close;
	JButton polygon[];
	public Panel() {
		setLayout(null);
		setBounds(0,0,1500,900);
//		setBackground(new Color(137, 181, 175));
		setCloseButton();
		setPolygonButton();
		setFocusable(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setVisible(true);
	}

	private void setPolygonButton() {
		int y = 50;
		polygon = new JButton[3];
		JLabel text[] = new JLabel[3];
		String texts[] = {"¡Û","¡â","¡à"};
		for(int i = 0; i < polygon.length; i += 1) {
			polygon[i] = new JButton();
			text[i] = new JLabel();
			polygon[i].setLayout(null);
			polygon[i].setBounds(50, y, 50, 50);
			polygon[i].addActionListener(this);
			text[i].setBounds(0, 0, 50, 50);
			text[i].setText(texts[i]);
			text[i].setHorizontalAlignment(JLabel.CENTER);
			polygon[i].setVisible(true);
			polygon[i].add(text[i]);
			add(polygon[i]);
			y += 60;
		}
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
		if(rec == true) setRect(e);
		else if(tri == true) setTri(e);
		else if(cir == true) setCir(e);
	}
	private void setCir(MouseEvent e) {
		if(circle == null) {
			circle = new ArrayList<>();
		}
		circle.add(new Rect());
		circle.add(new Rect());
		circle.get(cirNum).setWidth(0);
		circle.get(cirNum).setHeight(0);
		circle.get(cirNum).setY(0);
		circle.get(cirNum).setX(0);
		startY = e.getY();
		startX = e.getX();
		cirNum += 1;
	}

	private void setTri(MouseEvent e) {
		if(poly == null) {
			poly = new ArrayList<>();
		}
		poly.add(new Polygon());
		poly.get(polyNum).newX();
		poly.get(polyNum).newY();
		poly.get(polyNum).setX(1, e.getX());
		poly.get(polyNum).setY(1, e.getY());
		polyNum += 1;
	}

	private void setRect(MouseEvent e) {
		if(rect == null) {
			rect = new ArrayList<>();
		}
		rect.add(new Rect());
		rect.get(rectNum).setWidth(0);
		rect.get(rectNum).setHeight(0);
		rect.get(rectNum).setY(0);
		rect.get(rectNum).setX(0);
		startY = e.getY();
		startX = e.getX();
		rectNum += 1;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(rec == true) drawRect(e);
		else if(tri == true) drawTri(e);
		else if(cir == true) drawCir(e);
		/*
		 * this.x = this.startX;
		 * this.y = this.startY;
		 * 
		 * int xx = e.getX();
		 * int yy = e.getY();
		 * 
		 * int width = Math.abs(xx - x);
		 * int height = Math.abs(yy - y);
		 * 
		 * if(this.x > xx && width > 1)
		 * 		x = startX - width;
		 * if(this.y > yy && height > 1)
		 * 		y = startY - height;
		 */
	}
	private void drawCir(MouseEvent e) {
		drawRectAndCir(circle, cirNum, e);
	}

	private void drawTri(MouseEvent e) {
		int polyNum = this.polyNum-1;
		poly.get(polyNum).setY(0, e.getY());
		poly.get(polyNum).setY(2, e.getY());
		dragX = e.getX();
		gapX = poly.get(polyNum).getX()[1] - dragX < 0 ? dragX - poly.get(polyNum).getX()[1] : poly.get(polyNum).getX()[1] - dragX;
		int x = poly.get(polyNum).getX()[1];
		poly.get(polyNum).setX(0, x-gapX);
		poly.get(polyNum).setX(2, x+gapX);
//		if(shift) {
//			int tempY = poly.get(polyNum).getY()[0] - poly.get(polyNum).getY()[2] < 0 ? 
//		}
	}
	
	private void drawRect(MouseEvent e) {
		drawRectAndCir(rect, rectNum, e);
	}
	
	private void drawRectAndCir(ArrayList<Rect> temp, int num, MouseEvent e) {
		int tempNum = num-1;
		dragY = e.getY();
		dragX = e.getX();
		gapY = startY - dragY;
		gapX = startX - dragX;
		if(gapY < 0) {
			temp.get(tempNum).setY(startY);
			temp.get(tempNum).setHeight(gapY*-1);
		}
		else if(gapY > 0) {
			temp.get(tempNum).setY(dragY);
			temp.get(tempNum).setHeight(gapY);
		}
		if(gapX < 0) {
			temp.get(tempNum).setX(startX);
			temp.get(tempNum).setWidth(gapX*-1);
		}
		else if(gapX > 0) {
			temp.get(tempNum).setX(dragX);
			temp.get(tempNum).setWidth(gapX);
		}
		if(shift) {
			if(gapY < 0 && gapX < 0) {
				if(temp.get(tempNum).getHeight() > temp.get(tempNum).getWidth()) {
					temp.get(tempNum).setWidth(temp.get(tempNum).getHeight());
				} else {
					temp.get(tempNum).setHeight(temp.get(tempNum).getWidth());
				}
			} else if(gapY < 0 && gapX > 0) {
				if(temp.get(tempNum).getHeight() > gapX) {
					temp.get(tempNum).setX(startX - temp.get(tempNum).getHeight());
					temp.get(tempNum).setWidth(temp.get(tempNum).getHeight());
				} else {
					temp.get(tempNum).setHeight(temp.get(tempNum).getWidth());
				}
			} else if(gapY > 0 && gapX < 0) {
				if(temp.get(tempNum).getWidth() > gapY) {
					temp.get(tempNum).setY(startY - temp.get(tempNum).getWidth());
					temp.get(tempNum).setHeight(temp.get(tempNum).getWidth());
				} else {
					temp.get(tempNum).setWidth(temp.get(tempNum).getHeight());
				}
			} else if(gapY > 0 && gapY > 0) {
				if(temp.get(tempNum).getHeight() > gapX) {
					temp.get(tempNum).setX(startX - temp.get(tempNum).getHeight());
					temp.get(tempNum).setWidth(temp.get(tempNum).getHeight());
				} else if(temp.get(tempNum).getWidth() > gapY) {
					temp.get(tempNum).setY(startY - temp.get(tempNum).getWidth());
					temp.get(tempNum).setHeight(temp.get(tempNum).getWidth());
				}
			}
		}
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == polygon[0]) {
			cir = true;
			tri = false;
			rec = false;
		} else if(e.getSource() == polygon[1]) {
			cir = false;
			tri = true;
			rec = false;
		} else if(e.getSource() == polygon[2]) {
			cir = false;
			tri = false;
			rec = true;
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
		if(rect != null) {
			for(int i = 0; i < rectNum; i += 1) {
				g.drawRect(rect.get(i).getX(), rect.get(i).getY(), rect.get(i).getWidth(), rect.get(i).getHeight());			
			}
		}
		if(poly != null) {
			for(int i = 0; i < polyNum; i += 1) {
				g.drawPolygon(poly.get(i).getX(), poly.get(i).getY(), poly.get(i).getNPoints());
			}
		}
		if(circle != null) {
			for(int i = 0; i < cirNum; i += 1) {
				g.drawRoundRect(circle.get(i).getX(), circle.get(i).getY(), circle.get(i).getWidth(), circle.get(i).getHeight(), circle.get(i).getWidth(), circle.get(i).getHeight());
			}
		}
		repaint();
	}
}
