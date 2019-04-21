package wenjian;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindFile {
	public static long maxSize = 0;
	public static long minSize = Integer.MAX_VALUE;
	public static File maxFile = null;
	public static File minFile = null;

	/**
	 * 查找该文件目录下最大文件和最小文件
	 * 
	 * @param File
	 */
	public static void findMaxAndMinFile(File file) {
		System.out.println("查询中...");
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			if (null == files)
				files = new File[] {};
			for (File f : files) {
				findMaxAndMinFile(f);
			}
		}else {
			long fileLength = file.length();
			if (fileLength > maxSize) {
				maxSize = fileLength;
				maxFile = file;
			}
			if (fileLength < minSize) {
				minSize = fileLength;
				minFile = file;
			}
		}
	}

	/**
	 * 根据文件名或文件内容关键字查询
	 * 
	 * @param file
	 * @param key
	 *            查询关键字
	 * @param isBody(是否根据文件内容查询?true:是，false:否)
	 */
	public static void findFile(File file, String key, boolean isBody) {

		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (null == files)
				files = new File[] {};
			for (File f : file.listFiles()) {
				findFile(f, key, isBody);
			}
		} else {
			if (isBody) {
				readFiles(file, key);
			} else {
				if (file.getName().contains(key))
					System.out.printf("已找到所查询关键字文件：%s,文件路径为：%s%n", file.getName(), file.getAbsolutePath());
			}

		}
	}

	/**
	 * 读取文件
	 * 
	 * @param args
	 */
	public static void readFiles(File f, String key) {
		// 读取该文件内容
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "gbk");
				BufferedReader br = new BufferedReader(isr);) {
			while (true) {
				String line = br.readLine();
				if (null == line)
					break;
				if (line.contains(key)) {
					System.out.printf("已找到所查询关键字文件：%s,文件路径为：%s%n", f.getName(), f.getAbsolutePath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//查看最大和最小文件
		 File file = new File("F:\\java2test");
		 findMaxAndMinFile(file);
		 System.out.printf("最大的文件是%s，其大小是%d字节%n",maxFile.getAbsoluteFile(),maxSize);
		 System.out.printf("最小的文件是%s，其大小是%d字节%n",minFile.getAbsoluteFile(),minSize);

		// 查找具体文件
		System.out.println("根据文件名查找结果：");
		File file1 = new File("F:\\java2test");
		findFile(file1, "lol", false);

		// 查看具体文件里面内容
		System.out.println("根据文件内容查询结果：");
		File file2 = new File("F:\\java2test");
		findFile(file2, "", true);
	}
}
