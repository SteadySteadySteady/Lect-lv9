package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.Account;
import models.User;

public class UserManager {
	public static final int MAX = 3;
	static Scanner s = new Scanner(System.in);
	static Random r = new Random();
	// User 배열 존재
	private ArrayList<User> users = null;
	public static UserManager instance = new UserManager();

	private UserManager() {
		this.users = new ArrayList<>();
	}
	
	public int getUserSize() {
		return this.users.size();
	}
	
	// 기능 구현
	// 가입
	public void join() {
		System.out.print("ID 입력 : ");
		String id = s.next();
		boolean idExist = false;
		for (int i = 0; i < this.users.size(); i += 1) {
			if (id.equals(this.users.get(i).getId())) {
				idExist = true;
			}
		}
		if (idExist) {
			System.out.println("ID중복");
		} else {
			System.out.print("PW 입력 : ");
			String pw = s.next();
			System.out.print("이름 입력 : ");
			String name = s.next();
			int code = 0;
			while (true) {
				int temp = r.nextInt(8999) + 1000;
				boolean exist = false;
				for (int i = 0; i < this.users.size(); i += 1) {
					if (this.users.get(i).getCode() == code) {
						exist = true;
						break;
					}
				}
				if (exist == false) {
					code = temp;
					break;
				}
			}
			this.users.add(new User(code, id, pw, name));
			System.out.println("회원가입 완료");
		}
	}

	// 탈퇴
	public void leave(int log) {
		System.out.print("PW 입력 : ");
		String pw = s.next();
		if (users.get(log).getPw().equals(pw)) {
			this.users.remove(log);
			System.out.println("탈퇴 완료");
		}
		else
			System.out.println("비밀번호가 틀렸습니다");
	}

	// 로그인
	public int idPwCheck(String id, String pw) {
		int log = -1;
		for (int i = 0; i < this.users.size(); i += 1) {
			if (id.equals(this.users.get(i).getId())) {
				log = i;
			}
		}
		if(pw.equals(this.users.get(log).getPw()))
			return log;
		return -1;
	}

	// 회원조회
	// ㄴ아이디
	public void printId(int log) {
		System.out.printf("ID : %s", users.get(log).getId());
	}

	// ㄴ패스워드
	public void printPw(int log) {
		System.out.printf("PW : %s", users.get(log).getPw());
	}

	// 이름
	public void printName(int log) {
		System.out.printf("NAME : %s", users.get(log).getName());
	}

	// 계좌 유무

	public ArrayList<Account> getAccs(int log) {
		return this.users.get(log).getAccs();
	}

	public int getAccCnt(int log) {
		return this.getAccs(log).size();
	}

	public void setAccMoney(int log, int idx, int money) {
		this.users.get(log).setMoney(idx, money);
	}

	public void printAccMoney(int log, int idx) {
		System.out.printf("현재 잔고 : %d원\n", this.getAccs(log).get(idx).getMoney());		
	}
	
	public void removeAcc(int log, int idx) {
		if(this.getAccs(log).get(idx).getMoney() != 0)
			System.out.println("잔고를 출금 또는 이체하여 잔고를 0원으로 만들어주시길 바랍니다");
		else
			this.getAccs(log).remove(idx);
	}
	
	// 계좌 생성
	public void addAcc(int log) {
		while(true) {
			int rNum = r.nextInt(89999)+10000;
			boolean exist = false;
			for(int i = 0; i < this.users.size(); i += 1) {
				for(int j = 0; j < this.users.get(i).getAccs().size(); j += 1) {
					if(rNum == this.users.get(i).getAccs().get(j).getAccNum()) {
						exist = true;
					}
				}
			}
			if(exist == false) {
				this.users.get(log).getAccs().add(new Account(this.users.get(log).getCode(), rNum));
				System.out.println("생성된 계좌번호 : " + rNum);
				break;
			}
		}
	}
	// ㄴ돈

	@Override
	public String toString() {
		String data = "";
		for(int i = 0; i < this.users.size(); i += 1) {
			data += this.users.get(i).getId()+"/";
			data += this.users.get(i).getPw()+"/";
			data += this.users.get(i).getName()+",";
			for(int j = 0; j < this.getAccs(i).size(); j += 1) {
				data += this.getAccs(i).get(j).getUserCode()+"/";
				data += this.getAccs(i).get(j).getAccNum()+"/";
				data += this.getAccs(i).get(j).getMoney()+"/";
			}
			if(i != this.users.size()-1) {
				data += "\n";
			}
		}
		return data;
	}
}