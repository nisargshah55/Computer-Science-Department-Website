package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class resourceDAO {
public boolean createres(String name,String type,String info) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		String sql = "insert into resource(name,type,info) values('"+name+"','"+type+"','"+info+"')";
		
		
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



public ArrayList<String> selectres() {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql = "select name from resource";
	
	
	Connection conn=null;
	
	

	try {
		ArrayList<String> list = new ArrayList<String>();
		conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
		Statement s = conn.createStatement();

		ResultSet rs=s.executeQuery(sql);
	
		while(rs.next())
		{
		list.add(rs.getString("name"));	
		}
		
		return(list);

	}
	
	catch (Exception e) {
		e.printStackTrace();
	}
	return null;

	}

public boolean reserve(String resource,String date,String schedule,String netid) {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql = "insert into reserveresource(id,name,date,time,netid) values(NULL,'"+resource+"','"+date+"','"+schedule+"','"+netid+"')";
	
	
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


public boolean checkreservation(String resource,String date,String schedule) {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql = "select * from reserveresource";
	
	
	Connection conn=null;
	
	

	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
		Statement s = conn.createStatement();

		ResultSet r=s.executeQuery(sql);
		String namedb=null;
		String datedb=null;
		String timedb=null;
		String netiddb=null;
		while(r.next())
		{
			namedb=r.getString("name");
			datedb=r.getString("date");
			timedb=r.getString("time");
			
		}
		if(resource.equals(namedb) && date.equals(datedb) && schedule.equals(timedb))
			return true;
			else
				return false;
		

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
	String sql = "delete from reserveresource where id='"+deleteid+"'";
	
	
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
