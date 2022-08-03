<%@ page import="assignment7.model.Employee" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.print(request.getAttribute("data"));
	%>
</body>
<button><a href="/Assignment_7/">Home</a></button>
</html>