package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {
	
	static final String JDBC_DRIVER="";
	static final String DB_URL="jdbc:mysql://localhost:3306/baitap";
	
	static final String USER_NAME="root";
	static final String PASS="123456";
	
	public static Connection getConnection() {
		Connection connection = null;		
		try {
			connection = DriverManager.getConnection(DB_URL,USER_NAME,PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
