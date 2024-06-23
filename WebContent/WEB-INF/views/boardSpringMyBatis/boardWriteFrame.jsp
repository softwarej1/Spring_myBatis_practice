<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>게시판 글쓰기</title>
  <link rel = "stylesheet" href="resources/css/boardWrite.css"/>
 </head>
 <body>
	<div id = "wrapper">
		<p class = "Title">** 게시판 글쓰기 **</p>
		<form action="<%= contextPath %>/boardWritePro" method="get">
			<table>
				<caption>
					<a href="<%= contextPath %>/boardList">[게시판 내용 List]</a>
					<a href="<%= contextPath %>/boardIndex">[게시판 목록 List]</a>
				</caption>
				<tr>
					<td class = "Subtitle">Writer</td>
					<td><Input type = "text"  class = "textInput" name="bod_writer"></Input></td>
					<td class = "Subtitle">Password</td>
					<td><Input type = "password"  class = "textInput" name="bod_pwd"></td>
				</tr>
				<tr>
					<td class = "Subtitle">Title</td>
					<td colspan = "3"><Input type = "text"  class = "titleInput" name="bod_subject"></Input></td>
				</tr>
				<tr>
					<td class = "Subtitle">Email</td>
					<td colspan = "3"><Input type = "text" class = "titleInput" name = "bod_email"></Input></td>
				</tr>
				<tr>
					<td class = "Subtitle">Contents</td>
					<td colspan = "3"><textarea name = "bod_content"></textarea></td>
				</tr>
			</table>

			<div class = "button">
				<input type = "submit" value = "Write"/>
				<input type = "reset" value = "Reset"/>
			</div>
		</form>
	</div>
 </body>
</html>
