package xiancheng.xiaofeizhe;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Stack<T> {

	List<T> stack = Collections.synchronizedList(new LinkedList<>());

	/**
	 * 生产
	 * 
	 * @return
	 */
	public synchronized void push(T obj) {
		while (stack.size() == 10) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stack.add(obj);
		this.notifyAll();
	}

	/**
	 * 消费
	 * 
	 * @return
	 */
	public synchronized T pull() {
		if (stack.size() <= 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		T t = stack.remove(stack.size()-1);
		this.notifyAll();
		return t;
	}
	
	/**
	 * 查看最后一个值
	 * @return
	 */
	public T peek() {
        return stack.get(stack.size() - 1);
    }

	public static char random() {
		String pool = "";
		// for(int i='a'; i<'z'; i++) {
		// pool+=(char)i;
		// }
		for (int i = 'A'; i < 'Z'; i++) {
			pool += (char) i;
		}
		int i = (int) (Math.random() * pool.length());
		return pool.charAt(i);
	}
}
