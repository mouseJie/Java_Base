package wenjian;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class FileStreamTest {
	public static void main(String[] args) {
		File file = new File("F:\\java2test\\lol.txt");

		/**
		 * 文件输入流
		 */
		// try {
		// FileInputStream fis = new FileInputStream(file);
		// byte[] bytes = new byte[(int)file.length()];
		// fis.read(bytes);
		// for(byte b : bytes) {
		// System.out.println(b);
		// }
		// fis.close();
		// }catch(Throwable t) {
		// if(t instanceof FileNotFoundException) {
		// t.printStackTrace();
		// System.out.println("未找到文件");
		// }
		// }
		/**
		 * 文件输出流
		 */
//		try {
//			File writeFile = new File("F:\\java2test\\old\\name\\lurj\\newqq.txt");
//			// 判断父文件夹目录是否存在
//			if (!writeFile.getParentFile().exists())
//				System.out.println(writeFile.getParentFile().mkdirs());
//
//			byte[] writeBytes = new byte[] { 72, 101, 108, 108, 111 };
//			FileOutputStream fos = new FileOutputStream(writeFile);
//			fos.write(writeBytes);
//			fos.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String filePath = "F:\\java2test\\lol.txt";
		String copyPath = "F:\\java2test\\copy\\test\\copylol2.txt";
		try {
			copyFile(filePath, copyPath);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		/**
		 * 采用NIO切割大文件
		 */
//		Scanner scanner = new Scanner(System.in);
//	    scanner.nextLine();
//	    long startTime = System.currentTimeMillis();
//	    try {
//			splitFile("/Users/yangpeng/Documents/temp/big_file.csv",5);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	    long endTime = System.currentTimeMillis();
//	    System.out.println("耗费时间： " + (endTime - startTime) + " ms");
//	    scanner.nextLine();
	}

	/**
	 * 将一个文件复制保存到另外一个位置
	 */
	public static void copyFile(String filePath, String copyFilePath){
		File file = new File(filePath);
		byte[] bytes = new byte[(int)file.length()];
		//输入流
		try(FileInputStream fis = new FileInputStream(file)){
			fis.read(bytes);
		}catch(IOException e) {
			e.printStackTrace();
		}
		//输出流
		File copyFile = new File(copyFilePath);
		if(!copyFile.getParentFile().exists()) copyFile.getParentFile().mkdir();
		try(FileOutputStream fos = new FileOutputStream(copyFile)){
			fos.write(bytes);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 切割大文件为小文件
	 * 
	 * @throws FileNotFoundException
	 */
	public static void splitFile(String filePath, int fileCount) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		FileChannel fc = fis.getChannel();
		final long fileSize = fc.size();
		long average = fileSize / fileCount;
		long bufferSize = 200;
		ByteBuffer byteBuffer = ByteBuffer.allocate(Integer.valueOf(bufferSize + ""));
		long startPos = 0;
		long endPos = bufferSize > average ? 0 : average - bufferSize;
		for(int i=0; i<fileCount; i++) {
			if(i+1!=fileCount) {
				int read = fc.read(byteBuffer, endPos);
				readW:
					while(read != -1) {
						byteBuffer.flip();
						byte[] array = byteBuffer.array();
						for(int j=0; j<array.length; j++) {
							byte b = array[j];
							if(b == 10 || b==13) {
								endPos += j;
								break readW;
							}
						}
						endPos += bufferSize;
						byteBuffer.clear();
						read = fc.read(byteBuffer, endPos);
					}
			}else {
				endPos = fileSize;
			}
			
			FileOutputStream fos = new FileOutputStream(filePath+(i+1));
			FileChannel fosfc = fos.getChannel();
			fc.transferTo(startPos, endPos-startPos, fosfc);
			fosfc.close();
			fos.close();
			startPos = endPos+1;
			endPos += average;
		}
		
		fc.close();
		fis.close();
	}

}
