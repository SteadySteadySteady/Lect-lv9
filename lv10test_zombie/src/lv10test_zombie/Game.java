package lv10test_zombie;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	public static Game instance = new Game();
	Scanner s = new Scanner(System.in);
	private boolean alive = true;
	private Hero player = new Hero(100, "나", 10, 3, 0);
	private ArrayList<Unit> zombies;
	
	private void setGame() {
		zombies = new ArrayList<>();
		zombies.add(new Zombie(25, "좀비", 10, 0, 1));
		zombies.add(new Zombie(40, "좀비", 10, 0, 4));
		zombies.add(new Zombie(20, "민첩한 좀비", 10, 15, 7));
		zombies.add(new Zombie(60, "단단한 좀비", 13, 20, 11));
		zombies.add(new Zombie(65, "숙주 좀비", 25, 15, 15));
		zombies.add(new ZombieKing(100, "탱크", 15, 20, 19, 50));
	}
	private void act() {
		player.printInfo();
		System.out.printf("현재 층 : %d\n1.[올라가기] ", player.getPos());
		if(player.getAct()) System.out.print("2.[강화] 3.[휴식]");
		System.out.print("\n입력 : ");
		int sel = s.nextInt();
		if(sel == 1) {
			player.setPos(player.getPos()+1);
		}
		else if(sel == 2 && player.getAct()) {
			System.out.println("1.[AD] 2.[DF]");
			int upSel = s.nextInt();
			player.upgrade(upSel);
			act();
			player.setAct(true);
		} 
		else if(sel == 3 && player.getAct()) {
			int hp = player.getHp()+30 >= 100 ? 100 : player.getHp()+30;
			player.setHp(hp);
			player.setAct(false);
			act();
			player.setAct(true);
		}
	}
	private void battle(Unit target) {
		while(alive) {
			player.printInfo();
			target.printInfo();
			battleAct(target);
			if(!target.dead()) target.attack(player);
			else {
				System.out.printf("[%s]를 처치했다\n", target.getName());
				break;
			}
			if(player.dead()) {
				alive = false;
				System.out.println("죽었다..");
			}			
		}
	}
	private void battleAct(Unit target) {
		System.out.printf("1.[공격] 2.[포션사용](%d개)\n", player.getLeftPotions());
		int sel = s.nextInt();
		if(sel == 1) {
			player.attack(target);
		}
		else if(sel == 2) {
			player.potion();
		}
		else System.out.println("멍 때렸다");
	}
	private void checkUnitPos() {
		for(int i = 0; i < zombies.size(); i += 1) {
			if(player.getPos() == zombies.get(i).getPos()) battle(zombies.get(i));
		}
	}
	private boolean checkEnd() {
		if(player.getPos() == 20) return true;
			return false;
	}
	public void run() {
		setGame();
		while(alive) {
			checkUnitPos();
			act();
			if(checkEnd()) {
				System.out.println("생존에 성공했다");
				break;
			}
		}
	}
}
