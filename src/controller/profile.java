package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.dbconn;
import DAO.profileDAO;

/**
 * Servlet implementation class profile
 */
@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile() {
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
		dbconn d=new dbconn();
		String sql="select role from login where netid='"+netid+"'";
		ResultSet rs=d.execute(sql);
		String role=null;
		try {
			while(rs.next())
			{
				role=rs.getString("role");
				System.out.println("Role is---"+role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(role.equals("Faculty"))
		{
			profileDAO p=new profileDAO();
			try {
				ArrayList<String> l= p.profile(netid);
				request.setAttribute("profile", l);
				System.out.println("List size is----"+l.size());
				response.sendRedirect("facultyprofile.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(role.equals("Staff"))
		{
			response.sendRedirect("staffprofile.jsp");
		}
		else
		{
			response.sendRedirect("studentprofile.jsp");
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
