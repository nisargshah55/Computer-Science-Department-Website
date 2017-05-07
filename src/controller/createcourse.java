package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.courseDAO;
import DAO.examDAO;

/**
 * Servlet implementation class createcourse
 */
@WebServlet("/createcourse")
public class createcourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createcourse() {
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
		String courseno=request.getParameter("courseno");
		String coursename=request.getParameter("coursename");
		String netid=(String)s.getAttribute("netid");
		courseDAO c=new courseDAO();
		if(c.coursereg(courseno))
		{
			
			request.setAttribute("error_name", "Course already exist");
				
			getServletContext().getRequestDispatcher("/createcourse.jsp").forward(request, response);
			System.out.println("errrrrrorrrrr");
		}
		else{
		c.course(courseno, coursename);
		response.sendRedirect("viewallcourse.jsp");
				
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
