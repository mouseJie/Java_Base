package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端：1、不断输入请求，2、获取返回信息
 * @author Administrator
 *
 */
public class Client {
	
	public static void main(String[] args) {
		//建立连接
		try {
			Socket s = new Socket("127.0.0.1", 8888);
			//请求服务端
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			while(true) {
				Scanner sc = new Scanner(System.in);
				String request = sc.nextLine();
				Thread th1 = new Thread() {
					public void run() {
						try {
							dos.writeUTF(request);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				};
				//获取服务端回应
				DataInputStream dis = new DataInputStream(s.getInputStream());
				System.out.println("服务端回应信息："+dis.readUTF());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		try {
//			Socket s = new Socket("127.0.0.1", 8888);
//			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
////			DataInputStream dis = new DataInputStream(s.getInputStream());
//			Scanner sc = new Scanner(System.in);
//			while (true) {
//				String content = sc.nextLine();
//				if (content.equals("quit")) {
//					sc.close();
//					break;
//				}
//				dos.writeUTF(content);
////				System.out.println("收到来自服务端的消息:" + dis.readUTF());
//			}
//			s.close();
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
