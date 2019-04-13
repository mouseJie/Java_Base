package fengzhuang;

public class StringTest {
	public static void main(String[] args) {
		/**
		 * 格式化字符串
		 */
		// System.out.println(String.valueOf(2).equals("2"));
		// System.out.println(Integer.parseInt("2")==2);
		//
		// String name = "小明";
		// int mikeSum = 2;
		// String mikeName = "旺仔牛奶";
		// System.out.printf("%s的妈妈给他带来了%d瓶%s", name, mikeSum, mikeName);
		// System.out.println();
		// System.out.format("%s的妈妈给他带来了%d瓶%s", name, mikeSum, mikeName);
	
		/**
		 * 1. 生成一个长度是3的随机字符串，把这个字符串作为当做密码
		 * 2. 使用穷举法生成长度是3个字符串，匹配上述生成的密码
		 * 要求： 分别使用多层for循环 和 递归解决上述问题
		 */
		/**
		 * 多层for循环方法
		 */
		String pwd = randomString(3);
		System.out.println("生成密码为"+pwd);
		char[] guessPwd = new char[3];
		outloop: //这个标注是为了实现能直接跳出多层循环
			for(short i='1'; i<= 'z'; i++){
				for(short j='1'; j<='z'; j++) {
					for(short k='1'; k<='z'; k++) {
						if(!isLetterOrDigit(i, j, k)) continue;
						guessPwd[0] = (char)i;
						guessPwd[1] = (char)j;
						guessPwd[2] = (char)k;
						String finalPwd = new String(guessPwd);
						if(finalPwd.equals(pwd)) {
							System.out.println("解出密码为："+finalPwd);
							break outloop;
						}
					}
				}
			}
		
		
		/**
		 * 穷举法（递归方式）
		 */
		char[] guessPassword = new char[pwd.length()];
        generatePassword(guessPassword,pwd);
	}
	/**
	 * 去除数字到字母之间其他ASCII值的影响，只有检测到为数字和字母才可以继续接下来的赋值
	 * @param i
	 * @param j
	 * @param k
	 * @return
	 */
	private static boolean isLetterOrDigit(short i, short j, short k) {
		return Character.isLetterOrDigit(i) && Character.isLetterOrDigit(j) && Character.isLetterOrDigit(k);
	}

	private static String randomString(int length) {
		String pool = "";
		for (short i = '0'; i <= '9'; i++) {
			pool += (char) i;
		}
		for (short i = 'a'; i <= 'z'; i++) {
			pool += (char) i;
		}
		for (short i = 'A'; i <= 'Z'; i++) {
			pool += (char) i;
		}
		char cs[] = new char[length];
		for (int i = 0; i < cs.length; i++) {
			int index = (int) (Math.random() * pool.length());
			// String-->char String里面根据位置拿个对应的char
			cs[i] = pool.charAt(index);
		}
		// char[]-->String
		String result = new String(cs);
		return result;
	}
	
	public static void generatePassword(char[] guessPassword,String password){
        generatePassword(guessPassword,0,password);
    }
     
	public static boolean found = false;
	
    public static void generatePassword(char[] guessPassword,int index,String password){
        if(found)
            return;
        for (short i = '0'; i <= 'z'; i++) {
            char c = (char)i;
            if(!Character.isLetterOrDigit(c))
                continue;
            guessPassword[index] = c;
            if(index!=guessPassword.length-1){
                generatePassword(guessPassword,index+1,password);
            }
            else{
                String guess = new String(guessPassword);
//              System.out.println("穷举出来的密码是：" + guess);
                if(guess.equals(password)){
                    System.out.println("找到了，密码是" + guess);
                    found =true;
                    return;
                }
            }
        }
    }
}
