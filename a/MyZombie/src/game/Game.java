package game;

import java.util.ArrayList;

public class Game {
	public static Game instance = new Game();
	private Unit player;
	private ArrayList<Unit> zombies = new ArrayList<>();
	private void setGame() {
		player = new Hero("나", 10, 3, 100, 0);
		zombies.add(new Zombie("좀비", 5, 5, 30, 3));
		zombies.add(new Zombie("헌터", 15, 0, 25, 7));
		zombies.add(new Zombie("좀비", 8, 10, 45, 9));
		zombies.add(new ZombieKing("차저", 15, 5, 50, 13, 0));
		zombies.add(new ZombieKing("탱크", 3, 15, 70, 15, 100));
	}
	public void run() {
		setGame();
	}
}