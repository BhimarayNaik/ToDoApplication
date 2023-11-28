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
<tr>
<td>Swimming</td>
<td>Water</td>
<td>12-nov-2023</td>
<td>Complete</td>
<td><button>Delete</button></td>
<td><button>Edit</button></td>
</tr>
</table><br>
<a href="session-add-task"><button>Add Task</button></a><br>
<a href="Logout"><button>Logout</button></a>
</div>
</body>
</html>