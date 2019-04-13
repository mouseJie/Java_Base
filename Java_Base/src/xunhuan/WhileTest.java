package xunhuan;

import java.util.Scanner;

public class WhileTest {
	public static void main(String[] args) {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入开始阶乘值：");
			int num = sc.nextInt();
			if(num == 0000) {
				System.out.println("关闭输入器");
				sc.close();
				break;
			}
			int sum = 1;
			while(num>=1) {
				sum *= num;
				num--;
			}
			System.out.println("该阶乘值为："+sum);
		}
	}
}
