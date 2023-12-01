package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserDto;
import service.UserService;

@WebServlet("/delete-task")
public class DeleteTask extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	UserDto dto=(UserDto) req.getSession().getAttribute("user");
	if(dto==null) {
		resp.getWriter().print("<h1 align='center' style='color:red'>Session Expired,Login Again</h1>");
		req.getRequestDispatcher("index.html").include(req, resp);
	}else {
		int id=Integer.parseInt(req.getParameter("id"));
		UserService service=new UserService();
		service.deleteTask(id ,dto);
		UserDao dao=new UserDao();
		UserDto dto2=dao.findById(dto.getId());
		req.getSession().setAttribute("user", dto2);
		resp.getWriter().print("<h1 align='center' style='color:red'>Task Deleted Success</h1>");
		
		req.setAttribute("list", dto2.getTasks());
		req.getRequestDispatcher("Home.jsp").include(req, resp);
	}
}
}
