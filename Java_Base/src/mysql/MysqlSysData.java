package mysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MysqlSysData {
	public static Logger logger = Logger.getLogger(MysqlSysData.class);
	
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
				) {
			// 查看数据库层面的元数据
            // 即数据库服务器版本，驱动版本，都有哪些数据库等等
  
            DatabaseMetaData dbmd = conn.getMetaData();
  
            // 获取数据库服务器产品名称
            System.out.println("数据库产品名称:\t"+dbmd.getDatabaseProductName());
            // 获取数据库服务器产品版本号
            System.out.println("数据库产品版本:\t"+dbmd.getDatabaseProductVersion());
            // 获取数据库服务器用作类别和表名之间的分隔符 如test.user
            System.out.println("数据库和表分隔符:\t"+dbmd.getCatalogSeparator());
            // 获取驱动版本
            System.out.println("驱动版本:\t"+dbmd.getDriverVersion());
  
            System.out.println("可用的数据库列表：");
            // 获取数据库名称
            ResultSet rs = dbmd.getCatalogs();
  
            while (rs.next()) {
                System.out.println("数据库名称:\t"+rs.getString(1));
            }
		}catch(SQLException e) {
			logger.error("连接mysql数据库失败",e);
		}
	}
}
