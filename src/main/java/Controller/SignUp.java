package Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDto;
import service.UserService;

@WebServlet("/signup")
public class SignUp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocalDate dateofbirth=LocalDate.parse(req.getParameter("dob"));
		UserDto dto=new UserDto();
		dto.setAge(LocalDate.now().getYear()-dateofbirth.getYear());
		dto.setDob(dateofbirth);
		dto.setEmail(req.getParameter("email"));
		dto.setGender(req.getParameter("gender"));
		dto.setMnumber(Long.parseLong(req.getParameter("mNumber")));
		dto.setName(req.getParameter("name"));
		dto.setPassword(req.getParameter("pass"));
		
		UserService service=new UserService();
		if(service.saveUser(dto)) {
			resp.getWriter().print("<h1 style='color:darkgoldenrod' align='center'>Account Created Success</h1>");
			req.getRequestDispatcher("index.html").include(req, resp);
		}else {
			resp.getWriter().print("<h1 style='color:red' align='center'>Sorry!! Account cannot be Created</h1>");
			req.getRequestDispatcher("SignUp.html").include(req, resp);
		}
	}
}
