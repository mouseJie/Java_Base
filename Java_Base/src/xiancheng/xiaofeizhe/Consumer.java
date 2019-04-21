package xiancheng.xiaofeizhe;

/**
 * 消费者线程
 * @author Administrator
 *
 */
public class Consumer<T> extends Thread{
	private Stack<T> consumer;
	private String name;
	
	public Consumer(Stack<T> consumer, String name) {
		this.consumer = consumer;
		this.name = name;
	}
	
	@Override
	public void run() {
		this.setName(name);
		while(true) {
			System.out.println(this.getName() +"弹出: "+consumer.pull());
		}
	}
}
