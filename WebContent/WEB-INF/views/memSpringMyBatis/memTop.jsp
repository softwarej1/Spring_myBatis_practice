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
		<li><a href="<%=vUrl%>/myBatisIndex">Main</a></li>
		<li><a href="<%=vUrl%>/myBatisMemLog">Login</a></li>
		<li><a href="<%=vUrl%>/myBatisMemIns">Insert</a></li>
		<li><a href="<%=vUrl%>/myBatisMemUpd">Update</a></li>
		<li><a href="<%=vUrl%>/myBatisMemDel">Delete</a></li>
		<li><a href="<%=vUrl%>/myBatisMemSel">Select</a></li>
	</ul>
</body>
</html>