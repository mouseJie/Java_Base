package base;

public abstract class AbstractTest {
	
	public  AbstractTest() {
		System.out.println("俺父类终于被实例化了，谢谢儿子");
	}
	
	public abstract void test();
}