package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.resourceDAO;

/**
 * Servlet implementation class reserveresource
 */
@WebServlet("/reserveresourcestaff")
public class reserveresourcestaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reserveresourcestaff() {
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
		System.out.println(netid);
		
		String select=request.getParameter("select");
		resourceDAO rd=new resourceDAO();
		List<String> l=rd.selectres();
		System.out.println("List is-----"+l);
		request.setAttribute("resourcelist", l);
		
		String resource=request.getParameter("resource");
		String date=request.getParameter("date");
		String schedule=request.getParameter("schedule");
		
		if(rd.checkreservation(resource, date, schedule))
		{
			request.setAttribute("error_name", "Reservation already exists.Please try another time");
			
			getServletContext().getRequestDispatcher("/reserveresourcestaff.jsp").forward(request, response);
			System.out.println("errrrrrorrrrr");
		}
		else 
		{
		rd.reserve(resource, date, schedule,netid);
		System.out.println("Date is----"+date);
		response.sendRedirect("viewresourcestaff.jsp");
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
