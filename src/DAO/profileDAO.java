package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class profileDAO {

	public ArrayList<String> profile(String netid) throws SQLException
	{
		ArrayList<String> l=new ArrayList<String>();
		dbconn db=new dbconn();
		String profile="select * from login where netid='"+netid+"'";
		ResultSet rs=db.execute(profile);
		String fn=null;
		String ln=null;
		while(rs.next())
		{
			fn=rs.getString("firstname");
			ln=rs.getString("lastname");
			l.add(fn);
			l.add(ln);
		}
		return l;
	}
	
	
	public int editprofile(String fn,String ln,String netid)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		try
		{
			
			String sql3="UPDATE `login` SET `firstname` = '" + fn+ "', `lastname` = '" + ln+ "' WHERE id = '" + netid+ "'  ";
		/*String sql3 = "UPDATE login SET 'firstname' = '"+fn+"', 'lastname' = '"+ln+"' WHERE id = '"+netid+"'";*/
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");;
	
		Statement s = conn.createStatement();
		int temp=s.executeUpdate(sql3);
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
}
