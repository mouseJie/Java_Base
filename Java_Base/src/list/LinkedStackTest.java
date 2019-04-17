package list;

import java.util.HashSet;
import java.util.LinkedList;

import common.Hero;
/**
 * 使用LinkedList实现Stack栈
 * FILO先入后出栈Stacks
 * @author Administrator
 *
 */
public class LinkedStackTest implements stackTest{

	LinkedList<Hero> list = new LinkedList<>();
	
	/**
	 * 插在了最外面
	 */
	@Override
	public void insertOutside(Hero h) {
		list.addFirst(h);
	}
	
	
	/**
	 * 插到了最里面
	 * @param h
	 */
	@Override
	public void insertInside(Hero h) {
		list.addLast(h);
	}

	/**
	 * 取出最后一个
	 */
	@Override
	public Hero pull() {
		return list.removeLast();
	}

	/**
	 * 查看最后一个
	 */
	@Override
	public Hero peek() {
//		return list.getLast();
		return list.getFirst();
	}
	
	public static void main(String[] args) {
		LinkedStackTest test = new LinkedStackTest();
		for(int i=0; i<5; i++) {
			test.insertOutside(new Hero("tester"+i));
//			System.out.println(test.peek());
		}
		System.out.println(test.list.getFirst());
		System.out.println(test.list.getLast());
		test.insertInside(new Hero("tester"+5));
		System.out.println(test.list.getFirst());
		System.out.println(test.list.getLast());
//		for(int i=0; i<4; i++) System.out.println(test.pull());
//		System.out.println(test.peek());
	}
}

interface stackTest {
	public void insertOutside(Hero h);

	public void insertInside(Hero h);
	
	public Hero pull();

	public Hero peek();
}