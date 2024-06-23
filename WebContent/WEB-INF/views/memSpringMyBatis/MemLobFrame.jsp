<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!doctype html>
<html lang="en">

<%
	String vUrl = request.getContextPath();
%>

<head>
	<meta charset="UTF-8">

	<title></title>
	<link rel="stylesheet" href="resources/css/MemCommon.css" />
	<link rel="stylesheet" href="resources/css/MemLog.css" />
</head>

<body>
	<div id="wrapper">
		<form action="<%= vUrl %>/myBatisfrmLog">
			<table>
				<thead>
					<tr>
						<td colspan="2">
							<font>Login</font>
						</td>
					</tr>
				</thead>

				<tbody>
					<tr class="tr_even">
						<td class="td_discription">ID</td>
						<td>
							<input type="text" id="id" class="textfiled" placeholder="ID 입력" name = "mem_id" />
						</td>
					</tr>
					<tr>
						<td class="td_discription">Password</td>
						<td>
							<input type="text" id="pwd" class="textfiled" placeholder="Password 입력" name = "mem_pwd" />
						</td>
					</tr>

					<tr class="tr_even">
						<td class="td_discription">Message</td>
						<td>
							<input type="text" id="msg" class="textfiled" placeholder="Message 입력" readonly />
						</td>
					</tr>
				</tbody>

				<tfoot>

					<tr>
						<td colspan="2">
							<input type="submit" class="button" value="LogIn"></input>
							<input type="reset" class="button" value="Cancle"></input>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	
	<script type="text/javascript">
	let objInput;
	
	function mInit() {
		objInput = document.getElementsByTagName("input");
		objId.focus();
	}
	</script>
</body>

</html>
