package fengzhuang;

public class StringBufferTest {
	public static void main(String[] args) {
		String s = "i am String";
		System.out.println(s.toCharArray());
		
		StringBuffer sb = new StringBuffer("hello mouse!");
		System.out.println(sb.append("what can I do for you"));

		char[] ch = sb.toString().toCharArray();
		System.out.println(ch);
		
		System.out.println(sb.insert(sb.length(), ",mouse"));
		
		StringBuffer sbInsert = sb.insert(sb.length(), ",mouse");
		char[] chInsert = sbInsert.toString().toCharArray();
		
		char[] chCopy = new char[1000];
		System.arraycopy(ch, 0, chCopy, 0, ch.length);
		System.out.println(chCopy);
		System.arraycopy(chInsert, 0, chCopy, ch.length, chInsert.length);
		System.out.println(chCopy);
	
	}
}
