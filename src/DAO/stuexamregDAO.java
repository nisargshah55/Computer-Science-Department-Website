package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class stuexamregDAO {

	
public boolean examreg(String regexam,String name,String studentid) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} 
		catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		String sql2 = "insert into examreg(exam,student,studentid) values('"+regexam+"','"+name+"','"+studentid+"')";
		Connection conn=null;
	try
	{
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
		
		
	     PreparedStatement statement = conn.prepareStatement(sql2);

	     statement.executeUpdate(sql2); 
		 
	
		} 
		catch (Exception e)

		{
			e.printStackTrace();
		}
		return true;
	}
	

public boolean checkexam(String regexam,String studentid) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} 
	catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql2 = "select * from examreg";
	Connection conn=null;
try
{
	
	conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
	
	
     PreparedStatement statement = conn.prepareStatement(sql2);

     ResultSet rs=statement.executeQuery(sql2);
     String exam=null;
     String sid=null;
     while(rs.next())
     {
    	 exam=rs.getString("exam");
    	 sid=rs.getString("studentid");
    	 
     }
     
	 if(regexam.equals(exam) && studentid.equals(sid))
		 return true;
	 else return false;

	} 
	catch (Exception e)

	{
		e.printStackTrace();
	}
	return true;
}


}
