package lv10test_zombie;

public class Unit {
	private int hp;
	private String name;
	private int ad;
	private int df;
	private int pos;
	public Unit(int hp, String name, int ad, int df, int pos) {
		this.hp = hp;
		this.name = name;
		this.ad = ad;
		this.df = df;
		this.pos = pos;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setAd(int ad) {
		this.ad = ad;
	}
	public void setDf(int df) {
		this.df = df;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	public int getHp() {
		return hp;
	}
	public int getAd() {
		return ad;
	}
	public int getDf() {
		return df;
	}
	public int getPos() {
		return pos;
	}
	public String getName() {
		return name;
	}
	public void printInfo() {
		System.out.printf("[%s] HP_%d AD_%d DF_%d\n", name, hp, ad, df);
	}
	public void attack(Unit target) {
		int dmg = ad - target.getDf();
		if(dmg <= 0) dmg = 1;
		System.out.printf("[%s]의 공격 %d의 피해\n", name, dmg);
		target.setHp(target.getHp()-dmg);
	}
	public boolean dead() {
		if(hp <= 0) return true;
			return false;
	}
}
