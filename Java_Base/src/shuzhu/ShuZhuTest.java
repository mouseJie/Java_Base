package shuzhu;

import java.util.Arrays;

public class ShuZhuTest {
	public static void main(String[] args) {
		
		/**
		 * 初始化数组
		 */
//		int[] a = new int[5];
//		for(int i=0; i<5; i++) {
//			double randomNum = Math.random();
//			System.out.println(randomNum);
//			a[i] = (int)(randomNum*100);
//			System.out.println("a["+i+"]："+a[i]);
//		}
//		int[] b = new int[] {1,1,1,1,1};
//		String[] strs = new String[] {"",""};
		
		/**
		 * 选择法排序
		 */
//		int[] a = new int[] {78,2,55,15,456,11};
//		//从小到大排序
//		for(int i = 0; i < a.length; i++) {
//			for(int j = i+1; j < a.length; j++) {
//				if(a[j]<a[i]) {
////					temp = a[i];
////					a[i] = a[j];
////					a[j] = temp;
//					int temp = a[i];
//					a[i] = a[j];
//					a[j] = temp;
//				}
//			}
//		}
//		System.out.println("选择法排序后结果为：");
//		for(int i = 0; i < a.length; i++) {
//			System.out.println(a[i]);
//		}
		
		/**
		 * 冒泡法排序
		 */
		int[] a = new int[] {78,2,55,15,456,11,10};
		//外循环就负责将最后一位的位置不断向前移动，不断向前移动接受内循环的最后一位赋值max
		for(int j = a.length-1; j >0; j--) {
			//内循环会将max值移向最后一位
			for(int i=0; i<j; i++) {
				if(a[i]>a[i+1]) {
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		}
		
		System.out.println("冒泡法排序后结果为：");
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		
		/**
		 * 数组的copy
		 */
		//方法二: System.arraycopy(src, srcPos, dest, destPos, length)
        //src: 源数组
        //srcPos: 从源数组复制数据的启始位置
        //dest: 目标数组
        //destPos: 复制到目标数组的启始位置
        //length: 复制的长度       
		int[] b = new int[10];
        System.arraycopy(a, 0, b, 0, 3);
	}
}
