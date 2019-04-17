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
}
