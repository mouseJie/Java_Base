package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ShiwuTest {
	public static Logger logger = Logger.getLogger(ShiwuTest.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("D:\\git\\Java_Base\\Java_Base\\src\\log4j.properties");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) { 
			logger.error("加载驱动失败", e);
		}
		logger.info("加载驱动成功");
		String url = "jdbc:mysql://127.0.0.1:3306/java2study?characterEncoding=UTF-8";
		String user = "root";
		String password = "root123";
	
		try (Connection conn = DriverManager.getConnection(url, user, password);
				Statement s = conn.createStatement();
				Scanner sc = new Scanner(System.in);
				) {
			conn.setAutoCommit(false);
			int id = 8;
			String deleteSQL ="DELETE FROM teststudy WHERE test_id="+id;
			s.execute(deleteSQL);
			System.out.println("是否删除一条数据"+id+"？Y删除，N不删");
			while(sc.nextLine().equals("Y")) {
				conn.commit();
				break;
			}
		} catch (SQLException e) {
			logger.error("连接mysql数据库失败", e);
		}
	}
}
