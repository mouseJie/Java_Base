package wenjian;

import java.io.File;

public class FindFile {
	public static void main(String[] args) {
		File file = new File("C:\\Windows");
		File[] files = file.listFiles();
		long maxSize = 0;
		long minSize = Integer.MAX_VALUE;
		File maxFile = null;
		File minFile = null;
		for(File f : files) {
			long fileLength = f.length();
			if(f.isDirectory()) continue;
			if(fileLength>maxSize) {
				maxSize = fileLength;
				maxFile = f;
			}
			if(fileLength!=0 && fileLength<minSize) {
				minSize = fileLength;
				minFile = f;
			}
		}
		System.out.printf("最大的文件是%s，其大小是%d字节%n",maxFile.getAbsoluteFile(),maxSize);
		System.out.printf("最小的文件是%s，其大小是%d字节%n",minFile.getAbsoluteFile(),minSize);
	}
}
