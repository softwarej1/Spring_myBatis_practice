<%@page import="sample.spring.MemV01.MemDTO"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.DbSet"%>
<%@page import="java.sql.Connection"%>
<html lang="en">
<head>
<meta charset="UTF-8">

<title>MemSelFrame.html</title>
<link rel="stylesheet" href="resources/css/MemCommon.css" />
<link rel="stylesheet" href="resources/css/MemSel.css" />
</head>
<body>
	<div id="wrapper">
		<form>
			<table>
				<thead>
					<tr>
						<td colspan="5"><font>Select</font></td>
					</tr>
				</thead>


				<tr>
					<td>ID</td>
					<td>E-mail</td>
					<td>Name</td>
					<td>PhoneNumber</td>
					<td>Address</td>
				</tr>

				<%
					List<MemDTO> dtoL = (List<MemDTO>) request.getAttribute("memDtoL");
				for (int idx = 0; idx < dtoL.size(); idx++) {
				%>
				<tfoot>
					<tr>
						<td><%=dtoL.get(idx).getMem_id()%></td>
						<td><%=dtoL.get(idx).getMem_email()%></td>
						<td><%=dtoL.get(idx).getMem_name()%></td>
						<td><%=dtoL.get(idx).getMem_phone()%></td>
						<td><%=dtoL.get(idx).getMem_addr()%></td>
					</tr>
				</tfoot>

				<%
					}
				%>


			</table>
		</form>
	</div>
</body>
</html>
