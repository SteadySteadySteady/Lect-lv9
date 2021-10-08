package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.User;

public class UserManager {
	public static Scanner s = new Scanner(System.in);
	public static UserManager instance = new UserManager();
	ArrayList<User> users = new ArrayList<>();
	
	public void addUser() {
		System.out.print("회원가입시 이용할 ID : ");
		String id = s.next();
		int idx = -1;
		for(int i = 0; i < this.users.size(); i += 1) {
			if(id.equals(this.users.get(i).getId())) {
				idx = i;
			}
		}
		if(idx != -1)
			System.out.println("ID중복");
		else {
			System.out.print("회원가입시 이용할 PW : ");
			String pw = s.next();
			System.out.print("회원가입시 이용할 이름 : ");
			String nickName = s.next();
			idx = -1;
			for(int i = 0; i < this.users.size(); i += 1) {
				if(nickName.equals(this.users.get(i).getName())) {
					idx = i;
				}
			}
			if(idx != -1)
				System.out.println("이름 중복");
			else {
				this.users.add(new User(id, pw, nickName));
				System.out.println("가입 완료");
			}
		}
	}
	
	public void removeUser(int log) {
		System.out.print("PW입력 : ");
		String pw = s.next();
		if(pw.equals(this.users.get(log).getPw())) {
			this.users.remove(log);
			System.out.println("탈퇴 완료");
		} else {
			System.out.println("비밀번호를 확인해주세요");
		}
	}
	
	public int logIn() {
		System.out.print("ID입력 : ");
		String id = s.next();
		System.out.print("PW입력 : ");
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
