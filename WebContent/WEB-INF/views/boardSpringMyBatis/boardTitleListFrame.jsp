<%@page import="sample.myBatis.boardV01.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.DbSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	String contextPath = request.getContextPath();
%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>** Board Title List **</title>
  <link rel = "stylesheet" href="resources/css/boardTitleList.css"/>
 </head>
 <body>
	<div id = "wrapper">
		<p class = "Title">**Board Title List**</p>
		<form action="<%= contextPath %>/boardContent" method="get">
		<input type="hidden" id = "attr" value = "" name = "bod_no">
			<table>
				<caption>
					<a href="<%= contextPath %>/boardList">[게시판 리스트]</a>
					<a href="<%= contextPath %>/boardWrite">[게시판 쓰기]</a>
					
				</caption>
				<tr>
					<td width = "160px">번호</td>
					<td width = "250px">제목</td>
					<td width = "200px">글쓴이</td>
					<td width = "150px">등록일</td>
					<td width = "200px">조회</td>
					<td width = "200px">IP</td>
				</tr>
				<%
					List<BoardDTO> boardTitleList =  (List<BoardDTO>)request.getAttribute("boardTitleList");
					for(BoardDTO boardDTO : boardTitleList){
				%>
				
				<tr style="cursor: pointer;" onclick="valSend(<%= boardDTO.getBod_no() %>)">
					<td id = "bod_no"><%= boardDTO.getBod_no() %></td>
					<td><%= boardDTO.getBod_subject() %></td>
					<td><%= boardDTO.getBod_writer() %></td>
					<td><%= boardDTO.getBod_logtime() %></td>
					<td><%= boardDTO.getBod_readCnt() %></td>
					<td><%= boardDTO.getBod_connIp() %></td>
				</tr>
				<%
					}
				%>
			</table>
		</form>
	</div>
	
	<script type="text/javascript">
		function valSend(bod_no) {
			document.getElementById("attr").value = bod_no;
			document.getElementsByTagName("form")[0].submit();
		}
	</script>
 </body>
</html>
