package yichang;

public class Account {
	public double balance;

	public Account(double init) {
		this.balance = init;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amt) {
		balance+=amt;
		System.out.printf("本次存款%f元，现账户余额为%f元", amt, balance);
		System.out.println("\n");
	}

	public void withdraw(double amt) throws OverdraftException {
		balance-=amt;
		System.out.printf("本次取款%f元，现账户余额为%f元", amt, balance);
		System.out.println("\n");
		if(balance<0) throw new OverdraftException("您账户已超支,目前账户余额为："+balance, balance);
	}
}
