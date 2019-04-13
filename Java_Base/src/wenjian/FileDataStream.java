package wenjian;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * DataInputStream 数据输入流
 * DataOutputStream 数据输出流
 * @author Administrator
 */
public class FileDataStream {
	public static void main(String[] args) {
		write();
		read();
	}
	
	private static void read() {
		File file = new File("F://java2test//lolEOF.txt");
		try(
//				FileInputStream fis = new FileInputStream(file);
//				DataInputStream dis = new DataInputStream(fis);
				DataInputStream dis = new DataInputStream(new FileInputStream(file))
		){
//			boolean b = dis.readBoolean();
//			int i =dis.readInt();
//			String str = dis.readUTF();
//			System.out.println("读取到布尔值："+b);
			System.out.println("读取到整型值："+dis.readChar());
//			System.out.println("读取到字符串"+str);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void write() {
		File file = new File("F://java2test//lolEOF.txt");
		try(
				FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
				DataOutputStream dos = new DataOutputStream(fos);
			){
//			dos.write(11);
			dos.writeChar(65);
//			dos.writeUTF("I love you");
//			dos.writeBoolean(true);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
