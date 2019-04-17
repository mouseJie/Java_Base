package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.Hero;

/**
 * 直接让Hero实现Comparable<E>接口，将compareTo在hero直接重写定义好
 * @author Administrator
 *
 */
public class ComparableTest {
	public static void main(String[] args) {
		List<Hero> list = new ArrayList<>();
		list.add(new Hero("hero",1,5));
		list.add(new Hero("hero",4,2));
		list.add(new Hero("hero",2,4));
		list.add(new Hero("hero",7,1));
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}
