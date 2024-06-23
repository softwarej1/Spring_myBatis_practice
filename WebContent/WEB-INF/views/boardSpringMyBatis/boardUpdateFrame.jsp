
<%@page import="sample.myBatis.boardV01.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String contextPath = request.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>게시판 수정</title>
<link rel="stylesheet" href="resources/css/boardUpdate.css" />
</head>
<body>
	<div id="wrapper">
		<p class="Title">** 게시판 수정 **</p>
		<form action="<%= contextPath %>/boardUpdPro" method="get">
			<table>
				<caption>
					<a href="<%=contextPath%>/boardList">[게시판 내용 List]</a> <a
						href="<%=contextPath%>/boardIndex">[게시판 목록 List]</a>
				</caption>

				<%
					List<BoardDTO> boardDTO = (List<BoardDTO>) request.getAttribute("bodSelUpdList");
				%>
				<input type="hidden" name="bod_no"
					value="<%=boardDTO.get(0).getBod_no()%>">
				<tr>

					<td class="Subtitle">Writer</td>
					<td><Input type="text" name="bod_writer"
						value="<%=boardDTO.get(0).getBod_writer()%>" class="textInput"
						readonly="readonly"></Input></td>
					<td class="Subtitle">Password</td>
					<td><Input type="password" name="bod_pwd"
						value="<%=boardDTO.get(0).getBod_pwd()%>" class="textInput"></td>
				</tr>

				<tr>
					<td class="Subtitle">Title</td>
					<td colspan="3"><Input type="text" name="bod_subject"
						value="<%=boardDTO.get(0).getBod_subject()%>" class="titleInput"></Input></td>
				</tr>
				<tr>
					<td class="Subtitle">Email</td>
					<td colspan="3"><Input type="text" name="bod_email"
						value="<%=boardDTO.get(0).getBod_email()%>" class="titleInput"></Input></td>
				</tr>

				<tr>
					<td class="Subtitle">Contents</td>
					<td colspan="3"><textarea name="bod_content"><%=boardDTO.get(0).getBod_content()%></textarea></td>
				</tr>
			</table>
			<div class="button">
				<input type="submit" value="Update" /> <input type="reset"
					value="Reset" />
			</div>
		</form>
	</div>
</body>
</html>
