package lamdba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import common.Hero;

public class LastTest {
	public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("遍历集合中的每个数据");
        heros
            .stream()
            .forEach(h->System.out.print(h));
        System.out.println("返回一个数组");
        Object[] hs= heros
            .stream()
            .toArray();
        System.out.println(Arrays.toString(hs));
        System.out.println("返回伤害最低的那个英雄");
        Hero minDamageHero =
        heros
            .stream()
            .min((h1,h2)->h1.damage-h2.damage)
            .get();
        System.out.print(minDamageHero);
        System.out.println("返回伤害最高的那个英雄");
 
        Hero mxnDamageHero =
                heros
                .stream()
                .max((h1,h2)->h1.damage-h2.damage)
                .get();
        System.out.print(mxnDamageHero);     
         
        System.out.println("流中数据的总数");
        long count = heros
                .stream()
                .count();
        System.out.println(count);
 
        System.out.println("第一个英雄");
        Hero firstHero =
                heros
                .stream()
                .findFirst()
                .get();
         
        System.out.println(firstHero);
         
    }
}
