package list.erchashu;

import java.util.ArrayList;
import java.util.List;

public class Node {
	public Node leftNode;
	public Node rightNode;
	public Object value;
	
	public static void main(String[] args) {
		int[] a = {67,7,30,73,10,0,78,81,10,74};
		Node node = new Node();
		for(int i : a) {
			node.add(i);
		}
		System.out.println(node.values());
	}
	
	/**
	 * 插入值
	 * @param obj
	 */
	public void add(Object obj) {
		// 如果当前节点没有值，就把数据放在当前节点上
		if(null==value) {
			value = obj;
		// 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
		}else {
			// 新增的值，比当前值小或者相同
			if((int)value>=(int)obj) {
				if(null==leftNode)
				leftNode = new Node();
				leftNode.add(obj);
			// 新增的值，比当前值大
			}else {
				if(null==rightNode)
				rightNode = new Node();
				rightNode.add(obj);
			}
		} 
	}
	
	/**
	 * 中序遍历
	 */
	public List<Object> values(){
		List<Object> values = new ArrayList<>();
		// 左节点的遍历结果
		if(null!=leftNode)
			values.addAll(leftNode.values());
		// 当前节点
		values.add(value);
		// 右节点的遍历结果
		if(null!=rightNode)
			values.addAll(rightNode.values());
		return values;
	}
}
