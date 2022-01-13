package BankHibernate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import BankHibernateDBManager.Manager;
import BankHibernateEntity.UserPojoEntity;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserPojoEntity user = new UserPojoEntity();
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		Manager manager = new Manager();
		if(manager.loginUser(user)) {
			System.out.println((UserPojoEntity)user);
			//if the loginUser method return true then redirect the user to Welcome.jsp;
			System.out.println("LOGIN "+user.getId());
			System.out.println("LOGIN "+user.getFirstName());
			ServletContext context = super.getServletContext();
			HttpSession session = request.getSession();
			session.setAttribute("userData", user);
			RequestDispatcher dispatcher = context.getRequestDispatcher("/Welcome.jsp");
			dispatcher.forward(request, response);
		} //end of if condition
		else { //if the loginUser method return false then redirect the user to Error.jsp;
			ServletContext context = super.getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(request, response);
		} //end of else part
	} //end of doPost Method;
} //end of LoginServlet Class
