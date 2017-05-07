package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class editalumnistaff
 */
@WebServlet("/editalumnistaff")
public class editalumnistaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editalumnistaff() {
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
		String editid=(String)s.getAttribute("editid");
		System.out.println("editprofile.java"+editid);
		String name=request.getParameter("name");
		//System.out.println("First name++++++++++"+type);
		String year=request.getParameter("year");
		//System.out.println("Last name++++++++++"+title);
		String member=request.getParameter("member");
		//System.out.println("Last name++++++++++"+desc);
		String link=request.getParameter("link");
		//System.out.println("Last name++++++++++"+desc);
		
		
		try
		{
		
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
              
	            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root","");
	             Statement st=con.createStatement();
	             String sql3="UPDATE `alumni` SET `name` = '" + name+ "', `year` = '" + year+ "',`member` = '" + member+ "',`link` = '"+ link+ "' WHERE id = '" + editid+ "'  ";
	             st.executeUpdate(sql3);
	          System.out.println("done");
	          
	          
	          response.sendRedirect("viewalumnistaff.jsp");
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
