package xiancheng;

import common.Hero;

public class AttackThread implements Runnable {

	public Hero daren;
	public Hero beida;
	public int damage;
	
	public AttackThread(Hero daren, Hero beida) {
		this.daren = daren;
		this.beida = beida;
		this.damage = daren.damage;
	}
	
	@Override
	public void run() {
		while(!beida.isDead()&&!daren.isDead()) {
			daren.attackHero(beida);
		}
	}

}
