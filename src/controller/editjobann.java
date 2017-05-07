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
 * Servlet implementation class editjobann
 */
@WebServlet("/editjobann")
public class editjobann extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editjobann() {
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
		String type=request.getParameter("type");
		System.out.println("First name++++++++++"+type);
		String title=request.getParameter("title");
		System.out.println("Last name++++++++++"+title);
		String desc=request.getParameter("desc");
		System.out.println("Last name++++++++++"+desc);
		String on=request.getParameter("on");
		String email=request.getParameter("email");
		
		
		try
		{
		
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
              
	            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root","");
	             Statement st=con.createStatement();
	             String sql3="UPDATE `postannouncement` SET `type` = '" + type+ "', `title` = '" + title+ "',`onoff` = '" + on+ "',`emailink` = '" + email+ "',`description` = '" + desc+ "' WHERE id = '" + editid+ "'  ";
	             st.executeUpdate(sql3);
	          System.out.println("EXECUTED");
	          
	          
	          response.sendRedirect("viewjobannouncement.jsp");
		}
		/*Statement s = conn.createStatement();
		
		*/
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
