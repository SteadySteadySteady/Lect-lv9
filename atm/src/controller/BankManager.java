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

	private void selectMenu() {
		int sel = s.nextInt();
		if (sel == 1) {
			this.um.join();
		} else if (sel == 2) {
			if (!logCheck()) {
				this.um.withdraw(this.log);
			} else {
				System.out.println("�α��� �� �̿밡��");
			}
		} else if (sel == 3) {
			if (logCheck()) {
				System.out.print("ID �Է� : ");
				String id = s.next();
				System.out.print("PW �Է� : ");
				String pw = s.next();
				if (this.um.idPwCheck(id, pw) == -1) {
					System.out.println("ID Ȥ�� PW Ȯ��");
				} else {
					this.log = this.um.idPwCheck(id, pw);
				}
			} else {
				System.out.println("�̹� �α��ε� ���̵� �ֽ��ϴ�");
			}
		} else if (sel == 4) {
			if (logCheck())
				System.out.println("�α��� �� �̿밡��");
			else
				this.log = -1;
		} else if (sel == 5) {
			if (logCheck()) {
				System.out.println("�α��� �� �̿밡��");
			} else {
				if (this.um.checkAccCnt(this.log) == 0) {
					System.out.println("���� ������ �̿밡���մϴ�");
				} else {
					int selAcc = selAcc();
					if (selAcc < 0 || selAcc >= this.um.getAccCnt(this.log)) {
						System.out.println("�߸��� ��");
					} else {
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
			}
		} else if (sel == 6) {
			if (logCheck()) {
				System.out.println("�α��� �� �̿밡��");
			} else {
				if (this.um.checkAccCnt(this.log) == 0) {
					System.out.println("���� ������ �̿밡���մϴ�");
				} else {
					int selAcc = selAcc();
					if (selAcc < 0 || selAcc >= this.um.getAccCnt(this.log)) {
						System.out.println("�߸��� ��");
					} else {
						System.out.print("����� �ݾ� �Է� : ");
						int money = s.nextInt();
						if (money <= 0) {
							System.out.println("�߸��� ��");
						} else if (money < this.um.getAccs(this.log).get(selAcc).getMoney()) {
							System.out.println("�ܾ� ����");
						} else {
							this.um.setAccMoney(this.log, selAcc, -money);
							System.out.println("��� �Ϸ�");
						}
					}
				}
			}
		} else if (sel == 7) {
			if (logCheck()) {
				System.out.println("�α��� �� �̿밡��");
			} else {
				if (this.um.checkAccCnt(this.log) == 0) {
					System.out.println("���� ������ �̿밡���մϴ�");
				} else {
					int selAcc = selAcc();
					if (selAcc < 0 || selAcc >= this.um.getAccCnt(this.log)) {
						System.out.println("�߸��� ��");
					} else {
						System.out.print("��ü�� ���� �Է� : ");
						String acc = s.next();

					}
				}
			}
		} else if (sel == 8) {
			if (logCheck()) {
				System.out.println("�α��� �� �̿밡��");
			} else {
				if (this.um.MAX <= this.um.getAccs(this.log).size()) {
					System.out.println("���´� 3���̻� ���� �� �����ϴ�");
				} else {
					this.um.addAcc(this.log);
				}
			}
		}
	}

	private void printMenu() {
		System.out.print("1.��ŷ��� 2.���ϱ��\n�Է� : ");
		int sel = Integer.parseInt(s.next());
		if (sel == 1) {
			System.out.print("1.ȸ������ 2.ȸ��Ż�� 3.�α��� 4.�α׾ƿ� 5.�Ա� 6.��� 7.��ü 8.���»��� 9.����öȸ\n�Է� : ");
			selectMenu();
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