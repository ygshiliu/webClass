<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录页面</h1>
	
		${pageContext.request.contextPath}
	${cookie }
	${cookie.username}
	${cookie.password}
	<form action="LoginServlet" >
	用户名：<input type="text" id="username" name="username" value="${cookie.username.value }"><br>
	密    码：<input type="password" id="password" name="password" value="${cookie.password.value }"><br>
	<input type="submit" value="登录"><br>
	</form>

	<script type="text/javascript">
	
		//获取页面用户名与密码值 
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		//只要不为空串，就发送请求
		if(username!="" && password !=""){
			location.href="${pageContext.request.contextPath}/LoginServlet?username="+username+"&password="+password;
		}
	
	</script>
</body>
</html>