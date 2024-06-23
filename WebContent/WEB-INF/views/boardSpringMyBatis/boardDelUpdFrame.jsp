<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	String contextPath = request.getContextPath();
	
	// boardDelUpd?UpdDelnum=2&bod_no=6
			
	String UpdDelnum = request.getParameter("UpdDelnum");
	String bod_no = request.getParameter("bod_no");
%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>게시판 삭제</title>
  <link rel = "stylesheet" href="resources/css/boardDel.css"/>
 </head>
 <body>
	<div id = "wrapper">
		<form action="<%= contextPath %>/boardDelUpdPro" method="get">
			<div>
				<p>** 글을 남기실때 입력하신 비밀번호를 입력하여 주십시오! **</p>
				<input type="text" id = "textField" name = "bod_pwd">
				<input type="hidden" name="UpdDelnum" value = "<%= UpdDelnum%>">
				<input type="hidden" name="bod_no" value = "<%= bod_no %>">
				<div class="button_box">
					<input type="submit" value="확인">
					<input type="reset" value="취소">
				</div>
			</div>
		</form>
	</div>
 </body>
</html>
