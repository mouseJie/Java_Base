package xiancheng.xiaofeizhe;

import java.util.LinkedList;

public class ThreadPool {
	// 线程池大小
	int threadPoolSize;
	// 任务容器
	LinkedList<Runnable> tasks = new LinkedList<>();

	// 消费任务
	public ThreadPool() {
		threadPoolSize = 10;
		synchronized (tasks) {
			for (int i = 0; i < threadPoolSize; i++) {
				new TaskConsumerThread("任务消费者线程"+i).start();
			}
		}
	}
	
	//增加任务
	public void add(Runnable obj) {
		synchronized (tasks) {
			tasks.add(obj);
			tasks.notifyAll();
		}
	}

	class TaskConsumerThread extends Thread {
		public TaskConsumerThread(String name) {
			super(name);
		}
		
		Runnable task;
		
		public void run() {
			System.out.println("启动："+this.getName());
			while(true) {
				synchronized (tasks) {
					while(tasks.isEmpty()) {
						try {
							tasks.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					task = tasks.removeLast();
					tasks.notifyAll();
				}
				System.out.println(this.getName()+"获取到任务，并执行");
				task.run();
			}
		}
	}
}
