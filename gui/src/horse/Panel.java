package horse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Panel extends Listener{
	private Horse horses[] = new Horse[5];
	private Image images[] = new Image[5];
	private JLabel ranks[] = new JLabel[5];
	private boolean run;
	private int rank = 1;
	private final int endLineX = 1000;
	private final int w = 100;
	private final int h = 75;
	private JButton startBt = new JButton();
	private JButton resetBt = new JButton();
	public Panel() {
		setLayout(null);
		setBounds(0,0,1200,800);
		setVisible(true);
		setStartButton();
		setResetButton();
		setHorse();
		setRank();
	}
	
	private void setRank() {
		int y = 100;
		for(int i = 0; i < ranks.length; i += 1) {
			ranks[i] = new JLabel();
			ranks[i].setBounds(endLineX+50, y, 100, 100);
			ranks[i].setVisible(true);
			add(ranks[i]);
			y+=h+1;
		}
	}

	private void setResetButton() {
		JLabel text = new JLabel();
		resetBt.setBounds(650,600,65,50);
		resetBt.setBackground(Color.white);
		resetBt.addActionListener(this);
		text.setBounds(0, 0, 100, 75);
		text.setText("reset");
		resetBt.add(text);
		add(resetBt);
	}

	private void setStartButton() {
		JLabel text = new JLabel();
		startBt.setBounds(450,600,65,50);
		startBt.setBackground(Color.white);
		startBt.addActionListener(this);
		text.setBounds(0, 0, 100, 75);
		text.setText("Start");
		startBt.add(text);
		add(startBt);
	}

	private void setHorse() {
		String horseNames[] = {"images/horse1.png","images/horse2.png","images/horse3.png","images/horse4.png","images/horse5.png"};
		for(int i = 0; i < images.length; i += 1) {
			images[i] = new ImageIcon(horseNames[i]).getImage().getScaledInstance(100, 75, Image.SCALE_SMOOTH);
		}
		int y = 100;
		for(int i = 0; i < horses.length; i += 1) {
			horses[i] = new Horse(i+1, horseNames[i], new ImageIcon(images[i]), 100, y, w, h);
			y += h+1;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object temp = e.getSource();
		if(temp == startBt) run = true;
		if(temp == resetBt) {
			for(int i = 0; i < horses.length; i += 1) {
				horses[i].setX(100);
				horses[i].setRank(0);
				horses[i].setState(horses[i].RUN);
			}
			run = false;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Random r = new Random();
		super.paintComponent(g);
		g.drawLine(endLineX, 75, endLineX, 175+h*5);
		for(int i = 0; i < horses.length; i += 1) {
			g.drawImage(horses[i].getImage(), horses[i].getX(), horses[i].getY(), null);			
		}
		if(run) {
			try {
				Thread.sleep(50);
				boolean exist = false;
				for(int i = 0; i < horses.length; i += 1) {
					if(horses[i].getState() == horses[i].RUN) {
						int rNum = r.nextInt(5);
						if(exist == true) rNum = 0;
						horses[i].runHorse(rNum);
					}
					if(horses[i].getX() > endLineX - w) {
						exist = true;
						horses[i].setX(endLineX - w);
					}
					if(horses[i].getX() == endLineX - w && horses[i].getState() == horses[i].RUN) {
						horses[i].setState(horses[i].GOAL);
						ranks[i].setText(String.valueOf(rank));
						horses[i].setRank(rank);
						rank += 1;
					}
				}
			} catch (Exception e) {
				
			}			
		}
		repaint();
	}
}
