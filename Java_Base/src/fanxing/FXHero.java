package fanxing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FXHero implements Serializable, Comparable<FXHero> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String name;

	public FXHero(String name) {
		this.name = name;
	}

	/**
	 * 大于0表示前一个数据比后一个数据大， 0表示相等，小于0表示第一个数据小于第二个数据
	 */
	@Override
	public int compareTo(FXHero o) {
		return name.charAt(0)-o.name.charAt(0);
	}

	@Override
	public String toString() {
		return "英雄"+name;
	}
	
	public static void main(String[] args) {
		//我FXHero里面可以还包含APhero等其他hero的
//		ADHero a = new FXHero("");
		FXHero b = new ADHero("");
		
		List<? extends FXHero> list = new ArrayList<>();
		List<FXHero> fxHeros = new ArrayList<>();
		fxHeros.add(new FXHero("老鼠"));
		List<ADHero> adHeros = new ArrayList<>();
		adHeros.add(new ADHero("g盖伦"));
		adHeros.add(new ADHero("p皮城女警"));
		adHeros.add(new ADHero("l老鼠"));
		adHeros.add(new ADHero("h寒冰"));
		List<APHero> apHeros = new ArrayList<>();
		apHeros.add(new APHero("莫甘娜"));
		apHeros.add(new APHero("光辉"));
		
		print(fxHeros);
		print(adHeros);
		print(apHeros);

		Collections.sort(adHeros);
		print(adHeros);
	}

	public static void print(List<? extends FXHero> list) {
		if (null != list) {
			System.out.println("该list值为：");
//			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i));
//			}
//			list.stream().forEach(h->System.out.println(h));
			//如果存在中间操作
			list.stream().filter(h->h.name.equals("h寒冰")).forEach(h->System.out.println(h));
		}
	}
}

class ADHero extends FXHero {

	public ADHero(String name) {
		super(name);
	}

}

class APHero extends FXHero{
	
	public APHero(String name) {
		super(name);
	}
}
