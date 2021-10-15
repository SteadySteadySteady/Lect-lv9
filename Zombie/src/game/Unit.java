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
		System.out.println(name+"�� ����");
		System.out.println(dam+"�� �����");
		target.setHp(target.getHp()-dam);
		System.out.println(target.name+"�� ���� HP : "+target.hp);
	}
	public void print() {
		System.out.println("[�̸�] : "+name+"    [ü��] : "+hp);
		System.out.println("[���ݷ�] : "+att+"  [����] : "+def+"  [��ġ] : "+pos);
	}
}
