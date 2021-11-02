package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
// import javax.swing.~ // ��� Ŭ���� ���
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// GUI : Graphic User Interface
//	�� awt
//	�� swing

// Jframe : �ֻ��� �����̳�
// JPanel : �����̳� <- ������Ʈ(��ҵ��� �ٿ����� add()�鼭 �ϼ���)
//	�� JButton, JTextField, JLabel, JCheckBox ... 
class HeadTitle extends JLabel {
	public HeadTitle() {
//		setLayout(null);
		setBounds(245, 0, 100, 100);
		setText("Start");
		setFont(new Font("", Font.BOLD, 30));
		setHorizontalAlignment(CENTER);
		setVisible(true);
	}
}

class MyPanel extends JPanel implements ActionListener {
	int turn = 1;
	int win;
	int ttt[][] = new int[3][3];
	// ��ư �����
	// JButton
	JButton startBt = new JButton();
	boolean start;
	// ��ư ����
	// ���������� 3*3 ��ư�� ����
	final int SIZE = 65;
	JButton[] map = new JButton[9];

	public MyPanel() {
		setLayout(null); // ����Ʈ ���̾ƿ� ������ ������
		setBounds(0, 0, 600, 600);
		setBackground(Color.gray);

		// map�� �� ��ư ����
		// ��� -> panel�� add
		startBt.setBounds(265, 70, 65, 20);
		startBt.addActionListener(this);
		startBt.setVisible(true);
		add(startBt);
		int y = MyFrame.H / 2 - 100;
		int a = 0;
		for (int i = 0; i < map.length / 3; i += 1) {
			int x = MyFrame.W / 2 - 100;
			for (int j = 0; j < map.length / 3; j += 1) {
				map[a] = new JButton();
				map[a].setBounds(x, y, SIZE, SIZE);
//				map[a].setBorderPainted(false);
				map[a].addActionListener(this);
				map[a].setVisible(true);
				add(map[a]);
				x += SIZE;
				a += 1;
			}
			y += SIZE;
		}
		add(new HeadTitle());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton temp = (JButton) e.getSource();
		if (temp == startBt) {
			temp.setBackground(Color.gray);
			start = true;
		}
		for (int i = 0; i < map.length; i += 1) {
			if (map[i] == temp && ttt[i / 3][i % 3] == 0 && start == true && win == 0) {
				if (turn == 1) {
					temp.setBackground(Color.cyan);
					ttt[i / 3][i % 3] = turn;
					checkWin();
					if(check()) printWinner();
					turn = turn == 1 ? 2 : 1;
				} else if (turn == 2) {
					temp.setBackground(Color.yellow);
					ttt[i / 3][i % 3] = turn;
					checkWin();
					if(check()) printWinner();
					turn = turn == 1 ? 2 : 1;
				}
			}
		}
	}
	private void check2() {
		boolean checkPlace = false;
		for(int i = 0; i < ttt.length; i += 1) {
			for(int j = 0; j < ttt[i].length; j += 1) {
				if(ttt[i][j] == 0) checkPlace = true;
			}
		}
		if(!checkPlace && win == 0) {
			System.out.println("����");
		}
	}
	
	private boolean check() {
		if(win != 0) return true;
			return false;
	}
	
	private void printWinner() {
		System.out.printf("P%d �¸�", win);
	}
	
	private void checkWin() {
		check2();
		for (int i = 0; i < ttt.length; i += 1) {
			int cnt = 0;
			for (int j = 0; j < ttt[i].length; j += 1) {
				if (ttt[i][j] == turn) {
					cnt += 1;
				} else {
					cnt = 0;
				}
			}
			if (cnt == 3) {
				win = turn;
			}
		}
		for (int i = 0; i < ttt.length; i += 1) {
			int cnt = 0;
			for (int j = 0; j < ttt[i].length; j += 1) {
				if (ttt[j][i] == turn) {
					cnt += 1;
				} else {
					cnt = 0;
				}
			}
			if (cnt == 3) {
				win = turn;
			}
		}
		for (int i = 0; i < ttt.length; i += 1) {
			int cnt = 0;
			if (ttt[i][i] == turn) {
				cnt += 1;
			} else {
				cnt = 0;
			}
			if (cnt == 3) {
				win = turn;
			}
		}
		for (int i = 0; i < ttt.length; i += 1) {
			int cnt = 0;
			if (ttt[i][2-i] == turn) {
				cnt += 1;
			} else {
				cnt = 0;
			}
			if (cnt == 3) {
				win = turn;
			}
		}

	}
}

class MyFrame extends JFrame {

	private Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = dm.width;
	private int height = dm.height;
	public final static int W = 600;
	public final static int H = 600;

	public MyFrame(String title) {
		// �θ� �����ڸ� Ȱ���� �������� ���� ����
		super(title);
		setLayout(null); // ����Ʈ ���̾ƿ� ������ ������
		// �������� ũ�� ����
		// setBounds(x, y, width, height);
		setBounds(width / 2 - W / 2, height / 2 - H / 2, W, H);
		// �������� ���� ����(���)�� ���� (������, �������� ��������� �����尡 ������� ����)
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// �������� ���� ���̰� ����
		setVisible(true);
	}
}

public class Ex_jframe {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame("TicTacToe");
		frame.setContentPane(new MyPanel());

	}
}
