package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.dbconn;
import DAO.resultDAO;

/**
 * Servlet implementation class postresultstaff
 */
@WebServlet("/postresultstaff")
public class postresultstaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postresultstaff() {
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
		String a=(String)s.getAttribute("netid");
		System.out.println("Faculty is===="+a);
		dbconn db=new dbconn();
		String fn=null;
		try {
			fn = db.firstname(a);
			System.out.println("First name is===="+fn);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String regexam=request.getParameter("regexam");
		String studentid=request.getParameter("studentid");
		String result=request.getParameter("result");
		
		resultDAO rd=new resultDAO();
		if(rd.resultreg(regexam,studentid))
		{
			
			request.setAttribute("error_name", "Result already posted");
				
			getServletContext().getRequestDispatcher("/postresultstaff.jsp").forward(request, response);
			System.out.println("errrrrrorrrrr");
		}
		else
		rd.result(regexam, studentid, result,fn);
		response.sendRedirect("viewresultstaff.jsp");
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
