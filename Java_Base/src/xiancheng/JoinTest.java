package xiancheng;

public class JoinTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println("t1 is running");
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t1.join();
				}catch(InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println("t2 is running");
				}
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t2.join();
				}catch(InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println("t3 is running");
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
}
