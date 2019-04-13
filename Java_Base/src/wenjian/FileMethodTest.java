package wenjian;

import java.io.File;
import java.io.IOException;

public class FileMethodTest {
	public static void main(String[] args) {
		File fileDir = new File("F://java2test");
		File file = new File("F://java2test//lol.txt");
		
		System.out.println("文件是否存在："+file.exists());
		
		String[] str = fileDir.list();
		System.out.println("该数组长度为"+str.length);
		for(String s : str) {
			System.out.println(s);
		}
		
		File[] fs = fileDir.listFiles();
		for(File f : fs) {
			System.out.println(f.getAbsolutePath());
		}
		
		System.out.println(file.getParent());
		System.out.println(file.getParentFile().getName());
	
		System.out.println("在当前文件目录下创建文件夹:"+file.mkdir());
		System.out.println(file.mkdirs());
		try {
		System.out.println(file.createNewFile());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
