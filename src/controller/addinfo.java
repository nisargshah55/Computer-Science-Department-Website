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
import DAO.infoDAO;

/**
 * Servlet implementation class addinfo
 */
@WebServlet("/addinfo")
public class addinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addinfo() {
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
		String foh=request.getParameter("foh");
		String ta=request.getParameter("ta");
		String toh=request.getParameter("toh");
		String netid=(String)s.getAttribute("netid");
		String addid=(String)s.getAttribute("addid");
		System.out.println("id is ====="+addid);
		dbconn db=new dbconn();
		String fn=null;
		try {
			fn=db.firstname(netid);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String info=request.getParameter("info");
		infoDAO id=new infoDAO();
		id.course(addid,ta,foh,toh,info);
		response.sendRedirect("addinfo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
