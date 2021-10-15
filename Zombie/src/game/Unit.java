package game;

import java.util.Random;

public class Unit {
	Random r = new Random();
	private String name;
	private int hp;
	private int att;
	private int def;
	private int pos;
	
	public String getName() {
		return name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtt() {
		return att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public Unit(String name, int hp, int att, int def, int pos) {
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.pos = pos;
	}
	public void attack(Unit target) {
		int dam = (this.att - target.def)*(r.nextInt(150)+50)/100;
		if(dam<=0) dam = 1;
		System.out.println(name+"의 공격");
		System.out.println(dam+"의 대미지");
		target.setHp(target.getHp()-dam);
		System.out.println(target.name+"의 남은 HP : "+target.hp);
	}
	public void print() {
		System.out.println("[이름] : "+name+"    [체력] : "+hp);
		System.out.println("[공격력] : "+att+"  [방어력] : "+def+"  [위치] : "+pos);
	}
}
