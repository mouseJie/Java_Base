package list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.Hero;

public class HashMapTest {
	public static void main(String[] args) {
		
		List<Hero> heros = new ArrayList<>();
		System.out.println("初始化List");
		for(int i=0; i<300000; i++) {
			heros.add(new Hero("hero-"+random()));
		}
		System.out.println("初始化HashMap");
		HashMap<String, List<Hero>> map = new HashMap<>();
		
		for(Hero hero : heros) {
			List<Hero> list = map.get(hero.getName());
			if(null==list) {
				list = new ArrayList<>();
				map.put(hero.getName(), list);
			}
			list.add(hero);
		}
		
		System.out.println("初始化结束，开始进行查找");
		
		System.out.println("在HashMap中查找");
		findByMap(map, "hero-3890");
		
	}
	
	private static List<Hero> findByMap(HashMap<String, List<Hero>> map, String key){
		long beginDate = System.currentTimeMillis();
		List<Hero> list = map.get(key);
		System.out.println("查询到个数为："+list.size());
		System.out.println("查询时间为："+(System.currentTimeMillis()-beginDate));
		return list;
	}
	
	public static int random(){
        return ((int)(Math.random()*9000)+1000);
    }
}
