package xiancheng;

public class NimingTest {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				System.out.println("俺是匿名类线程");
			}
		};
		t1.start();
	}
}
