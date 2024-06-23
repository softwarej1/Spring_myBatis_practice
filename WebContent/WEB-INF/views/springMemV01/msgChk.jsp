<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#wrapper{
		width: 500px;
		margin: 0 auto;
		height: auto;
		text-align: center;
	}
	
	.message_box{
		background-color: orange;
		height: 100px;
		width: 500px;
		color: white;
		padding-top: 20px;
	}
		
	.chk_box{
		color: orange;
		height: 250px;
		background-color: #EAEAEA;
		padding-top: 120px;
	}
</style>
</head>
<body>
	<div id = "wrapper">
	
		<div class = "message_box">
			<h1>Message</h1>
		</div>
		<div class = "chk_box">
			
			<h1>
			<%
				String msg = (String)request.getAttribute("msg");
				if(msg != null){
					out.print(msg);	
				}else{
					out.print("Msg Chk");
				}
				
			%>			
			
			</h1>
		</div>
	</div>
</body>
</html>