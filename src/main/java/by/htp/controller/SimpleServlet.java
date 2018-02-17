package by.htp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.User;
import by.htp.dao.BaseDaoImpl;


public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BaseDaoImpl db = new BaseDaoImpl();
    private User us = null;
    private String pageUser = "/user.jsp";
	private String pageAdmin = "/admin.jsp";
	private String pageError = "/error.jsp";
    public SimpleServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		
		
		String param= request.getParameter("action");
		
		
		if(param.equals("action")) {
			us = db.searchUser(request.getParameter("login"), request.getParameter("password"));
			//request.setAttribute("user_name", "Alex");
			if(us !=null && us.getRole().equals("user")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher(pageUser);
				dispatcher.forward(request, response);
				System.out.println("Test sucsesful");
			}
			
			
		}else if(us !=null && us.getRole().equals("admin")){
			System.out.println("admin");
			RequestDispatcher dispatcher = request.getRequestDispatcher(pageAdmin);
			dispatcher.forward(request, response);
			System.out.println("Test sucsesful");
		}
		
		else {
			System.out.println("error");
			RequestDispatcher dispatcher = request.getRequestDispatcher(pageError);
			dispatcher.forward(request, response);
			System.out.println("Test sucsesful");
			
			
			
			
		}
	}

}
