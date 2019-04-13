package yunsuanfu;

import java.time.Month;
import java.util.Scanner;

public class ScannerMonth {

	public static String formatMonth(int month) {
		switch (month) {
		case 1:
			return "一月";
		default:
			return "其他月";
		}
	}

//	public static void main(String[] args) {
//		while (true) {
//			Scanner sc = new Scanner(System.in);
//			System.out.println("请输入");
//			int month = sc.nextInt();
//			if (month == 0000) {
//				System.out.println("已退出");
//				sc.close();
//				break;
//			}
//			try {
//				System.out.println(Month.of(month));
//			} catch (Exception e) {
//				System.out.println("请输入正确的月份数字");
//			}
//			
//		}
//	}
}
