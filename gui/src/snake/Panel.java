package snake;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends Listener{
	private JButton dirKey[];
	private Rect map[][];
	public Panel() {
		setLayout(null);
		setBounds(0,0,1200,800);
		setBackground(new Color(162, 210, 255));
		setDirKey();
		setMap();
	}
	private void setMap() {
		map = new Rect[10][10];
		
	}
	private void setDirKey() {
		dirKey = new JButton[4];
		String dir[] = {"ก่","ก็","ก้","กๆ"};
		int x = 1000;
		int y = 600;
		int size = 50;
		for(int i = 0; i < dirKey.length; i += 1) {
			dirKey[i] = new JButton();
			dirKey[i].setBounds(x, y, size, size);
			dirKey[i].setBackground(new Color(254, 249, 239));
			dirKey[i].addKeyListener(this);
			dirKey[i].setText(dir[i]);
			add(dirKey[i]);
			if(i == 0) {
				x -= size + 5;
				y += size + 5;
			} else x += size + 5;
		}
	}
	
}
