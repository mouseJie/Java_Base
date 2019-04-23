package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool implements AutoCloseable{
	
	List<Connection> list = new ArrayList<>();
	
	String url = "jdbc:mysql://127.0.0.1:3306/java2study?characterEncoding=UTF-8";
	String user = "root";
	String password = "root123";
	
	int size;
	
	public ConnectionPool(int size) {
		this.size = size;
		init();
	}
	
	public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			for(int i=0; i<size; i++) {
				Connection c = DriverManager.getConnection(url, user, password);
				list.add(c);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 拿去用，要锁定住这个connection自己慢慢用
	 * @return
	 */
	public synchronized Connection getConnection() {
		while(list.isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Connection c = list.remove(0);
		return c;
	}
	
	/**
	 * 用完拿回来，还要告诉其他人说可以来用了
	 * @param c
	 */
	public synchronized void returnConnection(Connection c) {
		list.add(c);
		this.notifyAll();
	}

	@Override
	public void close() throws Exception {
		
	}
}
