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
		System.out.println("1.���� 2.Ż�� 3.�α��� 4.�α׾ƿ�\n100.������ 0.����");
	}
	private void selectMenu() {
		System.out.print("�Է� : ");
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
