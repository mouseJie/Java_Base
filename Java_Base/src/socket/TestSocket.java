package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

public class TestSocket {
	private static Logger logger = Logger.getLogger(TestSocket.class);

	@Before
	public void init() {
		PropertyConfigurator.configure("D:\\git\\Java_Base\\Java_Base\\src\\log4j.properties");
	}

//	@Test
	public void getHost() {
		try {
			InetAddress host = InetAddress.getLocalHost();
			String ip = host.getHostAddress();
			logger.info(ip);
		} catch (UnknownHostException e) {
			logger.error(e);
		}
	}

//	 @Test
	public void ping() {
		try {
			Process p = Runtime.getRuntime().exec("ping 192.168.10.3");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "gbk"));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while (null != (line = br.readLine())) {
				if (line.length() > 0) {
					sb.append(line + "\r\n");
				}
			}
			logger.info(sb);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public static boolean ping(String ip) {
		boolean isPing = false;
		try {
			Process p = Runtime.getRuntime().exec("ping "+ip);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "gbk"));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while (null != (line = br.readLine())) {
				if (line.length() > 0) {
					sb.append(line + "\r\n");
				}
			}
			if (sb.toString().contains("TTL")) 
				isPing = true;
		} catch (IOException e) {
			logger.error("报错："+e);
		}
		return isPing;
	}

	/**
	 * 判断本网段可用IP
	 */
	@Test
	public void pingAll() {
		String ip = "192.168.10.";
		int i = 1;
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
		// 1、创建线程池
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 15, 1, TimeUnit.MINUTES, queue);
		// 2、创建任务--ping操作
		List<String> ipsucess = Collections.synchronizedList(new ArrayList<>());
		//锁定计数模块
		AtomicInteger number = new AtomicInteger();
		for (i = 1; i <= 100; i++) {
			String finalIP = ip + i;
//			PingRunnable runnable = new PingRunnable(ip + i, "线程", i);
//			executor.execute(runnable);
//			logger.info("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size()
//					+ "，已执行完别的任务数目：" + executor.getCompletedTaskCount());
			executor.execute(new Runnable() {
				
				@Override
				public void run() {
					if(ping(finalIP)) {
						ipsucess.add(finalIP);
						logger.info("ping通的ip为："+finalIP);
					}
					synchronized (number) {
						logger.info("已完成"+number.incrementAndGet());
					}
				}
			} );
		}
		executor.shutdown();
		try {
			if(executor.awaitTermination(30, TimeUnit.MINUTES)) {
				for(String str : ipsucess)
					logger.info("ping成功ip为："+str);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class PingRunnable implements Runnable {

	private String ip;
	private String name;
	private int i;

	public PingRunnable() {

	}

	public PingRunnable(String ip, String name, int i) {
		this.ip = ip;
		this.name = name;
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println("执行成功");
//		System.out.printf("线程%s%d执行结果：", name, i);
//		try {
//			Process p = Runtime.getRuntime().exec(ip);
//			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "gbk"));
//			String line = null;
//			StringBuilder sb = new StringBuilder();
//			while (null != (line = br.readLine())) {
//				if (line.length() > 0) {
//					sb.append(line + "\r\n");
//				}
//			}
//			System.out.println(sb.toString().contains("TTL") ? ip + "通" : ip + "不通");
//			br.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

}
