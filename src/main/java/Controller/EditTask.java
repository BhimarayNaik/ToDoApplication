package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.Task;
import dto.UserDto;

@WebServlet("/edit")
public class EditTask extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	UserDto dto = (UserDto) req.getSession().getAttribute("user");
	if (dto == null) {
		resp.getWriter().print("<h1 align='center' style='color:red'>Session Expired,Login Again</h1>");
		req.getRequestDispatcher("index.html").include(req, resp);
	} else {
		int id=Integer.parseInt(req.getParameter("id"));
		UserDao dao=new UserDao();
		Task task=dao.findTaskById(id);
		req.setAttribute("task", task);
		req.getRequestDispatcher("EditTask.jsp").forward(req, resp);
	}
}
}
