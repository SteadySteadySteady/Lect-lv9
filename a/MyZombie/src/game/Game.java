package game;

import java.util.ArrayList;

public class Game {
	public static Game instance = new Game();
	private Unit player;
	private ArrayList<Unit> zombies = new ArrayList<>();
	private void setGame() {
		player = new Hero("��", 10, 3, 100, 0);
		zombies.add(new Zombie("����", 5, 5, 30, 3));
		zombies.add(new Zombie("����", 15, 0, 25, 7));
		zombies.add(new Zombie("����", 8, 10, 45, 9));
		zombies.add(new ZombieKing("����", 15, 5, 50, 13, 0));
		zombies.add(new ZombieKing("��ũ", 3, 15, 70, 15, 100));
	}
	public void run() {
		setGame();
	}
}