package wenjian;

import java.io.Serializable;

public class Hero implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4569933682055449237L;
	private String name;
	private String isdie;
	private int sign;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsdie() {
		return isdie;
	}

	public void setIsdie(String isdie) {
		this.isdie = isdie;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}
	
//	public void test() {
//		System.out.println("调用成功");
//	}
	
	public void test(String name) {
		System.out.println("调用"+name+"成功");
	}
}
