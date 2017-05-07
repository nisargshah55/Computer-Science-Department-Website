package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class infoDAO {
public boolean course(String addid,String ta,String foh,String toh,String info) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		String sql = "UPDATE course SET `info`='"+info+"',`ta`='"+ta+"',`foh`='"+foh+"',`toh`='"+toh+"' where id='"+addid+"'";
		
		
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
