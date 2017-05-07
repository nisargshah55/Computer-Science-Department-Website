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

/**
 * Servlet implementation class checkphdstaff
 */
@WebServlet("/checkphdstaff")
public class checkphdstaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkphdstaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try
		{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root","");
         Statement st=con.createStatement();
		String sql="select * from login where role='Student'";
		ResultSet rs= st.executeQuery(sql);
		String program=null;
				while(rs.next())
				{
					program=rs.getString("program");
				}
			
			System.out.println("Program is ==="+program);
			if(!program.equals("Phd"))
			{
				request.setAttribute("error", "There are no Phd students currently registered with the system");
				getServletContext().getRequestDispatcher("/staffprofilesidebar.jsp").forward(request, response);
				
			}
			else
			{
				response.sendRedirect("viewphdstudentstaff.jsp");
			}
			} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
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
