package fanxing;

import java.util.Iterator;
import java.util.LinkedList;

import common.Hero;

public class MyStack<T> {
	LinkedList<T> values = new LinkedList<>();
	
	public void push(T t) {
		values.addLast(t);
	}
	
	public T pull() {
		return values.removeLast();
	}
	
	public T peek() {
		return values.getLast();
	}
	
//	@Override
//	public String toString() {
//		return "测试";
//	}
	
	public static void main(String[] args) {
		MyStack<String> strs = new MyStack<>();
		for(int i=0; i<4; i++) {
			strs.push("test"+i);
		}
		for(Iterator<String> iterator = strs.values.iterator();iterator.hasNext();){
		    System.out.println(iterator.next());
		}
		
		MyStack<Hero> heros = new MyStack<>();
		heros.push(new Hero("hero", 1));
		heros.push(new Hero("hero", 2));
		heros.push(new Hero("hero", 3));
		heros.push(new Hero("hero", 4));
		for(Iterator<Hero> iterator = heros.values.iterator();iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}
}
