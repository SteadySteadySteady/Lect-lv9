package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.User;

public class UserManager {
	public static Scanner s = new Scanner(System.in);
	public static UserManager instance = new UserManager();
	ArrayList<User> users = new ArrayList<>();
	
	public void addUser() {
		System.out.print("ȸ�����Խ� �̿��� ID : ");
		String id = s.next();
		int idx = -1;
		for(int i = 0; i < this.users.size(); i += 1) {
			if(id.equals(this.users.get(i).getId())) {
				idx = i;
			}
		}
		if(idx != -1)
			System.out.println("ID�ߺ�");
		else {
			System.out.print("ȸ�����Խ� �̿��� PW : ");
			String pw = s.next();
			System.out.print("ȸ�����Խ� �̿��� �̸� : ");
			String nickName = s.next();
			idx = -1;
			for(int i = 0; i < this.users.size(); i += 1) {
				if(nickName.equals(this.users.get(i).getName())) {
					idx = i;
				}
			}
			if(idx != -1)
				System.out.println("�̸� �ߺ�");
			else {
				this.users.add(new User(id, pw, nickName));
				System.out.println("���� �Ϸ�");
			}
		}
	}
	
	public void removeUser(int log) {
		System.out.print("PW�Է� : ");
		String pw = s.next();
		if(pw.equals(this.users.get(log).getPw())) {
			this.users.remove(log);
			System.out.println("Ż�� �Ϸ�");
		} else {
			System.out.println("��й�ȣ�� Ȯ�����ּ���");
		}
	}
	
	public int logIn() {
		System.out.print("ID�Է� : ");
		String id = s.next();
		System.out.print("PW�Է� : ");
		String pw = s.next();
		int idx = -1;
		for(int i = 0; i < this.users.size(); i += 1) {
			if(id.equals(this.users.get(i).getId())) {
				idx = i;
			}
		}
		if(pw.equals(this.users.get(idx).getPw()))
			return idx;
		return -1;
	}
}
