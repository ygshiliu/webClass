<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload= function(){
		var sub = document.getElementById("sub_btn");
		sub.onclick = function(){
			var form = document.getElementById("login");
			form.submit();
			//使按钮失效
			sub.disabled=true;		
		}
	}
</script>
</head>
<body>
	<%
		//生成token
		String token = UUID.randomUUID().toString();
		//设置到session域
		session.setAttribute("token", token);
	%>

	<h1>注册页面</h1>
	<p>${msg }</p>
	<form action="FormServlet" method="get" id="login">
	<input type="hidden" name="token" value="${sessionScope.token }">
		<label>用户名称：</label>
		<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
		<br />
		<br />
		<label>电子邮件：</label>
		<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" />
		<br />
		<br />
		<input type="button" value="注册" id="sub_btn" />
	
	</form>

</body>
</html>