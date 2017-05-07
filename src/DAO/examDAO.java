package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class examDAO {
public int exam(String exam,String date,String netid) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		String sql = "insert into exam(id,exam,date,user) values(NULL,'"+exam+"','"+date+"','"+netid+"')";
		
		
		Connection conn=null;
		
		

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
			Statement s = conn.createStatement();

			int temp = s.executeUpdate(sql);
			
			
			if (temp != 0) 
				return 1;
			else
				return 0;

		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		}


public boolean delete(String deleteid) {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql = "delete from exam where id='"+deleteid+"'";
	
	
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


public boolean examreg(String examname) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} 
	catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql2 = "select * from exam where exam='" + examname + "'";
	Connection conn=null;
try
{
	
	conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
	
	
     PreparedStatement statement = conn.prepareStatement(sql2);

	 ResultSet result= statement.executeQuery(sql2); 
	 String search=null;
	 while(result.next())
	 {
		 search=result.getString("exam");
	 }
	 if (examname.equals(search))
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
