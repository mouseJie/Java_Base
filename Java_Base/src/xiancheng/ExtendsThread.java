package xiancheng;

public class ExtendsThread extends Thread{
	@Override
    public void run() {
		System.out.println("俺是继承Thread的一个进程对象");
	}
}
