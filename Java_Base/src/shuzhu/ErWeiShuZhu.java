package shuzhu;

public class ErWeiShuZhu {
	public static void main(String[] args) {
		// 获取随机数
		int[][] a = new int[5][5];
		int max = 0;
		int maxX = 0;
		int maxY = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// 赋值随机数
				a[i][j] = (int) (Math.random() * 100);

				if (a[i][j] > max) {
					max = a[i][j];
					maxX = i;
					maxY = j;
				}
				// 使用\t记得 不要用println
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("\n");
		}

		System.out.println("最大值为：" + max + "，其坐标位置为：(" + maxX + "," + maxY + ")");
	}
}
