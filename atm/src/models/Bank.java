package models;

public class Bank {
	private String brand = "";
	public static Bank instance = new Bank(); 
	// Bank �ν��Ͻ�(��ü)�� �ý��� ���� ��, �����ϰ� �����ϵ��� �������
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}