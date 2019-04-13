package base;

public class Test extends AbstractTest{

	public Test() {
		super();
		System.out.println("俺子类是可以实例化的");
	}
	
	@Override
	public void test() {
		System.out.println("俺是AbstractTest的子类，俺骄傲");
	}
	
	public static void main(String[] args) {
		AbstractTest a = new Test();
	}
}
