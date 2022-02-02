

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.LoginBean;
import login.LoginDao;
import verification.VerificationBean;
import verification.VerificationDao;

/**
 * Servlet implementation class VerificationServlet
 */
@WebServlet("/verification")
public class VerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private VerificationDao verificationDao;
	
	   public void init() {
		   verificationDao=new VerificationDao();
		   }
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		
		VerificationBean verificationBean=new VerificationBean();
		verificationBean.setEmail(email);
		
		try {
			if(verificationDao.validate(verificationBean)) {
				response.sendRedirect("verifysuccess.jsp");
			}
			else {
				HttpSession session=request.getSession();
				response.sendRedirect("verification.jsp");
			}
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
