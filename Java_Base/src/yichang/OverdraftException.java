package yichang;

public class OverdraftException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9146920295807341766L;

	private double deficit;

	public OverdraftException() {

	}

	public OverdraftException(String message, double deficit) {
		this.deficit = deficit;
		System.out.println(message);
	}

	public double getDeficit() {
		return deficit;
	}
}
