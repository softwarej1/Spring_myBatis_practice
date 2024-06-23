<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  
  <%
  
  String vURL = request.getContextPath();
  %>

  <title>MemDelFrame.html</title>
  <link rel="stylesheet" href="resources/css/MemCommon.css"/>
  <link rel="stylesheet" href="resources/css/MemDel.css"/>
 </head>
	 <body>
		 <div id = "wrapper">
			<form action = "<%= vURL %>/frmDel">
				<table>
					<thead>
						<tr>
							<td colspan = "2">
								<font>Delete</font>
							</td>
						</tr>
					</thead>

					<tbody>
						<tr class = "tr_even">
							<td class = "td_discription">Name</td>
							<td>
								<input type = "text" class = "textfiled" placeholder="Name 입력" name = "mem_name"/>
							</td>
						</tr>
						<tr>
							<td class = "td_discription">ID</td>
							<td>
								<input type = "text" class = "textfiled" placeholder="ID 입력" name = "mem_id"/>
							</td>
						</tr>

						<tr class = "tr_even">
							<td class = "td_discription">Password</td>
							<td>
								<input type = "text" class = "textfiled" placeholder="Password 입력" name = "mem_pwd"/>
							</td>
						</tr>

					</tbody>

					<tfoot>

						<tr>
							<td colspan = "2" >
								<input type="submit" class = "button" value = "Delete"></input>
								<input type="reset" class = "button" value = "Cancle"></input>
							</td>
						</tr>
					</tfoot>
				</table>
			</form>
		  </div>
	 </body>
</html>
