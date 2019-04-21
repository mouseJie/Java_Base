package xiancheng.xiaofeizhe;

/**
 * 生产者线程
 * @author Administrator
 *
 */
public class Producer extends Thread{

	private Stack<Character> producer;
	private String name;
	
	public Producer(Stack<Character> producer, String name) {
		this.producer = producer;
		this.name = name;
	}
	
	@Override
	public void run() {
		this.setName(name);
		while(true) {
			char random = (char)(Math.random()*26+'A');
			System.out.println(this.getName()+"压入:" + random);
            producer.push(random);
		}
	}
	
}
