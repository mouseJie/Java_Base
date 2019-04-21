package common;

import java.io.Serializable;

//import java.io.Serializable;

public class Hero implements Serializable, Comparable<Hero> {

	public static final long serialVersionUID = 1L;
	public int sign = 0;
	public int damage = 0;
	public String name;
	public float hp;

	public Hero(String name) {
		this.name = name;
	}

	public Hero(String name, int sign) {
		this.name = name;
		this.sign = sign;
	}

	public Hero(String name, int sign, int damage) {
		this.name = name;
		this.sign = sign;
		this.damage = damage;
	}
	
	public Hero(String name, int sign, int damage, float hp) {
		this.name = name;
		this.sign = sign;
		this.damage = damage;
		this.hp = hp;
	}

	@Override
	public String toString() {
		return name + "——" + sign + "——" + damage;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

	public int getSign() {
		return sign;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	@Override
	public int compareTo(Hero o) {
		if (damage < o.damage)
			return 1;
		else
			return -1;
	}
	
	public void attackHero(Hero h) {
        try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        if(h.isDead()) {
        	System.out.println(name +"打死了！"+h.name);
        }else {
        	h.hp-=damage;
            System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
        }
    }
 
    public boolean isDead() {
        return 0>=hp?true:false;
    }
}
