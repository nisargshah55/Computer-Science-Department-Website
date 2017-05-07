package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class topicDAO {
public int topic(String topic) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		String sql = "insert into distopic(id,topic) values(NULL,'"+topic+"')";
		
		
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

	
public ArrayList<String> checkcontent(String name) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} 
	catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	try
	{
		
	 ArrayList<String> list = new ArrayList<String>();
	String sql3 = "select * from disforum where topic='" + name + "' ORDER BY Time DESC";
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");;

	PreparedStatement statement = conn.prepareStatement(sql3);
	String sql4 = "select * from disforum where topic='" + name + "' ORDER BY Time DESC";
	 ResultSet result1= statement.executeQuery(sql3);
	 ArrayList<String> fv = new ArrayList<String>();
	 
	 while (result1.next())

		{
			StringBuilder val = new StringBuilder();
			for (int i = 1; i <= result1.getMetaData().getColumnCount(); i++) {

				val.append(result1.getString(i) + ",");

			}
			fv.add(val.toString());
		}
	 
	 
	 ResultSet result = statement.executeQuery(sql4);
	
	 while(result.next())
	 {
		 System.out.println("cskdsk----   "+result.getString("content"));
		 if(result.getInt(3)==0) {
		list.add("<h1>"+result.getString("content")+"</h1>");
		
		list.add("<a href='deleteques?id="+result.getString("id")+"'><button>Delete</button></a><br>");
		System.out.println(result.getString("content"));		
		list.add("<br>");	
		list.add("<form action='viewforum' method='post'>");
		
		list.add("<input type='text' name='view'>");
		
		list.add("<input type='hidden' value="+result.getInt(1)+" name='pid'>");
		
		list.add("<input type='submit' value='Reply'>");
		list.add("</form><br>");
		for(int f=0;f<fv.size();f++){
			String t[] = null;
			t = fv.get(f).split(",");
				if(result.getInt(1)==(Integer.parseInt(t[2]))) {
					list.add(t[4]+"<a href='DeleteServlet?id="+t[0]+"&?content="+t[3]+"'><button>Delete</button></a><br>");
				}
			}
		
		list.add("<br>");
		 }
	 }

	 return (list);
	
	
	
	}
	catch (SQLException e)

	{
		e.printStackTrace();
	}
	return null;
}

public ArrayList<String> checkcontent1(String name) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} 
	catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	try
	{
		
	 ArrayList<String> list = new ArrayList<String>();
	String sql3 = "select * from disforum where topic='" + name + "' ORDER BY Time DESC";
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");;

	PreparedStatement statement = conn.prepareStatement(sql3);
	String sql4 = "select * from disforum where topic='" + name + "' ORDER BY Time DESC";
	 ResultSet result1= statement.executeQuery(sql3);
	 ArrayList<String> fv = new ArrayList<String>();
	 
	 while (result1.next())

		{
			StringBuilder val = new StringBuilder();
			for (int i = 1; i <= result1.getMetaData().getColumnCount(); i++) {

				val.append(result1.getString(i) + ",");

			}
			fv.add(val.toString());
		}
	 
	 
	 ResultSet result = statement.executeQuery(sql4);
	
	 while(result.next())
	 {
		 System.out.println("cskdsk----   "+result.getString("content"));
		 if(result.getInt(3)==0) {
		list.add("<h1>"+result.getString("content")+"</h1>");
		list.add("<a href='deletequesstaff?id="+result.getString("id")+"'><button>Delete</button></a><br>");
		System.out.println(result.getString("content"));		
		list.add("<br>");	
		list.add("<form action='viewforumstaff' method='post'>");
		list.add("<input type='text' name='view'>");
		list.add("<input type='hidden' value="+result.getInt(1)+" name='pid'>");
		list.add("<input type='submit' value='Reply'>");
		list.add("</form><br>");
		for(int f=0;f<fv.size();f++){
			String t[] = null;
			t = fv.get(f).split(",");
				if(result.getInt(1)==(Integer.parseInt(t[2]))) {
					list.add(t[4]+"<a href='DeleteServletStaff?id="+t[0]+"&?content="+t[3]+"'><button>Delete</button></a><br>");
				}
			}
		
		list.add("<br>");
		 }
	 }

	 return (list);
	
	
	} 
	catch (SQLException e)

	{
		e.printStackTrace();
	}
	return null;
}


public ArrayList<String> checkcontent2(String name) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} 
	catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	try
	{
		
	 ArrayList<String> list = new ArrayList<String>();
	String sql3 = "select * from disforum where topic='" + name + "' ORDER BY Time DESC";
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");;

	PreparedStatement statement = conn.prepareStatement(sql3);
	String sql4 = "select * from disforum where topic='" + name + "' ORDER BY Time DESC";
	 ResultSet result1= statement.executeQuery(sql3);
	 ArrayList<String> fv = new ArrayList<String>();
	 
	 while (result1.next())

		{
			StringBuilder val = new StringBuilder();
			for (int i = 1; i <= result1.getMetaData().getColumnCount(); i++) {

				val.append(result1.getString(i) + ",");

			}
			fv.add(val.toString());
		}
	 
	 
	 ResultSet result = statement.executeQuery(sql4);
	
	 while(result.next())
	 {
		 System.out.println("cskdsk----   "+result.getString("content"));
		 if(result.getInt(3)==0) {
		list.add("<h1>"+result.getString("content")+"</h1>");
		/*list.add("<a href='deletequesstaff?id="+result.getString("id")+"'><button>Delete</button></a><br>");*/
		System.out.println(result.getString("content"));		
		list.add("<br>");	
		list.add("<form action='viewforumstudent' method='post'>");
		list.add("<input type='text' name='view'>");
		list.add("<input type='hidden' value="+result.getInt(1)+" name='pid'>");
		list.add("<input type='submit' value='Reply'>");
		list.add("</form><br>");
		for(int f=0;f<fv.size();f++){
			String t[] = null;
			t = fv.get(f).split(",");
				if(result.getInt(1)==(Integer.parseInt(t[2]))) {
					list.add(t[4]+"<br>");
				}
			}
		
		list.add("<br>");
		 }
	 }

	 return (list);
	
	
	} 
	catch (SQLException e)

	{
		e.printStackTrace();
	}
	return null;
}




public void hashtagfeed(String name,String content, String a3) {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	int prid=Integer.parseInt(a3);
	String sql1 = "insert into disforum(id,time,parentfeedid,topic,content) values(NULL,CURRENT_TIMESTAMP,"+prid+",'"+name+"','"+content+"')";
	Connection conn=null;
	

	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
		Statement s = conn.createStatement();

		 s.executeUpdate(sql1);
		
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	
	
	}
public boolean delete(String deleteid)
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql = "delete from distopic where id='"+deleteid+"'";
	
	
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


public boolean topicreg(String topic) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} 
	catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql2 = "select * from distopic where topic='" + topic + "'";
	Connection conn=null;
try
{
	
	conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
	
	
     PreparedStatement statement = conn.prepareStatement(sql2);

	 ResultSet result= statement.executeQuery(sql2); 
	 String search=null;
	 
	 while(result.next())
	 {
		 search=result.getString("topic");
		
	 }
	 if (topic.equals(search) )
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


public boolean deleteques(int id)
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql = "delete from disforum where id='"+id+"'";
	
	
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
