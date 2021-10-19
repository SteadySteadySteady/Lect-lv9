package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	Scanner s = new Scanner(System.in);
	public static Game instance = new Game();
	private Hero player;
	private ArrayList<Unit> zombies = new ArrayList<>();
	private boolean alive = true;
	private void setGame() {
		player = new Hero("��", 10, 3, 100, 0);
		zombies.add(new Zombie("����", 5, 5, 30, 3));
		zombies.add(new Zombie("����", 15, 0, 25, 7));
		zombies.add(new Zombie("����", 8, 10, 45, 9));
		zombies.add(new Zombie("����", 25, 5, 50, 13));
		zombies.add(new ZombieKing("��ũ", 5, 20, 70, 15, 100));
	}
	private void act() {
		player.print();
		System.out.print("1.[���� ��]");			
		if(player.getAct() == 0) {
			System.out.print(" 2.[��ȭ] 3.[�޽�]");
		}
		System.out.print("\n�Է� : ");
		int sel = s.nextInt();
		if(sel == 1) {
			player.setPos(player.getPos()+1);
			player.setAct(0);
		}
		else if(sel == 2 && player.getAct() == 0) {
			player.upgrade(player);
		}
		else if(sel == 3 && player.getAct() == 0) {
			int Hp = player.getHp()+30 > 100 ? 100 : player.getHp()+30;
			player.setHp(Hp);
			player.setAct(1);
		}
		else System.out.println("");
	}
	private void checkBattle() {
		for(int i = 0; i < zombies.size(); i += 1) {
			if(zombies.get(i).getPos() == player.getPos()) {
				battle(zombies.get(i));
			}
		}
	}
	private boolean checkEnd() {
		if(player.getPos() == 20) 
			return true;
		return false;
	}
	private void battle(Unit target) {
		while(alive) {
			target.print();
			player.print();
			battleAct(target);
			if(target.dead()) {
				System.out.println("���� �׿���");
				player.setPos(player.getPos()+1);
				break;
			}
			target.attack(player);
			if(player.dead()) {
				System.out.println("�׾���");
				alive = false;
				break;
			}
		}
	}
	
	private void battleAct(Unit target) {
		System.out.printf("1.[����] 2.[����]%d��\n�Է� : ", player.leftPotions());
		int sel = s.nextInt();
		if(sel == 1) player.attack(target);
		else if(sel == 2) player.potions(player);
		else System.out.println("�Ѵ� �ȾҴ�");
	}
	public void run() {
		setGame();
		while(alive) {
			act();
			checkBattle();
			if(checkEnd() == true) {
				System.out.println("���� ����");
				break;
			}
		}
	}
}