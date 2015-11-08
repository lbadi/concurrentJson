package com.hufflepuff;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

	public String read(String path){
		File file = new File(path);
	
		try (FileInputStream fis = new FileInputStream(file)) {
	
			StringBuilder strBuilder = new StringBuilder();
			int content;
			while ((content = fis.read()) != -1) {
				strBuilder.append((char)content);
			}
			return strBuilder.toString();
	
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
