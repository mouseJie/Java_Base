package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.Hero;

public class ComparatorTest {
	public static void main(String[] args) {
		List<Hero> list = new ArrayList<>();
		list.add(new Hero("hero",1,5));
		list.add(new Hero("hero",4,2));
		list.add(new Hero("hero",2,4));
		list.add(new Hero("hero",7,1));
		System.out.println(list);
		
		Collections.sort(list, new Comparator<Hero>() {
			public int compare(Hero h1, Hero h2) {
				return new Integer(h2.getDamage()).compareTo(new Integer(h1.getDamage()));
			}
		});
		System.out.println(list);
	}
}
