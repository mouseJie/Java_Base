package fengzhuang;

public class StringTest1 {
	public static void main(String[] args) {
		/**
		 * 基础方法测试
		 */
//		String s = "I am your father";
//		char[] ch = s.toCharArray();
//		System.out.println("转换后字符数组为："+ch.length);
//		for(char c : ch) {
//			System.out.print(c);
//		}
//		System.out.println("\n"+s.indexOf(' '));
//		System.out.println(s.indexOf('a'));
//		
//		System.out.println(s.toLowerCase());
//		System.out.println(s.toUpperCase());
		
		/**
		 * 将最后一个two
		 */
//		String str = "Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";
//		//获取最后一次two出现的下标
//		int i = str.lastIndexOf("two");
//		//以该标志位置分开两个字符串
//		String str1 = str.substring(0, i);
//		String str2 = str.substring(i, str.length());
//	
//		String repStr = str2.replace("two", "two".toUpperCase());
//		
//		System.out.println(str1.concat(repStr));
		
		/**
		 * 间隔大小写
		 */
//		String str = "lengendary";
//		char s[] = str.toCharArray();
//		for(int i=0; i<s.length; i=i+2) {
//			s[i] = Character.toUpperCase(s[i]);
//		}
//		System.out.println(String.valueOf(s));
		
		/**
		 * 删除String某个位置字符
		 */
		String s = "i love //you";
		System.out.println(s.indexOf("//"));
		System.out.println(s.substring(0,s.indexOf("//")));
	}
}
