package xunhuan;

public class ContinueTest {
	public static void main(String[] args) {
		for (int i = 1; i < 20; i++) {
			//奇数跳过，偶数就接下去输出
			if (i % 2 == 1)
				continue;
			System.out.println("输出值为："+i);
		}
		
		System.out.println("100之间3和5的倍数值不输出");
		for(int i = 1; i < 20; i++) {
			if(i % 3 ==0 || i % 5 ==0)
				continue;
			System.out.println(i);
		}
	}
}
