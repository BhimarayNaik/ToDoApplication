<%@page import="dto.Task"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Task</title>
<style type="text/css">
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
<div>
<%Task task=(Task)request.getAttribute("task"); %>
<h1 align="center">Edit Task</h1>
<form action="update-task" method="post">
		<fieldset>
			<legend>Enter Task Here,</legend>
			<input type="hidden" name="id" value="<%=task.getId()%>">
			<table border="1">


				<tr>
					<th>Task Name :</th>
					<td><input type="text" value="<%=task.getName() %>" name="tname"></td>
				</tr>
				<tr>
					<th>Task Description :</th>
					<td><input type="text" value="<%=task.getDescription() %>" name="tdescription"></td>
				</tr>
				<th><button>Update</button></th>
				<th><button type="reset">Cancel</button></th>
			</table>
		</fieldset>
	</form>
	<br>
	<br>
	<a href="home"><button>Back</button></a>
	</div>
</body>
</html>