package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import models.Block;

public class Panel extends Listener {
	public static final int MOVESPACE = 1;
	public static final int WALL = 2;
	public static final int PLAYER = 3;
	public static final int BALL = 4;
	public static final int GOAL = 5;	
	public static final int GOALIN = 6;	
	public static final int LEFT = -1;
	public static final int UP = -2;
	public static final int DOWN = -3;
	public static final int RIGHT = -4;
	private Block map[][];
	private JButton controlBt[];
	private Block blockBt[];
	private int ballCnt, goalCnt, goalInCnt;
	private boolean playerTileExist;
	private int mode;
	private int selBlock;
	private final int MAKERMODE = 9;
	private final int PLAYERMODE = 8;
	private int dir;
	private int playerX, playerY, xx, yy;
	
	public Panel() {
		setLayout(null);
		setBounds(0, 0, 900, 800);
		setBackground(new Color(180, 254, 152));
		setBlocks();
		addMouseListener(this);
		addKeyListener(this);
		setButtons();
		setBlockBts();
	}

	private void setBlockBts() {
		blockBt = new Block[6];
		int y = 100;
		for (int i = 0; i < blockBt.length; i += 1) {
			blockBt[i] = new Block(700, y, 1);
			blockBt[i].setImageIcon(i + 1);
			y += 60;
		}
	}

	private void setButtons() {
		int y = 500;
		String tags[] = { "Maker", "Play" };
		controlBt = new JButton[2];
		for (int i = 0; i < controlBt.length; i += 1) {
			controlBt[i] = new JButton();
			controlBt[i].setBounds(700, y, 100, 50);
			controlBt[i].addActionListener(this);
			controlBt[i].setText(tags[i]);
			controlBt[i].setBackground(Color.white);
			add(controlBt[i]);
			y += 75;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		yy = playerY;
		xx = playerX;
		if(mode == PLAYERMODE) {
			if (e.getKeyCode() == e.VK_LEFT) {
				dir = LEFT;
			}
			else if (e.getKeyCode() == e.VK_UP) {
				dir = UP;
			}
			else if (e.getKeyCode() == e.VK_DOWN) {
				dir = DOWN;
			}
			else if (e.getKeyCode() == e.VK_RIGHT) {
				dir = RIGHT;
			}
			move();
		}
	}
	
	private void move() {
		yy = changeCoor(yy, xx)[0];
		xx = changeCoor(yy, xx)[1];
		if(yy < map.length && yy >= 0 && xx < map[0].length && xx >= 0) {
			if(map[yy][xx].getRole() == MOVESPACE) {
				map[playerY][playerX].setImageIcon(MOVESPACE);
				playerY = changeCoor(playerY, playerX)[0];
				playerX = changeCoor(playerY, playerX)[1];
				map[playerY][playerX].setImageIcon(PLAYER);
			} 
			else if(map[yy][xx].getRole() == BALL) {
				int tempY = yy;
				int tempX = xx;
				tempY = changeCoor(tempY, tempX)[0];
				tempX = changeCoor(tempY, tempX)[1];
				if(tempY < map.length && tempY >= 0 && tempX < map[0].length && tempX >= 0) {
					if(map[tempY][tempX].getRole() != WALL) {
						map[playerY][playerX].setImageIcon(MOVESPACE);
						playerY = changeCoor(playerY, playerX)[0];
						playerX = changeCoor(playerY, playerX)[1];
						map[playerY][playerX].setImageIcon(PLAYER);
						if(map[tempY][tempX].getRole() == GOAL) {
							map[tempY][tempX].setImageIcon(GOALIN);	
							goalInCnt += 1;
							if(goalInCnt == goalCnt) {
								JOptionPane.showMessageDialog(null, "Clear");
								mode = MAKERMODE;
							}
						} else {
							map[tempY][tempX].setImageIcon(BALL);					
						}
					}
				}
			}
		}
	}
	
	private int[] changeCoor(int y, int x) {
		if(dir == LEFT) {
			x -= 1;
		}
		else if(dir == UP) {
			y -= 1;
		}
		else if(dir == RIGHT) {
			x += 1;
		}
		else if(dir == DOWN) {
			y += 1;
		}
		int temp[] = {y,x};
		return temp;
	}

	private void setBlocks() {
		int y = 100;
		map = new Block[10][10];
		for (int i = 0; i < map.length; i += 1) {
			int x = 100;
			for (int j = 0; j < map[i].length; j += 1) {
				map[i][j] = new Block(x, y, 1);
				x += 50;
			}
			y += 50;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object temp = e.getSource();
		if (temp == controlBt[0]) {
			mode = MAKERMODE;
		} else if (temp == controlBt[1] && ballCnt == goalCnt && playerTileExist) {
			mode = PLAYERMODE;
			selBlock = 0;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (mode == MAKERMODE) {
			for (int i = 0; i < blockBt.length; i += 1) {
				if (y >= blockBt[i].getY() && y <= blockBt[i].getY() + blockBt[i].getHeight() && x >= blockBt[i].getX()
						&& x <= blockBt[i].getX() + blockBt[i].getWidth()) {
					selBlock = i + 1;
				}
			}
			checkPlayerTile();
			if (selBlock != 0) placeTile(x, y);
		}
		checkBallAndGoal();
	}

	private void placeTile(int x, int y) {
		for (int i = 0; i < map.length; i += 1) {
			for (int j = 0; j < map[i].length; j += 1) {
				Block temp = map[i][j];
				if (y >= temp.getY() && y <= temp.getY() + temp.getHeight() && x >= temp.getX()
						&& x <= temp.getX() + temp.getWidth()) {
					if (selBlock == 3 && playerTileExist) {
						Alert alert = new Alert();
					} else {
						if(selBlock == 3) {
							playerX = j;
							playerY = i;
						}
						temp.setImageIcon(selBlock);						
					}
				}
			}
		}
	}
	
	private void checkBallAndGoal() {
		ballCnt = 0;
		goalCnt = 0;
		for(int i = 0; i < map.length; i += 1) {
			for(int j = 0; j < map[i].length; j += 1) {
				Block temp = map[i][j];
				if(temp.getRole() == 4) ballCnt += 1;
				if(temp.getRole() == 5) goalCnt += 1;				
			}
		}
		
	}
	
	private void checkPlayerTile() {
		boolean exist = false;
		for (int i = 0; i < map.length; i += 1) {
			for (int j = 0; j < map[i].length; j += 1) {
				Block temp = map[i][j];
				if(temp.getRole() == 3) exist = true;
			}
		}
		if(exist) playerTileExist = true;
		else playerTileExist = false;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < map.length; i += 1) {
			for (int j = 0; j < map[i].length; j += 1) {
				g.drawImage(map[i][j].getImage(), map[i][j].getX(), map[i][j].getY(), null);
			}
		}
		if (mode == MAKERMODE) {
			for (int i = 0; i < blockBt.length; i += 1) {
				g.drawImage(blockBt[i].getImage(), blockBt[i].getX(), blockBt[i].getY(), null);
			}
		}
		requestFocusInWindow(); // 키 리스너를 위한 포커스 재요청
		repaint();
	}
}
