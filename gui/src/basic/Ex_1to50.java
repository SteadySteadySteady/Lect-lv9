package basic;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

class MyFrame extends JFrame{
	private Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public MyFrame() {
		setLayout(null);
		setBounds(dm.width/2, dm.height/2, dm.width, dm.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class Ex_1to50 {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}
}
