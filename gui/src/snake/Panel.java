package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends Listener{
	static int SIZE = 50;
	private ArrayList<Integer> x;
	private ArrayList<Integer> y;
	private int snakeLength = 3;
	private int targetNum = 1;
	private JButton dirKey[];
	private Rect map[][];
	Random r = new Random();
	public Panel() {
		setLayout(null);
		setBounds(0,0,1200,800);
		setBackground(new Color(162, 210, 255));
		setDirKey();
		setMap();
		setSnake();
	}
	private void setSnake() {
		int rNum = r.nextInt(50);
		x = new ArrayList<>();
		y = new ArrayList<>();
		x.add(rNum % 10);
		y.add(rNum / 10);
		map[y.get(0)][x.get(0)].setSnakeNum(1);
	}
	private void setMap() {
		map = new Rect[10][10];
		int x = 50;
		int y = 150;
		for(int i = 0; i < map.length; i += 1) {
			for(int j = 0; j < map[i].length; j += 1) {
				map[i][j] = new Rect(x, y, SIZE, SIZE);
				x += SIZE+5;
			}
			x = 50;
			y += SIZE+5;
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int xx = x.get(0);
		int yy = y.get(0);
		if(e.VK_UP == e.getKeyCode()) {
			yy -= 1;
		}
		else if(e.VK_LEFT == e.getKeyCode()) {
			xx -= 1;
		}
		else if(e.VK_DOWN == e.getKeyCode()) {
			yy += 1;
		}
		else if(e.VK_RIGHT == e.getKeyCode()) {
			xx += 1;
		}
		if(check(yy, xx)) {
			map[y.get(0)][x.get(0)].setSnakeNum(0);
			y.set(0, yy);
			x.set(0, xx);
			map[y.get(0)][x.get(0)].setSnakeNum(targetNum);
			snakeMove(yy, xx);
			int rNum = 1;
			if(rNum == 1) {
				addItem();
			}
		} else {
			System.out.println("Á×¾ú´Ù");
		}
	}
	private void addItem() {
		while(true) {
			int y = r.nextInt(10);
			int x = r.nextInt(10);
			if(map[y][x].getSnakeNum() == 0) {
				map[y][x].setItem(true);
				break;
			}
		}
	}
	private void snakeMove(int yy, int xx) {
		// arrx,y 0 -> arrx,y 1
		int tempX = xx;
		int tempY = yy;
		for(int i = 1; i < snakeLength-1; i += 1) {
			if(i > 1) {
				
			}
			map[y.get(i)][x.get(i)].setSnakeNum(0);
			y.set(i, tempY);
			x.set(i, tempX);
			map[y.get(i)][x.get(i)].setSnakeNum(i+1);
		}
	}
	private boolean check(int yy, int xx) {
		if(yy < 0 || yy >= map.length || xx < 0 || xx >= map[0].length || map[yy][xx].getSnakeNum() != 0)
			return false;
		return true;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < map.length; i += 1) {
			for(int j = 0; j < map[i].length; j += 1) {
				Rect temp = map[i][j];
				if(temp.getSnakeNum() == 0) g.setColor(new Color(254, 249, 239));					
				else if(temp.getSnakeNum() == 1) g.setColor(new Color(254, 228, 64));
				else if(temp.getSnakeNum() > 1) g.setColor(new Color(255, 134, 94));
				else if(temp.getItem()) g.setColor(new Color(206, 229, 208));
				g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
				g.fillRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
			}
		}
		repaint();
	}
	
	private void setDirKey() {
		dirKey = new JButton[4];
		String dir[] = {"¡è","¡ç","¡é","¡æ"};
		int x = 1000;
		int y = 600;
		for(int i = 0; i < dirKey.length; i += 1) {
			dirKey[i] = new JButton();
			dirKey[i].setBounds(x, y, SIZE, SIZE);
			dirKey[i].setBackground(new Color(254, 249, 239));
			dirKey[i].addKeyListener(this);
			dirKey[i].setText(dir[i]);
			add(dirKey[i]);
			if(i == 0) {
				x -= SIZE + 5;
				y += SIZE + 5;
			} else x += SIZE + 5;
		}
	}
	
}
