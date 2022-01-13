package BankHibernate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BankHibernateDBManager.Manager;
import BankHibernateEntity.UserPojoEntity;
@WebServlet("/ShowBalanceServlet")
public class ShowBalanceServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();	
	UserPojoEntity userSession = (UserPojoEntity)session.getAttribute("userData");
	System.out.println(userSession.getFirstName());

	}
}
