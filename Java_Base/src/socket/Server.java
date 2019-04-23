package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * 服务端：1、拿到客户端数据，2、根据客户端数据去查数据库
 * 考虑到如果有多个客户端同时请求，那么就要求多线程回应（线程池中的任务缓存就是看客户端的请求）
 */
public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			Socket s = ss.accept();
			while(true) {
				//获取接收数据
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String request = dis.readUTF();
				System.out.println("接收到请求信息为："+request);
				//判断请求为“exit”则退出绝对循环
				if(request.equals("exit"))
					break;
				//调用数据库回传数据到客户端
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				//查询数据库拿回数据
				String response = "服务端收到信息";
				dos.writeUTF(response);
			}
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 15, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
	}
}
