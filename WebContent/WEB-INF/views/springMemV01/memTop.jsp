<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memTop.jsp</title>
</head>

<%
	String vUrl = request.getContextPath();
%>
<body>
	<ul>

		<li><a href="<%=vUrl%>/myBatis/index">Main</a></li>
		<li><a href="<%=vUrl%>/myBatis/memLog">Login</a></li>
		<li><a href="<%=vUrl%>/myBatis/memIns">Insert</a></li>
		<li><a href="<%=vUrl%>/myBatis/memUpd">Update</a></li>
		<li><a href="<%=vUrl%>/myBatis/memDel">Delete</a></li>
		<li><a href="<%=vUrl%>/myBatis/memSel">Select</a></li>

	</ul>
</body>
</html>