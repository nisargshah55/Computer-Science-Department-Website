package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

import DAO.loginDAO;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		String netid=request.getParameter("netid");
		String password=request.getParameter("password");
		session.setAttribute("netid", netid);
		loginDAO ld=new loginDAO();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} 
		catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		Connection conn=null;
		Statement s=null;
	try
	{
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
		s=(Statement) conn.createStatement();
		String sql2 = "select * from login where netid='" + netid + "'";
		
		ResultSet r=s.executeQuery(sql2);
		String role=null;
		String id=null;
		String pwd=null;
		while(r.next())
		{
		id=r.getString(2);
		pwd=r.getString(3);
		role=r.getString(4);
		System.out.println("role is--"+role);
		}
		if(!(netid.equals(id) && password.equals(pwd)))
		{
			request.setAttribute("error_name", "Please enter correct login details");
			
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else if(role.equals("Faculty"))
		{
			response.sendRedirect("facultyhome.jsp");
			System.out.println("looggggiiiinnnffffffffff");
		}
		else if(role.equals("Staff"))
		{
			response.sendRedirect("staffhome.jsp");
			System.out.println("looggggiiiinnnssssss");
		}
		else
		/*else if(role.equals("Student"))*/
		{
			response.sendRedirect("studenthome.jsp");
			System.out.println("looggggiiiinnnstttttttt");
		}
		/*else
		{
			
		}*/
	}
		catch (Exception e)

		{
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
