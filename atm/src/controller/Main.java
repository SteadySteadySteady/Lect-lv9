package controller;

import models.Bank;

public class Main {
	public static void main(String[] args) { // �ý��� ������ �ϱ� ���� �޼ҵ�
		// ���� �귣�带 �����ϰ�,
		Bank.instance.setBrand("FNS");
		// ���� �ý�����
		BankManager.instance.run();
	}
}