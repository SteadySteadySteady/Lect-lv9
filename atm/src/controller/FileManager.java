package controller;

import java.io.File;
import java.io.FileWriter;

public class FileManager {
	public static FileManager instance = new FileManager();
	String filename = "atm.txt";
	File atm = new File(filename);
	FileWriter fw = new FileWriter(atm);
	
	// 메소드
	// 저장
	// 로드
	
}