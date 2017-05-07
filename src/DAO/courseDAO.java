package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;



public class courseDAO {
	
	public int course(String courseno,String coursename) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		String sql = "insert into course(id,no,name) values(NULL,'"+courseno+"','"+coursename+"')";
		
		
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
public boolean coursereg(String courseno) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} 
		catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		String sql2 = "select * from course where no='" + courseno + "'";
		Connection conn=null;
	try
	{
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
		
		
	     PreparedStatement statement = conn.prepareStatement(sql2);

		 ResultSet result= statement.executeQuery(sql2); 
		 String search=null;
		 while(result.next())
		 {
			 search=result.getString("no");
		 }
		 if (courseno.equals(search))
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
	

/*public ArrayList<String> viewcourse(String courseno) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} 
	catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	try
	{
		
	 ArrayList<String> list = new ArrayList<String>();
	String sql3 = "select * from course";
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");;

	PreparedStatement statement = conn.prepareStatement(sql3);
	
	 ResultSet result= statement.executeQuery(sql3);
	String c=null;
	 while(result.next())
	 {
		
		c=result.getString("courseno");
		list.add(c);
		System.out.println(c);
		list.add(result.getString("coursename"));
		 }
	 

	 return (list);
	
	
	} 
	catch (SQLException e)

	{
		e.printStackTrace();
	}
	return null;
	
}
*/
public boolean delete(String deleteid)
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql = "delete from course where id='"+deleteid+"'";
	
	
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
public boolean select(String selectid,String cno,String cname,String search)
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	
	
	String sql = "UPDATE `course` SET `faculty` = '" + search+ "' WHERE id = '" + selectid+ "'  ";
	
	
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

public boolean checkfac(String cno,String cname,String search)
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	
	
	String sql = "select faculty from course where no='"+cno+"'";
	
	
	
	Connection conn=null;
	
	

	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
		Statement s = conn.createStatement();

		ResultSet rs=s.executeQuery(sql);
		
		String fac=null;
		while(rs.next())
		{
			
			fac=rs.getString("faculty");
		}
		if(fac==null)
			return true;
		else
			return false;
	}
	
	catch (Exception e) {
		e.printStackTrace();
	}
	return false;
	
	}


}


