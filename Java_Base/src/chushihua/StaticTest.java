package chushihua;

public class StaticTest {
	private String name = "test";
	
	public StaticTest() {
		System.out.println("初始化");
	}
	
	{
		System.out.println("执行静态快");
	}
	
	public static void main(String[] args) {
		StaticTest s = new StaticTest();
	}
}
