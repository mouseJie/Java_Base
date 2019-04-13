package xunhuan;

public class BaiWangFuWeng {
	public static void main(String[] args) {
		//第一年本金
		double benqian = 12000;
//		//第一年复利为：
//		double fuli = benqian*Math.pow(1+0.2, 1);
//		System.out.println(fuli);
//		
//		//第二年复利为：
//		double fuliTwo = fuli*Math.pow(1+0.2, 2);
		
		//还要记住一个点 ： 每年都会再扔12000
		
		//第一年
		double sumMoney = benqian * 1.2;
		
		int i =2;
		
		while(true) {
			sumMoney = (sumMoney+12000) * 1.2;
			i++;
			if(sumMoney>1000000) {
				System.out.println("已用"+(i-1)+"年实现账户为100万元");
				break;
			}
		}
		
		/**********************************/
			// 采用秦九韶算法
			int year;
			double sum=12000*1.2;
			for(year=2;sum<1000000;year++)
			{
				sum=(sum+12000)*1.2;
			}
			System.out.println("持续投资"+(year-1)+"年，收入达到100万。");
	}
}
