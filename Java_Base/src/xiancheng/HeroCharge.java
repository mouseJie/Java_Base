package xiancheng;

public class HeroCharge {
	public static void main(String[] args) {
		AHero hero = new AHero();
		Thread thread = new Thread() {
			@Override
			public void run() {
//				int j = 1;
//				mouse:
				while (true){
                    for (int i = 1;i<=3;i++){
                        try {
                            hero.attack(i);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        hero.charged();
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    j++;
//                    if(j>3) {
//                    	break mouse;
//                    }
                    
                }
			}
		};
		
		thread.start();
	}
}

class AHero{
	public void attack(int i) {
		System.out.println("波动拳第"+i+"发");
	}
	
	public void charged() {
		System.out.println("开始为时5秒的充能");
	}
}