package horse;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Horse {
	public Horse(int num, String filename, ImageIcon image, int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.num = num;
		this.fileName = filename;
		this.image = image;
	}
	public final int RUN = 0;
	public final int GOAL = 1;	
	
	private int num;
	private int x, y, w, h;
	private int state;
	
	private String fileName;
	private ImageIcon image;
	
	private int rank;

	public Image getImage() {
		return image.getImage();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public int getState() {
		return state;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	public void runHorse(int num) {
		this.x += num;
	}
	
}
