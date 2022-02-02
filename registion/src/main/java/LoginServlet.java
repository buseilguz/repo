

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.LoginBean;
import login.LoginDao;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
	
   public void init() {
	   loginDao=new LoginDao();
	   }
   
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		LoginBean loginBean=new LoginBean();
		loginBean.setEmail(email);
		loginBean.setPassword(password);
		try {
			if(loginDao.validate(loginBean)) {
				response.sendRedirect("loginsuccess.jsp");
			}
			else {
				HttpSession session=request.getSession();
				response.sendRedirect("login.jsp");
			}
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
