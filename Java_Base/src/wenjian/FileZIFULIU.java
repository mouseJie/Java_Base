package wenjian;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileZIFULIU {
	public static char[] encodeFile(char[] ch) {
		for(int i=0; i<ch.length; i++) {
			if(Character.isLetterOrDigit(ch[i])) 
				ch[i] = turnRight(String.valueOf(ch[i]).hashCode());
		}
		System.out.print("加密后为：");
		System.out.println(ch);
		return ch;
	}
	
	public static char[] decodeFile(char[] ch) {
		for(int i=0; i<ch.length; i++) {
			if(Character.isLetterOrDigit(ch[i])) 
				ch[i] = turnLeft(String.valueOf(ch[i]).hashCode());
		}
		System.out.print("解密后为：");
		System.out.println(ch);
		return ch;
	}
	
	public static char turnRight(int asciicode) {
		return Character.toChars(asciicode+1)[0];
	}
	
	public static char turnLeft(int asciicode) {
		return Character.toChars(asciicode-1)[0];
	}
	
	public static void main(String[] args) {
		File file = new File("F://java2test//lol.txt");
		File outFile = new File("F://java2test//lolOut.txt");
		
		String fileData = "";
		try(FileReader fr = new FileReader(file)){
			char[] ch = new char[(int)file.length()];
			fr.read(ch);
			fileData = String.valueOf(ch);
			System.out.println("获取到的文件数据为："+fileData);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * 加密
		 */
		try(FileWriter fw = new FileWriter(outFile)){
			fw.write(encodeFile(fileData.toCharArray()));
//			decodeFile(fileData.toCharArray());
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * 解密
		 */
		try(FileReader fr = new FileReader(outFile)){
			char[] ch = new char[(int)outFile.length()];
			fr.read(ch);
			System.out.println(decodeFile(ch));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
