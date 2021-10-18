package game;

import java.util.Random;

public class Unit {
	Random r = new Random();
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
	public void setPos(int pos) {
		this.pos = pos;
	}
	public void print() {
		System.out.printf("[%s] : HP_%d, AD_%d, DF_%d\n", name, hp, ad, df);
	}
	public void attack(Unit target) {
		int damage = ad-target.getDf();
		if(damage <= 0) damage = 1;
		target.setHp(target.getHp()-damage);
		System.out.printf("[%s]의 공격 %d의 피해\n", name, damage);
	}
	public boolean dead() {
		if(hp <=0) return true;
			return false;
	}
}
