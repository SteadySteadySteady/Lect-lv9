package paint;

public class Polygon {
	private int[] x, y;
	private int nPoints = 3;
	
	public int[] getX() {
		return this.x;
	}
	public int[] getY() {
		return this.y;
	}
	public int getNPoints() {
		return this.nPoints;
	}
	
	public void newX() {
		this.x = new int[3];
	}
	public void newY() {
		this.y = new int[3];
	}
	public void setX(int idx, int x) {
		this.x[idx] = x;
	}
	public void setY(int idx, int y) {
		this.y[idx] = y;
	}
}
