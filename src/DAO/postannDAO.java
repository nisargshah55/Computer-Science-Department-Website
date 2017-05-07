package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class postannDAO {

	public boolean postjob(String type,String title,String description,String fn,String on,String email) throws SQLException
	{
Connection conn=null;
		
		

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
			Statement s = conn.createStatement();

		String sql="insert into postannouncement(id,type,title,description,faculty,onoff,emailink) values(NULL,'"+type+"','"+title+"','"+description+"','"+fn+"','"+on+"','"+email+"')";
		s.executeUpdate(sql);
		
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
}
	
	
	public boolean postann(String type,String title,String description,String fn) throws SQLException
	{
Connection conn=null;
		
		

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
			Statement s = conn.createStatement();

		String sql="insert into postannouncement(id,type,title,description,faculty,onoff,emailink) values(NULL,'"+type+"','"+title+"','"+description+"','"+fn+"',NULL,NULL)";
		s.executeUpdate(sql);
		
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
}
}
