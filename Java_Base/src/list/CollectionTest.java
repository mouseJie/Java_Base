package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.Hero;

public class CollectionTest {
	public static void main(String[] args) {
		List<Hero> list = new ArrayList<>();
		list.add(new Hero("hero", 1));
		list.add(new Hero("hero", 6));
		list.add(new Hero("hero", 3));
		System.out.println(list);
//		Collections.reverse(list);
//		System.out.println("反转后为："+list);
		//1、如果是Integer类型List，则直接进行sort排序
		List<Integer> nums = new ArrayList<>();
		for(int i=0; i<10; i++) {
			nums.add(i);
		}
		//先混淆再排序
		Collections.shuffle(nums);
		System.out.println("混淆后nums为："+nums);
		Collections.sort(nums);
		System.out.println("排序后nums为："+nums);
		//2、自定义对象：
//		Collections.sort(list, new Comparator<Hero>() {
//			public int compare(Hero hero1, Hero hero2) {
//				//升序
////				return new Integer(hero1.getSign()).compareTo(new Integer(hero2.getSign()));
//				//降序
//				return new Integer(hero2.getSign()).compareTo(new Integer(hero1.getSign()));
//			}
//		});
//		System.out.println("排序后list为："+list);
		
		//向右滚动
		Collections.rotate(list, 1);
		System.out.println("向右滚动后list为："+list);
		
	}
}
