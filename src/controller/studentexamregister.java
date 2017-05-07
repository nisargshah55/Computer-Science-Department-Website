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
import DAO.stuexamregDAO;

/**
 * Servlet implementation class studentexamregister
 */
@WebServlet("/studentexamregister")
public class studentexamregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentexamregister() {
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
		System.out.println("Exam register:------"+a);
		dbconn d=new dbconn();
		String name=null;
		try {
			name = d.firstname(a);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String regexam=request.getParameter("regexam");
		stuexamregDAO st=new stuexamregDAO();
		
		if(st.checkexam(regexam,a))
		{
			request.setAttribute("error", "You have already registered for this exam");
			getServletContext().getRequestDispatcher("/studentexamregister.jsp").forward(request, response);
		}
		else
		{
		st.examreg(regexam,name,a);
		request.setAttribute("msg", "You have successfully registered for this exam");
		getServletContext().getRequestDispatcher("/studentexamregister.jsp").forward(request, response);
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
