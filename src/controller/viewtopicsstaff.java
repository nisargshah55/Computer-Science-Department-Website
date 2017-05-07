package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

import DAO.topicDAO;

/**
 * Servlet implementation class viewtopicsstaff
 */
@WebServlet("/viewtopicsstaff")
public class viewtopicsstaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewtopicsstaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
String id=request.getParameter("selectid");
		
		System.out.println("id is---"+id);
		topicDAO td=new topicDAO();
		
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
		String sql2 = "select * from distopic where id='" + id + "'";
		ResultSet r=s.executeQuery(sql2);
		
		String id1=null;
	
		while(r.next())
		{
		id1=r.getString(2);
		}
		HttpSession session = request.getSession();
		
		session.setAttribute("topic",id1 );
		
		ArrayList<String> a3 = td.checkcontent1(id1);
		
		StringBuilder builder = new StringBuilder();
		for (String value : a3) {
		    builder.append(value);
		}
		String a4 = builder.toString();
		
		
		session.setAttribute("viewallpost", a4);
		session.setAttribute("topic", id1);
		response.sendRedirect("forumstaff.jsp");
		
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
