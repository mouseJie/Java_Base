package xiancheng;

public class TestStatic {
	public synchronized static void method1() throws InterruptedException {
		System.out.println("调用method1方法");
		Thread.sleep(5000);
	}
	
	public synchronized static void method2() throws InterruptedException {
		System.out.println("调用method2方法");
		Thread.sleep(5000);
	}
	
	static TestStatic ts1 = new TestStatic();
	static TestStatic ts2 = new TestStatic();
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ts1.method1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
	}
}
