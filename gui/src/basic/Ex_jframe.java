package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
// import javax.swing.~ // 모든 클래스 사용
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// GUI : Graphic User Interface
//	ㄴ awt
//	ㄴ swing

// Jframe : 최상위 컨테이너
// JPanel : 컨테이너 <- 컴포넌트(요소들을 붙여나가 add()면서 완성함)
//	ㄴ JButton, JTextField, JLabel, JCheckBox ... 
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
	// 버튼 만들기
	// JButton
	JButton startBt = new JButton();
	boolean start;
	// 버튼 연습
	// 정방향으로 3*3 버튼의 나열
	final int SIZE = 65;
	JButton[] map = new JButton[9];

	public MyPanel() {
		setLayout(null); // 디폴트 레이아웃 구성을 삭제함
		setBounds(0, 0, 600, 600);
		setBackground(Color.gray);

		// map의 각 버튼 셋팅
		// 모두 -> panel에 add
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
			System.out.println("비겼다");
		}
	}
	
	private boolean check() {
		if(win != 0) return true;
			return false;
	}
	
	private void printWinner() {
		System.out.printf("P%d 승리", win);
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
		// 부모 생성자를 활용한 프레임의 제목 설정
		super(title);
		setLayout(null); // 디폴트 레이아웃 구성을 삭제함
		// 프레임의 크기 설정
		// setBounds(x, y, width, height);
		setBounds(width / 2 - W / 2, height / 2 - H / 2, W, H);
		// 프레임의 종료 연산(명령)을 결정 (생략시, 프레임은 사라지지만 스레드가 종료되지 않음)
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 프레임을 눈에 보이게 설정
		setVisible(true);
	}
}

public class Ex_jframe {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame("TicTacToe");
		frame.setContentPane(new MyPanel());

	}
}
