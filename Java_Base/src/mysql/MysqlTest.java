package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MysqlTest {
	public static Logger logger = Logger.getLogger(MysqlTest.class);

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
	
		String psSQL = "select count(*) as count from teststudy";
		try (Connection conn = DriverManager.getConnection(url, user, password);
				Statement s = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement(psSQL);
				) {
			/**
			 * 使用PreparedStatement
			 */
			ps.execute();
			ResultSet pscount = ps.executeQuery();
			int totalps = 0;
			while(pscount.next()) {
				totalps = pscount.getInt("count");
			}
			logger.info("使用PreparedStatement所查表中数据条数为："+totalps);
			
			/**
			 * 查询条数
			 */
			String countSQL = "select count(*) as count from teststudy";
			ResultSet countrs = s.executeQuery(countSQL);
			int total = 0;
			while(countrs.next()) {
				total = countrs.getInt("count");
			}
			logger.info("所查表中数据条数为："+total);
			
			/**
			 * 查询数据
			 */
			String querySQL = "select * from teststudy";
			ResultSet rs = s.executeQuery(querySQL);
			logger.info("所查表中数据为：");
			while(rs.next()) {
				logger.info(String.format("%d %s %s %tF%n", rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4)));
			}
			/**
			 * 分页查询
			 */
			int m = 0;
			int n = 1;
			String queryPage = String.format("select * from teststudy limit %d,%d", m,n);
			ResultSet pagers = s.executeQuery(queryPage);
			logger.info(String.format("分页查询后结果（m:%d,n:%d）为",m,n));
			while(pagers.next()) {
				logger.info(String.format("%d %s %s %tF%n", pagers.getInt(1),pagers.getString(2),pagers.getString(3),pagers.getDate(4)));
			}
			
			/**
			 * 插入数据
			 */
//			String title = "舞蹈课程";
//			String author = "罗志祥";
//			String date = "2019-04-13";
//			String insertSQL = "insert into teststudy(test_title, test_author, test_date) values('网球教程','越前龙马','2016-05-06')";
//			s.execute(insertSQL);
//			String insertSQL1 = String.format("insert into teststudy(test_title, test_author, test_date) values('%s','%s','%s')", title,author,date);
//			s.execute(insertSQL1);
//			logger.info("成功插入一条数据");
		} catch (SQLException e) {
			logger.error("连接mysql数据库失败", e);
		}
	}
}
