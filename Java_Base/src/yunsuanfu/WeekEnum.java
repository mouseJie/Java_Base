package yunsuanfu;


public enum WeekEnum {
	SUNDAY,MONDAY,TUESDAY,WENDSDAY,THURSDAY,FRIDAY,STATUDAY,ERROR;

	private static final WeekEnum[] Enum = WeekEnum.values();

	/**
	 * 通过int找到对应的value
	 */
	public static WeekEnum of(int id) {
		if(id<0||id>7) {
			return ERROR;
		}
		return Enum[id-1];
	}
	
	/**
	 * 通过value找到对应的Int
	 */
	public static int from(WeekEnum w) {
		return w.ordinal();
	}
	
//	public static void main(String[] args) {
//		System.out.println(WeekEnum.of(1));
//		System.out.println(WeekEnum.ERROR.ordinal());
//		System.out.println(WeekEnum.from(WeekEnum.SUNDAY));
//	}
}
