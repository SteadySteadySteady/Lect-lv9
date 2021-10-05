package controller;

import java.util.Random;
import java.util.Scanner;

import models.Bank;
import models.User;

public class BankManager {
	int log = -1;
	static Scanner s = new Scanner(System.in);
	static Random r = new Random();
	public static BankManager instance = new BankManager();
	private FileManager fm = FileManager.instance;
	private UserManager um = UserManager.instance;
	boolean pass = true;
	// ��� �޼ҵ� ����

	public void run() {
		boolean isRun = true;
		while (isRun) {
			printAllAcc();
			printMenu();
		}
	}

	private boolean logCheck() {
		if (log == -1)
			return true;
		return false;
	}

	private void logIn() {
		System.out.print("ID �Է� : ");
		String id = s.next();
		System.out.print("PW �Է� : ");
		String pw = s.next();
		if (this.um.idPwCheck(id, pw) == -1) {
			System.out.println("ID Ȥ�� PW Ȯ��");
		} else {
			this.log = this.um.idPwCheck(id, pw);
			System.out.println("�α��� �Ϸ�");
		}
	}
	
	private void selectMenu() {
		int sel = s.nextInt();
		if (sel == 1) {
			this.um.join();
		} else if (sel == 2) {
			if (!logCheck()) {
				this.um.leave(this.log);
			} else {
				System.out.println("�α��� �� �̿밡��");
			}
		} else if (sel == 3) {
			if (logCheck())
				logIn();
			else 
				System.out.println("�̹� �α��ε� ���̵� �ֽ��ϴ�");
		} else if (sel == 4) {
			if (logCheck())
				System.out.println("�α��� �� �̿밡��");
			else
				this.log = -1;
		} else if (sel == 5) {
			if (logCheck()) {
				System.out.println("�α��� �� �̿밡��");
			} else {
				if (this.um.getAccCnt(this.log) == 0) {
					System.out.println("���� ������ �̿밡���մϴ�");
				} else 
					deposit();
			}
		} else if (sel == 6) {
			if (logCheck()) {
				System.out.println("�α��� �� �̿밡��");
			} else {
				if (this.um.getAccCnt(this.log) == 0) {
					System.out.println("���� ������ �̿밡���մϴ�");
				} else 
					withdraw();
			}
		} else if (sel == 7) {
			if (logCheck()) {
				System.out.println("�α��� �� �̿밡��");
			} else {
				if (this.um.getAccCnt(this.log) == 0) {
					System.out.println("���� ������ �̿밡���մϴ�");
				} else {
					int selAcc = selAcc();
					if (selAcc < 0 || selAcc >= this.um.getAccCnt(this.log)) {
						System.out.println("�߸��� ��");
					} else {
						System.out.print("��ü�� ���� �Է� : ");
						int acc = Integer.parseInt(s.next());
						int userNum = -1;
						int accNum = -1;
						for(int i = 0; i < this.um.getUserSize(); i += 1) {
							for(int j = 0; j < this.um.getAccCnt(i); j += 1) {
								if(acc == this.um.getAccs(i).get(j).getAccNum()) {
									userNum = i;
									accNum = j;
									break;
								}
							}
						}
						if(userNum == -1 || accNum == -1) {
							System.out.println("���� ����");
						} else {
							
						}
					}
				}
			}
		} else if (sel == 8) {
			if (logCheck()) {
				System.out.println("�α��� �� �̿밡��");
			} else 
				addAcc();
		} else if (sel == 10) {
			this.pass = false;
		}
	}

	private void addAcc() {
		if (this.um.MAX <= this.um.getAccs(this.log).size()) {
			System.out.println("���´� 3���̻� ���� �� �����ϴ�");
		} else {
			this.um.addAcc(this.log);
			System.out.println("���� �����Ϸ�");
		}
	}

	private void withdraw() {
		int selAcc = selAcc();
		if (selAcc < 0 || selAcc >= this.um.getAccCnt(this.log)) {
			System.out.println("�߸��� ��");
		} else {
			this.um.printAccMoney(this.log, selAcc);
			System.out.print("����� �ݾ� �Է� : ");
			int money = s.nextInt();
			if (money <= 0) {
				System.out.println("�߸��� ��");
			} else if (money > this.um.getAccs(this.log).get(selAcc).getMoney()) {
				System.out.println("�ܾ� ����");
			} else {
				this.um.setAccMoney(this.log, selAcc, -money);
				System.out.println("��� �Ϸ�");
			}
		}
	}

	private void deposit() {
		int selAcc = selAcc();
		if (selAcc < 0 || selAcc >= this.um.getAccCnt(this.log)) {
			System.out.println("�߸��� ��");
		} else {
			this.um.printAccMoney(this.log, selAcc);
			System.out.print("�Ա��� �ݾ� �Է� : ");
			int money = s.nextInt();
			if (money <= 0) {
				System.out.println("�߸��� ��");
			} else {
				this.um.setAccMoney(this.log, selAcc, money);
				System.out.println("�Ա� �Ϸ�");
			}
		}
	}

	private void printMenu() {
		System.out.print("1.��ŷ��� 2.���ϱ��\n�Է� : ");
		int sel = Integer.parseInt(s.next());
		if (sel == 1) {
			this.pass = true;
			while(this.pass) {
				System.out.print("1.ȸ������ 2.ȸ��Ż�� 3.�α��� 4.�α׾ƿ� 5.�Ա� 6.��� 7.��ü 8.���»��� 9.����öȸ 10.�ڷΰ���\n�Է� : ");
				selectMenu();				
			}
		} else if (sel == 2) {
			
		} else {
			System.out.println("�߸��� ��");
		}
	}
	
	private int selAcc() {
		for (int i = 0; i < this.um.instance.getAccs(this.log).size(); i += 1) {
			System.out.printf("%d) %d\n", i + 1, this.um.instance.getAccs(this.log).get(i).getAccNum());
		}
		System.out.print("���� ���� : ");
		int selAcc = s.nextInt() - 1;
		return selAcc;
	}

	private void printAllAcc() {

	}
}