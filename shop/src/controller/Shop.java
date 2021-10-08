package controller;

import java.util.Scanner;

public class Shop {
	UserManager um = UserManager.instance;
	ItemManager im = ItemManager.instance;
	boolean isRun;
	private void isRun() {
		this.isRun = true;
	}
	private void printMenu() {
		System.out.println("1.가입 2.탈퇴 3.로그인 4.로그아웃\n100.관리자 0.종료");
	}
	private void selectMenu() {
		System.out.print("입력 : ");
		int sel = Integer.parseInt(this.um.s.next());
		if(sel == 1) {
			
		} else if(sel == 2) {
			
		} else if(sel == 3) {
			
		} else if(sel == 4) {
			
		} else if(sel == 100) {
			
		} else if(sel == 0) {
			
		}
	}
	public void shopRun() {
		while(!this.isRun) {
			printMenu();
			selectMenu();
		}
	}
	
}
