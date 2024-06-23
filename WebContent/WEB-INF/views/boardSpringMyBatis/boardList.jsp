<%@page import="sample.myBatis.boardV01.BoardDTO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="bodDTO" class="sample.myBatis.boardV01.BoardDTO" />
<jsp:setProperty name="bodDTO" property="*" />
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>** Board Contents **</title>
<link rel="stylesheet" href="resources/css/boardContent.css" />
</head>
<body>
	<div id="wrapper">
		<p class="Title">** Board Contents **</p>
		<%
			List<BoardDTO> boardDTOList = (List<BoardDTO>) request.getAttribute("boardDTOList");
		for (int idx = 0; idx < boardDTOList.size(); idx++) {
		%>
		<table>

			<caption>
				<a
					href="/webPro01/ControllerBoard.do?category=boardDelUpd&UpdDelnum=1">[
					수 정 ]</a> <a
					href="/webPro01/ControllerBoard.do?category=boardDelUpd&UpdDelnum=2">[
					삭 제 ]</a> <a href="/webPro01/ControllerBoard.do?category=boardTitle">[
					글목록 ]</a> <a href="/webPro01/ControllerBoard.do?category=boardWrite">[
					게시판 쓰기 ]</a>
			</caption>

			<tr>
				<td class="Subtitle">Write</td>
				<td><Input type="text" class="textInput" name="bod_writer"
					value="<%=boardDTOList.get(idx).getBod_writer()%>"></Input></td>
				<td class="Subtitle">Date</td>
				<td><Input type="text" class="textInput" name="bod_logtime"
					value="<%=boardDTOList.get(idx).getBod_logtime()%>"></td>
			</tr>
			<tr>
				<td class="Subtitle">Title</td>
				<td colspan="3"><Input type="text" class="titleInput"
					name="bod_subject"
					value="<%=boardDTOList.get(idx).getBod_subject()%>"></Input></td>
			</tr>
			<tr>
				<td class="Subtitle">Contents</td>
				<td colspan="3"><textarea><%=boardDTOList.get(idx).getBod_content()%></textarea></td>
			</tr>
			<%
				}
			%>

		</table>

	</div>
</body>
</html>
