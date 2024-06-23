<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">

  <title>MemInsFrame.html</title>
  <link rel="stylesheet" href="resources/css/MemCommon.css"/>
  <link rel="stylesheet" href="resources/css/MemIns.css"/>
  <%
  String vURL = request.getContextPath();
  %>
 </head>
	 <body>
		 <div id = "wrapper">
			<form action="<%= vURL %>/frmIns" method="get">
				<table>
					<thead>
						<tr>
							<td colspan = "2">
								<font>Insert</font>
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

						<tr>
							<td class = "td_discription">E-mail</td>
							<td>
								<input type = "text" class = "textfiled" placeholder="E-mail 입력" name = "mem_email"/>
							</td>
						</tr>

						<tr class = "tr_even">
							<td class = "td_discription">PhoneNumber</td>
							<td>
								<input type = "text" class = "textfiled" placeholder="PhoneNumber 입력" name = "mem_phone"/>
							</td>
						</tr>

						<tr>
							<td class = "td_discription">Address</td>
							<td>
								<input type = "text" class = "textfiled" placeholder="Address 입력" name = "mem_addr"/>
							</td>
						</tr>
					</tbody>

					<tfoot>

						<tr>
							<td colspan = "2" >
								<input type="submit" class = "button" value = "Insert"></input>
								<input type="reset" class = "button" value = "Cancle"></input>
							</td>
						</tr>
					</tfoot>
				</table>
			</form>
		  </div>
	 </body>
</html>
