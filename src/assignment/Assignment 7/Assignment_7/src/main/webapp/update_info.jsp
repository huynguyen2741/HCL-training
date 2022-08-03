<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="POST">
<label for="empName">Name:</label>
<input type="text" id="empName" name="empName" />
<br />
<label for="salary">Salary: </label>
<input type="text" id="salary" name="salary">
<input type="hidden" name="empID" value="<%out.print(request.getAttribute("empID"));%>"/>
<br />
<button type="submit">Update</button>
<button><a href="/Assignment_7/">Home</a></button>
</body>
</html>