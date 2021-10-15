package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	Random r = new Random();
	Scanner s = new Scanner(System.in);
	private Game() {}
	private static Game instance = new Game();
	public static Game getinstance() {return instance;}
	private Hero p;
	private ArrayList<Unit> enemy = new ArrayList<>();
	private void init() {
		p = new Hero("용사", 100, 5, 1, 1);
		enemy.add(new Zombie("좀비", 25, 5, 1, 3));
		enemy.add(new Zombie("힘쌘좀비", 45, 10, 2, 6));
		enemy.add(new Zombie("정예좀비", 65, 15, 3, 9));
		enemy.add(new ZombieKing("좀비왕", 100, 20, 4, 12, 50));
	}
	private int check() {
		for(int i = 0; i < enemy.size(); i += 1) {
			if(p.getPos() == enemy.get(i).getPos()) {
				System.out.println("좀비 출현");
				return i;
			}
		}
		return -1;
	}
	private int die(Unit a) {
		if(p.getHp() <= 0) {
			return 1;
		} else if(a.getHp() <= 0) {
			return 2;
		} else {
			return 0;
		}
	}
	private boolean fight(Unit enemy) {
		while(true) {
			p.print();
			System.out.println("===== VS =====");
			enemy.print();
			System.out.println("--------------");
			System.out.println("1.공격  2.물약("+p.getCnt()+"개 남음)");
			int sel = s.nextInt();
			if(sel == 1) {
				p.attack(enemy);
			} else if(sel == 2) {
				p.drink();
			}
			if(die(enemy)!= 0) {
				break;
			}
			System.out.println();
			enemy.attack(p);
			if(die(enemy)!=0) {
				break;
			}
			System.out.println();
		}
		if(die(enemy)==1) {
			System.out.println("YOU DIED");
			return false;
		}
		else {
			System.out.println("승리했다");
			return true;
		}
	}
	private void map(int a) {
		System.out.println("[ 현재 층 : "+p.getPos()+" ]");
		System.out.println("[1] : 올라간다");
		if(a==1) {
			System.out.println("[2] : 휴식");
			System.out.println("[3] : 강화");
		}
	}
	public void run() {
		init();
		int act = 1;
		while(true) {
			if(p.getPos() >= 12) {
				System.out.println("생존 성공");
				break;
			}
			map(act);
			int sel = s.nextInt();
			if(sel == 1) {
				p.setPos(p.getPos()+1);
				int check = check();
				if(check != -1) {
					boolean a = fight(enemy.get(check));
					if(a == false) {
						break;
					}
				} else {
					System.out.println("아무일도 일어나지 않았다");
				}
				act = 1;
			} else if(sel == 2 && act == 1) {
				int rNum = r.nextInt(40)+20;
				p.setHp(p.getHp()+rNum);
				System.out.println("체력을 "+rNum+"만큼 회복했다");
				act = 2;
			} else if(sel == 3 && act == 1) {
				int rNum = r.nextInt(2)+1;
				if(rNum == 1) {
					rNum = r.nextInt(3)+1;
					p.setAtt(p.getAtt()+rNum);
					System.out.println("공격력이 "+rNum+"만큼 증가했다");
				} else if(rNum == 2) {
					rNum = r.nextInt(3)+1;
					p.setDef(p.getDef()+rNum);
					System.out.println("방어력이 "+rNum+"만큼 증가했다");
				}
				act = 2;
			}
		}
	}
}
