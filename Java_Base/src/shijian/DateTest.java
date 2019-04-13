package shijian;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateTest {
	public static void main(String[] args) {
		// Date date = new Date();
		// Date zero = new Date(0);
		// System.out.println(date.getTime());
		// System.out.println(zero);
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		// System.out.println(sdf.format(date));
		//
		Calendar cal = Calendar.getInstance();
		// System.out.println(cal.getTime());
		// System.out.println(cal.getTimeInMillis());
		// System.out.println(sdf.format(cal.getTimeInMillis()));

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		cal.add(Calendar.YEAR, 1);
		System.out.println(sdf1.format(cal.getTime()));
		// 随机输出日期
		Random r = new Random();
		int month = r.nextInt(12);
		int date = r.nextInt(30);
		int hourOfDay = r.nextInt(12);
		int minute = r.nextInt(60);
		int second = r.nextInt(60);
		cal.set(2019, month, date, hourOfDay, minute, second);
		System.out.println(sdf1.format(cal.getTime()));
		// int i=0;
		// while(true) {
		// if(i>10)
		// break;
		// System.out.println(r.nextInt());
		// i++;
		// }

		/**
		 * string转date
		 */
		String s = sdf1.format(cal.getTime());
		try {
			System.out.println(sdf1.parse(s).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
