package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.resourceDAO;

/**
 * Servlet implementation class createresource
 */
@WebServlet("/createresource")
public class createresource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createresource() {
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
		String select=request.getParameter("select");
		resourceDAO rd1=new resourceDAO();
		List<String> l=rd1.selectres();
		System.out.println("List is-----"+l);
		s.setAttribute("resourcelist", l);
		
		
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		String info=request.getParameter("info");
				
		resourceDAO rd=new resourceDAO();
		rd.createres(name, type, info);
		response.sendRedirect("reserveresource.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
