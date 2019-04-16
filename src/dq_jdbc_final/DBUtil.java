package dq_jdbc_final;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String url="jdbc:mysql://127.0.0.1:3306/phonebook?useUnicode=true&amp;characterEncoding=utf-8";
	private static final String user="root";
	private static final String password="root";
	private static Connection conn=null;
	static {
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	public static Connection getConnection() {
		return conn;
	}
	
}
