package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@JDBCConfig(ip = "127.0.0.1", database = "java2study", encoding = "UTF-8", loginName = "root", password = "root123")
public class DBUtil {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@JDBCConfig(ip = "127.0.0.1", database = "java2study", encoding = "UTF-8", loginName = "root", password = "root123")
	public void test() {
		
	}

	public static Connection getConnection() throws SQLException, NoSuchMethodException, SecurityException {
//		JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);
		JDBCConfig config = DBUtil.class.getMethod("test").getAnnotation(JDBCConfig.class);
		String ip = config.ip();
		int port = config.port();
		String database = config.database();
		String encoding = config.encoding();
		String user = config.loginName();
		String password = config.password();
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
		System.out.println("连接地址为:" + url);
		Connection c = DriverManager.getConnection(url, user, password);
		return c;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(DBUtil.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
