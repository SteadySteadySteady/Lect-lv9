package models;

import java.util.ArrayList;
import java.util.Random;

public class User {
	Random r = new Random();
	private int code; // 1000~9999 Áßº¹X ·£´ý°ª
	private String id;
	private String pw;
	private String name;
	private int accCnt;
	private ArrayList<Account> accs = new ArrayList<>();
	
	public User(int code, String id, String pw, String name) {
		this.code = code;
		this.id = id;
		this.name = name;
		this.pw = pw;
	}
	
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
	public int getCode() {
		return this.code;
	}
	public String getName() {
		return this.name;
	}
	public ArrayList<Account> getAccs() {
		return this.accs;
	}
	public int getAccCnt() {
		return this.accCnt;
	}
	
	public void setMoney(int log, int money) {
		this.accs.get(log).setMoney(money + this.accs.get(log).getMoney());
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}