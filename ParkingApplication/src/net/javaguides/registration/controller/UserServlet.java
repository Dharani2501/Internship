package net.javaguides.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ConnectionPro;
import net.javaguides.registration.dao.UserDao;
import net.javaguides.registration.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/register")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      // private boolean UserDao userDao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher =request.getRequestDispatcher("userregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		User user = new User(firstName,lastName,username,password,address,contact);
		UserDao regUser=new UserDao(ConnectionPro.getConnection());
		
//		user.setFirstName(firstName);
//		user.setLastName(lastName);
//		user.setUsername(username);
//		user.setPassword(password);
//		user.setAddress(address);
//		user.setContact(contact);
		try
		{
		if(regUser.registerEmployee(user))
		{
			response.sendRedirect("index.jsp");
		}
		else
		{
			String errorMessage="User Available";
			HttpSession regSession=request.getSession();
			regSession.setAttribute("RegError", errorMessage);
			response.sendRedirect("userregister.jsp");
		}
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
//		RequestDispatcher dispatcher=request.getRequestDispatcher("userdetails.jsp");
//		dispatcher.forward(request, response);
	}

}
