package com.nuri.utill;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnector {
	
	// method "getConnect"
	// Exception Throwed
	
	public static Connection getConnect() throws Exception {
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}

}
