package fanxing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Administrator
 *
 * @param <T>是有实现Compareble接口的对象，例如我们自己创建的FXHero或Integer
 */
public class Node<T extends Comparable<T>> {
	public Node<T> leftNode;
	public Node<T> rightNode;
	public T value;

	public void add(T v) {
		if (null == value) {
			value = v;
		} else {
//			if ((Integer) v - (Integer) value <= 0) {
//				if (null == leftNode)
//					leftNode = new Node<T>();
//				leftNode.add(v);
//			} else {
//				if (null == rightNode)
//					rightNode = new Node<T>();
//				rightNode.add(v);
//			}
			//采用泛型后
			if(v.compareTo(value)<=0) {
				if(null == leftNode)
					leftNode = new Node<T>();
				leftNode.add(v);
			}else {
				if(null == rightNode)
					rightNode = new Node<T>();
				rightNode.add(v);
			}
		}
	}

	// 中序遍历所有的节点
	public List<T> values() {
		List<T> values = new ArrayList<>();

		// 左节点的遍历结果
		if (null != leftNode)
			values.addAll(leftNode.values());

		// 当前节点
		values.add(value);

		// 右节点的遍历结果
		if (null != rightNode)

			values.addAll(rightNode.values());

		return values;
	}

	public static void main(String[] args) {
		Node<Integer> nodeInt = new Node<>();
		for (int i = 0; i < 10; i++) {
			nodeInt.add(random());
		}
		System.out.println(nodeInt.values());
		
		
		Node<FXHero> heros = new Node<>();
		heros.add(new FXHero("W薇恩"));
		heros.add(new FXHero("G光辉"));
		heros.add(new FXHero("X雪人"));
		heros.add(new FXHero("M蛮王"));
		System.out.println(heros.values());
//		Node<String> nodeStr = new Node<>();
//		for(int i=0; i<10; i++) {
//			nodeStr.add("hero"+i);
//		}
//		System.out.println(nodeStr.values());
	}

	/**
	 * 获取10以内随机数
	 * @return
	 */
	public static int random() {
		int number = new Random().nextInt(10) + 1;
		System.out.println(number);
		return number;
	}

	public static void test() {
		System.out.println((int) (Math.random() * 10));
	}
}
