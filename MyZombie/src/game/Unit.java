package game;

public class Unit {
	private String name;
	private int ad;
	private int df;
	private int hp;
	private int pos;
	public Unit(String name, int ad, int df, int hp, int pos) {
		this.name = name;
		this.ad = ad;
		this.df = df;
		this.hp = hp;
		this.pos = pos;
	}
	public String getName() {
		return name;
	}
	public int getAd() {
		return ad;
	}
	public void setAd(int ad) {
		this.ad = ad;
	}
	public int getDf() {
		return df;
	}
	public void setDf(int df) {
		this.df = df;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getPos() {
		return pos;
	}
	public void attack(Unit target) {
		
	}
}
