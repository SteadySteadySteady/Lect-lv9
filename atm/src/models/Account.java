package models;

public class Account {
	
	private int userCode;
	private int accNum;
	private int money;
	
	public Account(int userCode, int accNum, int money) {
		this.userCode = userCode;
		this.accNum = accNum;
		this.money = money;
	}
	public int getUserCode() {
		return this.userCode;
	}
	public int getAccNum() {
		return this.accNum;
	}
	public int getMoney() {
		return this.money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}