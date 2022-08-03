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
<% out.print(request.getAttribute("update_message")); %>
</h1>
<form action="update" method="POST">
<label for="empID">Enter ID to update info of the employee:</label>
<input type="text" id="empID" name="empID"/>
<input type="hidden" name="empName" value=""/>
<input type="hidden" name="salary" value="0"/>
<button type="submit">Find Employee</button>
<br/>
</form>
	<%
		out.print(request.getAttribute("data"));
	%>
	<button><a href="/Assignment_7/">Home</a></button>
</body>
</html>