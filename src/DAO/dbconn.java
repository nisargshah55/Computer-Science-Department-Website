package DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class dbconn {
	
	    private static String url = "jdbc:mysql://localhost:3306/termproject";    
	    private static String driverName = "com.mysql.jdbc.Driver";   
	    private static String username = "root";   
	    private static String password = "";
	    private static Connection con;
	    

	    public static Connection getConnection() {
	        try {
	            Class.forName(driverName);
	            try {
	                con = (Connection) DriverManager.getConnection(url, username, password);
	            } catch (SQLException ex) {
	                // log an exception. fro example:
	                System.out.println("Failed to create the database connection."); 
	            }
	        } catch (ClassNotFoundException ex) {
	            // log an exception. for example:
	            System.out.println("Driver not found."); 
	        }
	        return con;
	    }
	    
	    public  ResultSet execute(String a)
	    {
	        ResultSet rs=null;
	       
	        {
	        	try
	             {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	                 
	            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root","");
	             Statement st=con.createStatement();
	             rs=st.executeQuery(a);
	             
	             }
	             catch(Exception ex)
	             {
	              
	             }
	           return rs;
	     }
	    }
	    
	    public String firstname(String netid) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	    {
	    	
           Class.forName("com.mysql.jdbc.Driver").newInstance();
                
           Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root","");
            Statement st=con.createStatement();
            String firstname="select firstname from login where netid='"+netid+"'";
            ResultSet rs=st.executeQuery(firstname);
            String fn=null;
            while(rs.next())
            {
            	 fn=rs.getString("firstname");
            }
            return fn;
	    }
	    
	}


