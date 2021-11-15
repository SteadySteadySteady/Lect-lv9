package models;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Product {
	public Product(String name, int num) {
		setImageIcon(name, num);
	}
	private int x, y;
	private int w = 50;
	private int h = 75;
	private ImageIcon image;
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return w;
	}
	public int getHeight() {
		return h;
	}
	public Image getImage() {
		return image.getImage();
	}
	public void setImageIcon(String name, int num) {
		String tempNum = num < 10 ? "0" : "";
		Image temp = new ImageIcon(String.format("images/%s%s%d.png", name, tempNum, num)).getImage().getScaledInstance(50, 75, Image.SCALE_SMOOTH);
		this.image = new ImageIcon(temp);
	}
	
}