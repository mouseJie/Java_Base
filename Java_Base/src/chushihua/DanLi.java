package chushihua;

public class DanLi {
	private DanLi() {
		System.out.println("get it");
	}

	private static DanLi danli = new DanLi();

	public static DanLi getInstance() {
		return danli;
	}
}
