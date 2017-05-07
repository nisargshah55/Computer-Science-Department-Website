package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.topicDAO;

/**
 * Servlet implementation class viewforumstaff
 */
@WebServlet("/viewforumstaff")
public class viewforumstaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewforumstaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
HttpSession session = request.getSession();
		
		String a1=(String) session.getAttribute("topic");
		String a2=request.getParameter("view");
		String a8=request.getParameter("pid");
		
		
		//Validation if the content is empty
		String c=a2.replaceAll("^\\s+", "");
		if(c.isEmpty() )
		{
			topicDAO ad= new topicDAO();
			
			ArrayList<String> a3 = ad.checkcontent1(a1);
			
			StringBuilder builder = new StringBuilder();
			for (String value : a3) {
			    builder.append(value);
			}
			String a4 = builder.toString();
			 request.setAttribute("error_specialcharacter", "Enter proper content");
			session.setAttribute("viewallpost", a4);
			getServletContext().getRequestDispatcher("/forumstaff.jsp").forward(request, response);
		}
			 
	     else
	     {
		//Submit a new post for the hashtag
		topicDAO ad=new topicDAO();
		ad.hashtagfeed(a1,a2,a8);
		{
		ArrayList<String> a3 = ad.checkcontent1(a1);
		
		StringBuilder builder = new StringBuilder();
		for (String value : a3) {
		    builder.append(value);
		}
		String a4 = builder.toString();
		request.setAttribute("viewallpost", a4);
		ad.checkcontent1(a1);
		String a5=request.getParameter("reply");
		request.setAttribute("replypost", a5);
		getServletContext().getRequestDispatcher("/forumstaff.jsp").forward(request, response);
		
		}
		
		
			
		
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
