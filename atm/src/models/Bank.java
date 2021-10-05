package models;

public class Bank {
	private String brand = "";
	public static Bank instance = new Bank(); 
	// Bank 인스턴스(객체)가 시스템 실행 시, 유일하게 존재하도록 만들어줌
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}