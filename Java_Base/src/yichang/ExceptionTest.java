package yichang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest {
	public static void main(String[] args) {
		File file = new File("F:\\测试文件夹\\tes.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			fis.close();
		} catch (Throwable e) {
			if(e instanceof FileNotFoundException) System.out.println("文件未找到");
		}
		finally {
			System.out.println("输出了我不一定行，孩纸，帮不了你");
		}
	}
}
