package xiancheng;

public class WaitAndNotify {
	public static void main(String[] args) {
		Hero h = new Hero();
		h.name = "武器大师";
		h.hp = 10;
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					h.hurt();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					h.recover(10);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}
