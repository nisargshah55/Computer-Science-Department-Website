package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.dbconn;
import DAO.profileDAO;
import model.profile;

/**
 * Servlet implementation class editprofile
 */
@WebServlet("/editprofile")
public class editprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editprofile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession s=request.getSession();
		String netid=(String)s.getAttribute("netid");
		System.out.println("editprofile.java"+netid);
		String fn=request.getParameter("fn");
		System.out.println("First name++++++++++"+fn);
		String ln=request.getParameter("ln");
		System.out.println("Last name++++++++++"+ln);
		String year=request.getParameter("year");
		String major=request.getParameter("major");
		String advisorinfo=request.getParameter("advisorinfo");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String status=request.getParameter("status");
		
		
		
		dbconn db=new dbconn();
		String role="select role from login where netid='"+netid+"'";
		String role1=null;
		ResultSet rs=db.execute(role);
		try {
			while(rs.next())
			{
				role1=rs.getString("role");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*profile pr=new profile();
		pr.setFirstname(fn);
		pr.setLastname(ln);*/
		
		
		profileDAO p=new profileDAO();
		try
		{
		
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
              
	            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root","");
	             Statement st=con.createStatement();
	             if(role1.equals("Faculty") || role1.equals("Staff"))
	             {
	             String sql3="UPDATE `login` SET `firstname` = '" + fn+ "', `lastname` = '" + ln+ "' WHERE netid = '" + netid+ "'  ";
	             st.executeUpdate(sql3);
	          
	          response.sendRedirect("viewfacultyprofile.jsp");
		}
		
		/*Statement s = conn.createStatement();
		
		*/
		
		
		
		else
		{
			
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
             
	            
	             String sql3="UPDATE `login` SET `status` = '" + status+ "',`firstname` = '" + fn+ "',`lastname` = '" + ln+ "',`year` = '" + year+ "', `password` = '" + password+ "', `advisorinfo` = '" + advisorinfo+ "', `phone` = '" + phone+ "', `email` = '" + email+ "' WHERE netid = '" + netid+ "'  ";
	             st.executeUpdate(sql3);
	          System.out.println("EXECUTED");
	          System.out.println("EXECUTED"+fn);
	          
	          response.sendRedirect("viewstudentprofile.jsp");
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
