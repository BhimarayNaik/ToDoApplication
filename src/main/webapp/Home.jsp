<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Formatter"%>
<%@page import="dto.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ToDO Home</title>
<style type="text/css">
div {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
	<% 
List<Task> list=(List<Task>) request.getAttribute("list");
%>
	<div>
		<h1>ToDo Home</h1>
		<table border="1">
			<tr>
				<th>Task Name</th>
				<th>Task Description</th>
				<th>Date Created</th>
				<th>Status</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>
			<%
			if(list!=null)
			{
				DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd MMM YYYY hh:mm");
			 for(Task task:list){%>
			<tr>
				<th><%=task.getName() %></th>
				<th><%=task.getDescription() %></th>
				<th><%=task.getCreatedTime().format(formatter)%></th>
				<th>
				<% if(task.isStatus()){
				%>Completed
			     <% }
			     else{%>
			     
			     <a href="change-status?id=<%=task.getId()%>"><button>Complete</button></a>
			     <%} %>
			   </th>
				<th><button>Delete</button></th>
				<th><button>Edit</button></th>
			</tr>
			<%} } %>

		</table>
		<br> <a href="session-add-task"><button>Add Task</button></a><br>
		<a href="Logout"><button>Logout</button></a>
	</div>
</body>
</html>