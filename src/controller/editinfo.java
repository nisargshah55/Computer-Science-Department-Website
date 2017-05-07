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
 * Servlet implementation class editinfo
 */
@WebServlet("/editinfo")
public class editinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editinfo() {
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
		String editid=(String) s.getAttribute("editid");
		/*String editid=(String)s.getAttribute("editid");*/
		System.out.println("editprofile.java"+editid);
		String info=request.getParameter("info");
		System.out.println("Information++++++++++"+info);
		String fn=(String)s.getAttribute("firstname");
		String cno=(String)s.getAttribute("cno");
		String ta=request.getParameter("ta");
		String foh=request.getParameter("foh");
		String toh=request.getParameter("toh");
		
		
		
		try
		{
		
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
              
	            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root","");
	             Statement st=con.createStatement();
	             String sql3="UPDATE `course` SET  `ta` = '" + ta+ "',`foh` = '" + foh+ "',`toh` = '" + toh+ "',`info` = '" + info+ "' WHERE id = '" + editid+ "'  ";
	             st.executeUpdate(sql3);
	          System.out.println("Edited");
	          
	          
	          response.sendRedirect("viewinfo.jsp");
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
