package yichang;

public class TestMain {
	public static void main(String[] args) {
		Account myAccount = new Account(200);
		myAccount.deposit(200);
		try {
			myAccount.withdraw(500);
		} catch (OverdraftException e) {
			e.printStackTrace();
		}
	}
}
