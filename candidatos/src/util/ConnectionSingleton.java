package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSingleton {
	
	private static volatile Connection conn = null;
	
	public static Connection getConnection(){
		
		try {
			
			if(conn == null){
				conn = openConnection();
			}
			

		} catch (Exception e) {
			e.printStackTrace(); 
		}

		return conn;
	}
	
	private static Connection openConnection(){
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Andre#12");
		} catch (Exception e) {
			e.printStackTrace(); 
		}

		return conn;
	}
	
	
	public static void main(String[] args) {
		Connection con = ConnectionSingleton.getConnection();
		
		if(con != null){
			System.out.println("aberta");
		}
		
	}
	

}
