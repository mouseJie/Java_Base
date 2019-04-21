package wenjian;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 缓存流
 * 
 * @author Administrator 缓存字符输入流 BufferedReader 可以一次读取一行数据 PrintWriter 缓存字符输出流，
 *         可以一次写出一行数据 （理解为先冲一次厕所）有的时候，需要立即把数据写入到硬盘，而不是等缓存满了才写出去。 这时候就需要用到flush
 */
public class FileCacheStream {
	public static void main(String[] args) {
		File f = new File("F:\\java2test\\old\\name\\lurj\\newqq.txt");
		File fcache = new File("F://java2test//lolCache.txt");
		try (
//				FileReader fr = new FileReader(f); 
//				BufferedReader br = new BufferedReader(fr);
				//因需要能设置字符集编码，所以采用InputStreamReader
				InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "gbk");
				BufferedReader br = new BufferedReader(isr);
				FileWriter fw = new FileWriter(fcache);
				PrintWriter pw = new PrintWriter(fw);
				
		) {
			int i = 1;
			while(true) {
				String line = br.readLine();
				if(null == line) break;
				System.out.println(i+" --- "+line);
				i++;
				//顺便插入一行到新文件
				pw.println(line);
				//如果必要时候怕缓存区满，可以一行就直接先推送过去
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
