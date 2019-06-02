<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HelloWord jsp!!</h1>
	
	<!-- jsp脚本元素 -->
	<%
		//向控制台输出信息
		System.out.print("我们在做测试jsp");
	%>
	<!-- jsp表达式 -->
	<%= "测试jsp成功" %>
	
	<jsp:forward page="/WEB-INF/2.jsp"></jsp:forward>
</body>
</html>