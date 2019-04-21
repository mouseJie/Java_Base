package xiancheng;

public class TestSisuo {
	public static void main(String[] args) {
		String a = "thread1";
		String b = "thread2";
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("线程1运行");
				//占有a后，才能够继续占有b
				synchronized (a) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("已占有a");
					synchronized (b) {
						System.out.println("已占有b");
					}
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				System.out.println("线程2运行");
				synchronized (b) {
					System.out.println("已占有b");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (a) {
						System.out.println("已占有a");
					}
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}
