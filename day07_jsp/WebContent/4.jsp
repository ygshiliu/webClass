<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>4.jsp</h1>
	
	<%
		pageContext.setAttribute("username", "xixi");
		request.setAttribute("gender", "male");
		session.setAttribute("hobby", "read books");
		application.setAttribute("age", "18");
	%>
	
	<%=pageContext.getAttribute("username") %><br>
	<%=request.getAttribute("gender") %><br>
	<%=session.getAttribute("hobby") %><br>
	<%=application.getAttribute("age") %><br>
	
	<jsp:forward page="/5.jsp"></jsp:forward> 
	
</body>
</html>