package models;

import java.util.ArrayList;

public class User {
	private String id;
	private String pw;
	private String nickName;
	ArrayList<Cart> carts = new ArrayList<>();

	public User(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.nickName = name;
	}

	public String getId() {
		return this.id;
	}

	public String getPw() {
		return this.pw;
	}

	public String getName() {
		return this.nickName;
	}
	
}
