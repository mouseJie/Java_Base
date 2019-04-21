package xiancheng;
/**
 * start方法只是使线程进入就绪状态，要想线程结束，
 * 还要等待获取CPU资源来进入运行状态，运行完后结束线程。
 * sleep（1000）使线程挂起1000毫秒，1000毫秒过去重新竞争CPU资源。
 * 在一个时间点可以处理一个线程，在一个时间段可以处理多个线程（多核除外）。
 * @author Administrator
 */
public class TestTongbu {
	public static void main(String[] args) {
//		final Object someObject = new Object();
		TongbuHero h = new TongbuHero(1000);
		//重点：同步进行
		int threadCount = 10;
		Thread[] beidaThreads = new Thread[threadCount];
		Thread[] huifuThreads  = new Thread[threadCount];
		
		for(int i=0; i<threadCount; i++) {
			Thread t = new Thread() {
				@Override
				public void run() {
//					//任何线程要修改hp的值，必须先占用someObject
//					synchronized(someObject) {
//						h.beDamage(1);
//					}
					h.beDamage(1);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			beidaThreads[i] = t;
			t.start();
		}
		
		for(int i=0; i<threadCount; i++) {
			Thread t = new Thread() {
				@Override
				public void run() {
//					//任何线程要修改hp的值，必须先占用someObject
//					synchronized(someObject) {
//						h.huifu(1);
//					}
					h.huifu(1);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			huifuThreads[i] = t;
			t.start();
		}
		
		for(Thread t : beidaThreads) {
			try {
				t.join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(Thread t : huifuThreads) {
			try {
				t.join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class TongbuHero{
	public int hp;
	
	public TongbuHero(int hp) {
		this.hp = hp;
	}
	
	public void huifu(int num) {
		synchronized(this) {
			hp += num;
			System.out.printf("已回复血量%d，剩余血量%d%n", num, hp);
		}
	}
	
	public void beDamage(int num) {
		synchronized(this) {
			hp -= num;
			System.out.printf("损耗血量%d，剩余血量%d%n", num, hp);
		}
	}
}