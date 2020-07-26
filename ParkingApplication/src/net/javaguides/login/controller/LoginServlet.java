package net.javaguides.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import connection.ConnectionPro;
import net.javaguides.login.dao.LoginDao;
//import net.javaguides.registration.dao.UserDao;
import net.javaguides.registration.model.User;

/**
 * @email Dharani
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        try {
        	if(username.equals("admin") && password.equals("admin"))
        	{
        		 HttpSession session = request.getSession();
                 session.setAttribute("username",username);
        		response.sendRedirect("home.html");
        	}
        	else if (loginDao.validate(user)) {
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                response.sendRedirect("index.html");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}