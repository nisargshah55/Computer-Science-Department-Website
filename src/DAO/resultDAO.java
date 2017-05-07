package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class resultDAO {

public boolean result(String regexam,String studentid,String result,String fn) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		String sql = "insert into result(id,regexam,studentid,result,user) values(NULL,'"+regexam+"','"+studentid+"','"+result+"','"+fn+"')";
		
		
		Connection conn=null;
		
		

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
			Statement s = conn.createStatement();

			 s.executeUpdate(sql);
			
			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
		}



public boolean delete(String deleteid) {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql = "delete from result where id='"+deleteid+"'";
	
	
	Connection conn=null;
	
	

	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
		Statement s = conn.createStatement();

		s.executeUpdate(sql);
		
		
		

	}
	
	catch (Exception e) {
		e.printStackTrace();
	}

	

return true;
}
	

public boolean resultreg(String regexam,String sid) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} 
	catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql2 = "select * from result where regexam='" + regexam + "'";
	Connection conn=null;
try
{
	
	conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
	
	
     PreparedStatement statement = conn.prepareStatement(sql2);

	 ResultSet result= statement.executeQuery(sql2); 
	 String search=null;
	 String search1=null;
	 while(result.next())
	 {
		 search=result.getString("regexam");
		 search1=result.getString("studentid");
	 }
	 if (regexam.equals(search) && sid.equals(search1))
			return true;
		else
			return false;

	} 
	catch (Exception e)

	{
		e.printStackTrace();
	}
	return true;
}


}
