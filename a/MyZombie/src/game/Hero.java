package game;

import java.util.Scanner;

public class Hero extends Unit{
	Scanner s = new Scanner(System.in);
	int potionLeft = 3;
	private int act;
	public Hero(String name, int ad, int df, int hp, int pos) {
		super(name, ad, df, hp, pos);
	}
	public void potions(Unit player) {
		if(potionLeft == 0) System.out.println("���� ������ ����");
		else {
			player.setHp(100);
			potionLeft -= 1;
		}
	}
	public int getAct() {
		return act;
	}
	public void upgrade(Unit player) {
		System.out.print("1.AD 2.DF\n�Է� : ");
		int sel = s.nextInt();
		if (sel == 1) {
			player.setAd(player.getAd()+3);
			act = 1;
		}
		else if (sel == 2) {
			player.setDf(player.getDf()+2);
			act = 1;
		}
		else System.out.println("�߸��� ��");
	}
}
