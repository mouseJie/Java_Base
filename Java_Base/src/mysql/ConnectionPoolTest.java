package mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class ConnectionPoolTest {

	public static void main(String[] args) {
		ConnectionPool pool = new ConnectionPool(5);
		for (int i = 0; i < 100; i++) {
			WorkingThread wt = new WorkingThread("线程" + i, pool);
		}
	}
}

class WorkingThread extends Thread {
	private Logger logger = Logger.getLogger(WorkingThread.class);
	private ConnectionPool cp;

	public WorkingThread(String name, ConnectionPool cp) {
		super(name);
		this.cp = cp;
	}

	public void run() {
		Connection c = cp.getConnection();
		logger.info(this.getName() + "获取到连接，并开始工作");
		try (Statement s = c.createStatement()) {
			// 模拟时耗1秒的数据库操作
			Thread.sleep(1000);
			s.execute("");
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
		cp.returnConnection(c);
	}
}
