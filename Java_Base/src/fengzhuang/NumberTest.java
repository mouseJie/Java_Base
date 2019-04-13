package fengzhuang;

public class NumberTest {
	public static void main(String[] args) {
		Integer int1 = new Integer(2);
		Integer int2 = 2147483647;
		System.out.println(int1.intValue());
		System.out.println(int2);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.max(int1, int2));
		
		Float float1 =(float)int2 ;
		//Integer不能直接转Double
		Double double1 = new Double(int2.intValue());
		System.out.println(float1);
		System.out.println(float1.doubleValue());
		System.out.println(double1);
		
		String s = "test";
		s = s+"2";
		System.out.println(s);
	}
}
