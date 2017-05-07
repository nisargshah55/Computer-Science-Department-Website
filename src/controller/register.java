package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.loginDAO;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
	
		String netid=request.getParameter("netid");
		String password=request.getParameter("password");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String year=request.getParameter("year");
		String program=request.getParameter("program");
		String major=request.getParameter("major");
		
		/*String faculty=request.getParameter("faculty");
		String staff=request.getParameter("staff");
		String student=request.getParameter("student");*/
		String role=request.getParameter("role");
		s.setAttribute("firstname", firstname);
		loginDAO logindao=new loginDAO();
		
		
		System.out.println("role is"+role);
		if(logindao.searchreg(netid))  {
			
			request.setAttribute("error_name", "Login Details already exist.Please enter other login details");
				
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			System.out.println("errrrrrorrrrr");
		}
		else {
			if(("Faculty").equals(role))
			{
			logindao.login(netid, password,role,firstname,lastname);
			response.sendRedirect("login.jsp");
			}
			else if(("Staff").equals(role))
				{logindao.login(netid, password,role,firstname,lastname);
			response.sendRedirect("login.jsp");
				}
			else
			{
				logindao.loginstudent(netid, password,role,firstname,lastname,year,program,major);
			response.sendRedirect("login.jsp");
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
