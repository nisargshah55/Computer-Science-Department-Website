package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.courseDAO;

/**
 * Servlet implementation class viewcourse
 */
@WebServlet("/viewcourse")
public class viewcourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewcourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("---------------");
		String deleteid=request.getParameter("deleteid");
		
		HttpSession session=request.getSession();
		String courseno = null;
		courseDAO c=new courseDAO();
		
		/*ArrayList<String> a3= c.viewcourse(courseno);
		System.out.println("Arraylist"+a3);
		StringBuilder builder = new StringBuilder();
		for (String value : a3) {
		    builder.append(value);
		}
		String a4 = builder.toString();
		
		session.setAttribute("viewcourse", a4);
		
		*/
		
		c.delete(deleteid);
		getServletContext().getRequestDispatcher("/facultycourse.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
