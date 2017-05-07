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
 * Servlet implementation class createexam
 */
@WebServlet("/createexam")
public class createexam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createexam() {
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
		String examname=request.getParameter("examname");
		String date=request.getParameter("date");
		String netid=(String)s.getAttribute("netid");
		examDAO c=new examDAO();
		if(c.examreg(examname))
		{
			
			request.setAttribute("error_name", "Exam already posted");
				
			getServletContext().getRequestDispatcher("/createexam.jsp").forward(request, response);
			System.out.println("errrrrrorrrrr");
		}
		else
		{
		c.exam(examname, date,netid);
		response.sendRedirect("viewexam.jsp");
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