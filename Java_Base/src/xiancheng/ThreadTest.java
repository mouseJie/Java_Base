package xiancheng;

import common.Hero;

public class ThreadTest {
	public static void main(String[] args) {
		Hero gilun = new Hero("盖伦",1,100,1000);
		Hero timo = new Hero("提莫",1,100,1000);
		Hero vn = new Hero("VN",1,100,1000);
		
		AttackThread a = new AttackThread(gilun, vn);
		AttackThread b = new AttackThread(timo, vn);
		AttackThread c = new AttackThread(vn, timo);
		new Thread(a).start();
		new Thread(b).start();
		new Thread(c).start();
	}
}
