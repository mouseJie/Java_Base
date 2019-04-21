package xiancheng;

import java.util.LinkedList;

public class CrackPwd {
	public static void main(String[] args) {
		PWDAction p = new PWDAction();
		try {
			p.random(8);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class PWDAction{
	private LinkedList<String> pwdList = new LinkedList<>();
	
	public void findPWD() {
		String pwd = "";
		pwdList.add(pwd);
	}
	
	public void printPWD() {
		if(pwdList.size()==0)
			printPWD();
		System.out.println(pwdList.poll());
	}
	
	/**
	 * 生成值为字符范围为0~9，a~z, A~Z的随机数
	 * @param size(生成位数)
	 * @return
	 * @throws Exception
	 */
	public String random(int size) throws Exception {
		String pool = "";
		for(int i='0'; i<='9'; i++) {
			pool += (char)i;
		}
		for(int i='a'; i<='z'; i++) {
			pool += (char)i;
		}
		for(int i='A'; i<='Z'; i++) {
			pool += (char)i;
		}
		
		char[] ch = new char[size];
		
		for(int i=0; i<size; i++) {
			ch[i] = pool.charAt((int)(Math.random()*pool.length()));
		}
		
		System.out.println(String.valueOf(ch));
		return pool;
	}
}

