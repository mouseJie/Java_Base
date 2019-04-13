package wenjian;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 *系统默认是gbk，eclipse中工作空间默认设置是utf-8
 *记事本保存默认是gbk 
 */
public class UnicodeTest {
	public static void main(String[] args) {
		/**
		 * 记事本保存为utf
		 */
		File fileUTF = new File("F://java2test//chineseUTF.txt");
		
		try(FileInputStream fis = new FileInputStream(fileUTF)){
			byte[] bytes = new byte[(int)fileUTF.length()];
			fis.read(bytes);
			for(byte b : bytes) {
				int i = b&0x000000ff;
				System.out.print(Integer.toHexString(i)+"\t");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		System.out.println("默认字符编码为："+Charset.defaultCharset());
		try(FileReader fr = new FileReader(fileUTF)){
			char[] ch = new char[(int)fileUTF.length()];
			fr.read(ch);
			System.out.println(new String(ch));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * 记事本默认保存为gbk
		 */
		File fileGBK = new File("F://java2test//chineseGBK.txt");
		try (FileInputStream fis = new FileInputStream(fileGBK)) {
			byte[] bytes = new byte[(int)fileGBK.length()];
			fis.read(bytes);
			for(byte b : bytes) {
				int i = b&0x000000ff;
				System.out.print(Integer.toHexString(i)+"\t");
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(FileReader fr = new FileReader(fileGBK)){
			char[] ch = new char[(int)fileGBK.length()];
			fr.read(ch);
			System.out.println(new String(ch));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * 因为FileReader是使用默认的字符编码，不可自行设置
		 */
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(fileGBK), "gbk")){
			char[] ch = new char[(int)fileGBK.length()];
			isr.read(ch);
			System.out.println("字符集编码GBK："+new String(ch));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
