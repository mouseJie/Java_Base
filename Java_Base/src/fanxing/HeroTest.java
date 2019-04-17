package fanxing;

import java.util.ArrayList;
import java.util.List;

import common.ADHero;
import common.Hero;

public class HeroTest<T extends Hero> {
	
	private String type;
	
	public static void main(String[] args) {
		HeroTest<ADHero> s = new HeroTest<>();
		
		//错误
//		get(new ArrayList<String>());
		get(new ArrayList<Hero>());
		get(new ArrayList<ADHero>());
	}
	
	public static void get(List<? extends Hero> list) {
		
	}
}
