package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {
	private UserManager um = UserManager.instance;
	public static FileManager instance = new FileManager();
	String filename = "atm.txt";
	
	public void save(String data) {
		try {
			FileWriter fw = new FileWriter(filename);
			System.out.println(data);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void load() {
		String info = "";
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String temp = br.readLine();
				if(temp == null)
					break;
				info += temp+"\n";
			}
			fr.close();
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String splitLine[] = info.split("\n");
		for(int i = 0; i < splitLine.length; i += 1) {
			String splitDot[] = splitLine[i].split(",");
			String userInfoSplit[] = splitDot[0].split("/");
			this.um.addUser(Integer.parseInt(userInfoSplit[0]),
					userInfoSplit[1], userInfoSplit[2], userInfoSplit[3]);
			String accSplit[] = splitDot[1].split("_");
			for(int j = 0; j < accSplit.length; j += 1) {
				String accInfoSplit[] = accSplit[j].split("/");
				this.um.setAcc(i, Integer.parseInt(accInfoSplit[0]),
						Integer.parseInt(accInfoSplit[1]), Integer.parseInt(accInfoSplit[2]));
			}
		}
	}
	// 메소드
	// 저장
	// 로드
	
}