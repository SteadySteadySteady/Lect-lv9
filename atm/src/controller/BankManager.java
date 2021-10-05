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

	// 기능 메소드 구현

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
				System.out.println("로그인 후 이용가능");
			}
		} else if (sel == 3) {
			if (logCheck()) {
				System.out.print("ID 입력 : ");
				String id = s.next();
				System.out.print("PW 입력 : ");
				String pw = s.next();
				if (this.um.idPwCheck(id, pw) == -1) {
					System.out.println("ID 혹은 PW 확인");
				} else {
					this.log = this.um.idPwCheck(id, pw);
				}
			} else {
				System.out.println("이미 로그인된 아이디가 있습니다");
			}
		} else if (sel == 4) {
			if (logCheck())
				System.out.println("로그인 후 이용가능");
			else
				this.log = -1;
		} else if (sel == 5) {
			if (logCheck()) {
				System.out.println("로그인 후 이용가능");
			} else {
				if (this.um.checkAccCnt(this.log) == 0) {
					System.out.println("계좌 개설후 이용가능합니다");
				} else {
					int selAcc = selAcc();
					if (selAcc < 0 || selAcc >= this.um.getAccCnt(this.log)) {
						System.out.println("잘못된 값");
					} else {
						System.out.print("입금할 금액 입력 : ");
						int money = s.nextInt();
						if (money <= 0) {
							System.out.println("잘못된 값");
						} else {
							this.um.setAccMoney(this.log, selAcc, money);
							System.out.println("입금 완료");
						}
					}
				}
			}
		} else if (sel == 6) {
			if (logCheck()) {
				System.out.println("로그인 후 이용가능");
			} else {
				if (this.um.checkAccCnt(this.log) == 0) {
					System.out.println("계좌 개설후 이용가능합니다");
				} else {
					int selAcc = selAcc();
					if (selAcc < 0 || selAcc >= this.um.getAccCnt(this.log)) {
						System.out.println("잘못된 값");
					} else {
						System.out.print("출금할 금액 입력 : ");
						int money = s.nextInt();
						if (money <= 0) {
							System.out.println("잘못된 값");
						} else if (money < this.um.getAccs(this.log).get(selAcc).getMoney()) {
							System.out.println("잔액 부족");
						} else {
							this.um.setAccMoney(this.log, selAcc, -money);
							System.out.println("출금 완료");
						}
					}
				}
			}
		} else if (sel == 7) {
			if (logCheck()) {
				System.out.println("로그인 후 이용가능");
			} else {
				if (this.um.checkAccCnt(this.log) == 0) {
					System.out.println("계좌 개설후 이용가능합니다");
				} else {
					int selAcc = selAcc();
					if (selAcc < 0 || selAcc >= this.um.getAccCnt(this.log)) {
						System.out.println("잘못된 값");
					} else {
						System.out.print("이체할 계좌 입력 : ");
						String acc = s.next();

					}
				}
			}
		} else if (sel == 8) {
			if (logCheck()) {
				System.out.println("로그인 후 이용가능");
			} else {
				if (this.um.MAX <= this.um.getAccs(this.log).size()) {
					System.out.println("계좌는 3개이상 만들 수 없습니다");
				} else {
					this.um.addAcc(this.log);
				}
			}
		}
	}

	private void printMenu() {
		System.out.print("1.뱅킹기능 2.파일기능\n입력 : ");
		int sel = Integer.parseInt(s.next());
		if (sel == 1) {
			System.out.print("1.회원가입 2.회원탈퇴 3.로그인 4.로그아웃 5.입금 6.출금 7.이체 8.계좌생성 9.계좌철회\n입력 : ");
			selectMenu();
		} else if (sel == 2) {

		} else {
			System.out.println("잘못된 값");
		}
	}

	private int selAcc() {
		for (int i = 0; i < this.um.instance.getAccs(this.log).size(); i += 1) {
			System.out.printf("%d) %d\n", i + 1, this.um.instance.getAccs(this.log).get(i).getAccNum());
		}
		System.out.print("계좌 선택 : ");
		int selAcc = s.nextInt() - 1;
		return selAcc;
	}

	private void printAllAcc() {

	}
}