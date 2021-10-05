package controller;

import models.Bank;

public class Main {
	public static void main(String[] args) { // 시스템 실행을 하기 위한 메소드
		// 은행 브랜드를 지정하고,
		Bank.instance.setBrand("FNS");
		// 은행 시스템이
		BankManager.instance.run();
	}
}