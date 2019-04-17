package list;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
		//HashSet中的数据不是按照插入顺序存放
		HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(13);
		hashSet.add(2);
		hashSet.add(8);
		System.out.println("HashSet类型集合输出为："+hashSet);
		
		//LinkedHashSet中的数据是按照插入顺序存放
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add(13);
		linkedHashSet.add(2);
		linkedHashSet.add(8);
		System.out.println("LinkedHashSet类型集合输出为："+linkedHashSet);
	
		//TreeSet 中的数据是进行了排序的
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(13);
		treeSet.add(2);
		treeSet.add(8);
		System.out.println("TreeSet类型集合输出为："+treeSet);
	}
}
