package list;

import java.util.Iterator;
import java.util.LinkedList;
//import java.util.List;
import java.util.Queue;
import java.util.Deque;

import common.Hero;

public class LinkListTest {
	public static void main(String[] args) {
//		List<Hero>  l = new LinkedList<>();
//		Deque<Hero> d = new LinkedList<>();
//		Queue<Hero> q = new LinkedList<>();
		
		/**
		 * Deque
		 */
		Deque<Hero> deque = new LinkedList<>();
		deque.add(new Hero("TIMO"));
		deque.add(new Hero("VN"));
		deque.add(new Hero("EZ"));
		System.out.println("Deque输出为：");
		for(Iterator<Hero> it = deque.iterator();it.hasNext();) {
			System.out.println(it.next());
		}
		
		/**
		 * Queue
		 */
		Queue<Hero> queue = new LinkedList<>();
		queue.add(new Hero("TIMO"));
		queue.add(new Hero("VN"));
		queue.add(new Hero("EZ"));
		
		queue.offer(new Hero(""));
		System.out.println("Queue输出为：");
		for(Iterator<Hero> it = queue.iterator();it.hasNext();) {
			System.out.println(it.next());
		}
	}
}
