package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.courseDAO;
import DAO.dbconn;

/**
 * Servlet implementation class addfac
 */
@WebServlet("/addfac")
public class addfac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addfac() {
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
	String cno=(String) s.getAttribute("no");
	String cname=(String) s.getAttribute("name");
	String selectid=request.getParameter("selectid");
	System.out.println("Select ID is-----"+selectid);
	String netid=(String)s.getAttribute("netid");
	System.out.println("Netid is"+netid);
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
	} 
	catch (ClassNotFoundException  e) {
		e.printStackTrace();
	}
	String sql2 = "select firstname from login where netid='" + netid + "'";
	Connection conn=null;
try
{
	
	conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "");
	
	
     PreparedStatement statement = conn.prepareStatement(sql2);

	 ResultSet result= statement.executeQuery(sql2); 
	 String search=null;
	 while(result.next())
	 {
		 search=result.getString("firstname");
	 }

	System.out.println("First Name is====="+search);
	
	/*dbconn db=new dbconn();
	String a="select "
	db.execute(a)*/
	 
	 
	courseDAO c=new courseDAO();
	/*if(!c.checkfac(cno, cname, search))
	{
		request.setAttribute("checkfac", "Faculty is already added!");
		getServletContext().getRequestDispatcher("/viewallcourse.jsp").forward(request, response);
	}
	else*/
	{
	c.select(selectid,cno,cname,search);
	getServletContext().getRequestDispatcher("/viewallcourse.jsp").forward(request, response);
	}
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
