package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class alumniDAO {
public boolean post(String name,String year,String member,String link) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		String sql = "insert into alumni(name,year,member,link) values('"+name+"','"+year+"','"+member+"','"+link+"')";
		
		
		Connection conn=null;
		
		

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
			Statement s = conn.createStatement();

			 s.executeUpdate(sql);
			
			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	
		}

public boolean delete(String deleteid) {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql = "delete from alumni where id='"+deleteid+"'";
	
	
	Connection conn=null;
	
	

	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
		Statement s = conn.createStatement();

		s.executeUpdate(sql);
		
		
		

	}
	
	catch (Exception e) {
		e.printStackTrace();
	}
	return false;

	}
}
