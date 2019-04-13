package shuzhu;

import java.util.Arrays;

public class ArraysTest {
	public static void main(String[] args) {
        int a[] = new int[] { 18, 88, 68, 82, 65, 9 };
 
        // copyOfRange(int[] original, int from, int to)
        // 第一个参数表示源数组
        // 第二个参数表示开始位置(取得到)
        // 第三个参数表示结束位置(取不到)
        int[] b = Arrays.copyOfRange(a, 0, 3);

        System.out.println("排序前：");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        //排序
        Arrays.sort(b);
        System.out.println("排序后：");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println("数字 68出现的位置:"+Arrays.binarySearch(b, 68));
        //转化为字符串
        System.out.println(Arrays.toString(b));
    }
}
