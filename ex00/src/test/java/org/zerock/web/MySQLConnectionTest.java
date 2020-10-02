package org.zerock.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private static final String URL = "jdbc:mysql://192.168.56.141:3306/zerock_spring_20150816";
	
	private static final String USER = "zerock";
	
	private static final String PW = "1234";
	
	@Test
	public void testConnection() throws Exception {
		
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)){
			
			System.out.println(con);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
