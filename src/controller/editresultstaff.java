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
 * Servlet implementation class editresultstaff
 */
@WebServlet("/editresultstaff")
public class editresultstaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editresultstaff() {
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
		
		String exam=request.getParameter("regexam");
		System.out.println("Exam is===="+exam);
		
		String sid=request.getParameter("sid");
		System.out.println("Student id is===="+sid);
		
		String result=request.getParameter("result");
		System.out.println("result is ====="+result);
		
		
		
		try
		{
		
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
              
	            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root","");
	             Statement st=con.createStatement();
	             String sql3="UPDATE `result` SET  `regexam` = '" + exam+ "',`studentid` = '" + sid+ "',`result` = '" + result+ "' WHERE id = '" + editid+ "'  ";
	             st.executeUpdate(sql3);
	          System.out.println("Edit Success");
	          
	          
	          response.sendRedirect("viewmyresultstaff.jsp");
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
