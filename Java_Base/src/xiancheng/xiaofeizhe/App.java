package xiancheng.xiaofeizhe;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class App {
	public static void main(String[] args) {
		/**
		 * 生产者与消费者问题测试
		 */
//		Stack<Character> stack = new Stack<>();
//		for(int i=0; i<2; i++) {
//			Producer p = new Producer(stack, "生产者"+i);
//			p.start();
//		}
//		for(int i=0; i<3; i++) {
//			Consumer c = new Consumer(stack, "消费者"+i);
//			c.start();
//		}
		/**
		 * 自定义线程池测试
		 */
//		ThreadPool threadPool = new ThreadPool();
//		for(int i=0; i<10; i++) {
//			Runnable r = new Runnable() {
//				
//				@Override
//				public void run() {
//					System.out.println("任务发布");
//				}
//			};
//			threadPool.add(r);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		/**
		 * java自带线程池测试
		 */
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		threadPoolExecutor.execute(new Runnable(){
			@Override
			public void run() {
				System.out.println("任务发布");
				//方法：查找文件
			}
		});
	}
}
