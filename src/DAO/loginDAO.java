package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginDAO {
	
public int login(String netid,String password,String role,String firstname,String lastname) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		String sql = "insert into login(id,netid,password,role,firstname,lastname) values(NULL,'"+netid+"','"+password+"','"+role+"','"+firstname+"','"+lastname+"')";
		
		
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
	
	
	
	
	public int loginstudent(String netid,String password,String role,String firstname,String lastname,String year,String program,String major) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		String sql = "insert into login(id,netid,password,role,firstname,lastname,year,program,major) values(NULL,'"+netid+"','"+password+"','"+role+"','"+firstname+"','"+lastname+"','"+year+"','"+program+"','"+major+"')";
		
		
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
	
	
	
public boolean searchreg(String netid) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} 
		catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		String sql2 = "select * from login where netid='" + netid + "'";
		Connection conn=null;
	try
	{
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
		
		
	     PreparedStatement statement = conn.prepareStatement(sql2);

		 ResultSet result= statement.executeQuery(sql2); 
		 String search=null;
		 while(result.next())
		 {
			 search=result.getString("netid");
		 }
		 if (netid.equals(search))
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

public boolean searchlogin(String netid,String password,String role) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} 
	catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql2 = "select * from login where netid='" + netid + "'";
	Connection conn=null;
try
{
	
	conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
	
	
     PreparedStatement statement = conn.prepareStatement(sql2);

	 ResultSet result= statement.executeQuery(sql2); 
	 String search=null;
	 String searchp=null;
	 String searchrole=null;
	 while(result.next())
	 {
		 search=result.getString("netid");
		 searchp=result.getString("password");
		 searchrole=result.getString("role");
		 
	 }
	 
	 if (netid.equals(search) && password.equals(searchp) && role.equals(searchrole))
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



public boolean searchrole(String netid) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} 
	catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql2 = "select role from login where netid='" + netid + "'";
	Connection conn=null;
try
{
	
	conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
	
	Statement s = conn.createStatement();

	ResultSet temp = s.executeQuery(sql2);
   
	 
	 
	 if (temp!=null)
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




