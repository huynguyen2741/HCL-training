<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style=color:red>
<% out.print(request.getAttribute("message")); %>
</h1>
<form action="create" method="POST">
<label for="empID">ID:</label>
<input type="text" id="empID" name="empID" />
<br />
<label for="empName">Name:</label>
<input type="text" id="empName" name="empName" />
<br />
<label for="salary">Salary: </label>
<input type="text" id="salary" name="salary">
<br />
<button type="submit">Create</button>
<button><a href="/Assignment_7/">Home</a></button>
</form>
</body>
</html>