package snake;

public class Rect {
	private int x, y, width, height, snakeNum;
	private boolean item;
	public Rect(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean getItem() {
		return item;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getSnakeNum() {
		return snakeNum;
	}
	
	public void setSnakeNum(int num) {
		this.snakeNum = num;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int x) {
		this.y = y;
	}
	
	public void setItem(boolean item) {
		this.item = item;
	}
}
