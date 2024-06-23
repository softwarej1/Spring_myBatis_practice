<%@page import="java.util.List"%>
<%@page import="sample.myBatis.boardV01.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
 <%
 	String contextPath = request.getContextPath();
 %>
 
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>** Board Contents **</title>
  <link rel = "stylesheet" href="resources/css/boardContent.css"/>
 </head>
 

 <body>
	<div id = "wrapper">
		<p class = "Title">** Board Contents **</p>
		<form action="" method="post">
		
			<%
				List<BoardDTO> boardDTOList = (List<BoardDTO>)request.getAttribute("boardConList");
			%>
			<table>
				<caption>
					<!-- UpdDelnum=1 bod_no=boardDTOList.get(0).getBod_no() -->
					<a href="<%= contextPath %>/boardDelUpd?UpdDelnum=1&bod_no=<%= boardDTOList.get(0).getBod_no() %>">[ 수 정 ]</a>
					<a href="<%= contextPath %>/boardDelUpd?UpdDelnum=2&bod_no=<%= boardDTOList.get(0).getBod_no() %>">[ 삭 제 ]</a>
					<a href="<%= contextPath %>/boardList">[ 글목록 ]</a>
					<a href="<%= contextPath %>/boardWrite">[ 게시판 쓰기 ]</a>
				</caption>
				<tr>
					<td class = "Subtitle">글번호</td>
					<td><Input type = "text" class = "textInput" name = "bod_no" value = "<%= boardDTOList.get(0).getBod_no() %>"></Input></td>
					<td class = "Subtitle">조회수</td>
					<td><Input type = "text" class = "textInput" name = "bod_readCnt" value = "<%= boardDTOList.get(0).getBod_readCnt() %>"></td>
				</tr>

				<tr>
					<td class = "Subtitle">Write</td>
					<td><Input type = "text" class = "textInput" name = "bod_writer" value = "<%= boardDTOList.get(0).getBod_writer() %>"></Input></td>
					<td class = "Subtitle">Date</td>
					<td><Input type = "text" class = "textInput" name = "bod_logtime" value = "<%= boardDTOList.get(0).getBod_logtime() %>"></td>
				</tr>
				<tr>
					<td class = "Subtitle">Email</td>
					<td colspan = "3"><Input type = "text" class = "titleInput" name = "bod_email" value = "<%= boardDTOList.get(0).getBod_email() %>"></Input></td>
				</tr>
				<tr>
					<td class = "Subtitle">Title</td>
					<td colspan = "3"><Input type = "text" class = "titleInput" name = "bod_subject" value = "<%= boardDTOList.get(0).getBod_subject() %>"></Input></td>
				</tr>
				<tr>
					<td class = "Subtitle">Contents</td>
					<td colspan = "3" ><textarea><%= boardDTOList.get(0).getBod_content() %></textarea></td>
				</tr>
			</table>
		</form>
	</div>
 </body>
</html>
    