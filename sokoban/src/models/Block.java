package models;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Block {
	public boolean playerTileExist;
	private int x, y;
	private int w = 50;
	private int h = 50;
	private int role;
	private ImageIcon image;
	public Block(int x, int y, int num) {
		this.x = x;
		this.y = y;
		setImageIcon(num);
	}
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
	public int getRole() {
		return role;
	}
	public void setImageIcon(int num) {
		Image temp = new ImageIcon(String.format("images/tile%d.png", num)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		this.image = new ImageIcon(temp);
		this.role = num;
	}
}
