package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {
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
	
	public void load(String data) {
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String info = "";
			while(info != null) { 
				info += br.readLine()+"\n";
				
			}
			String splitLine[] = info.split("\n");
			
			fr.close();
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// 메소드
	// 저장
	// 로드
	
}