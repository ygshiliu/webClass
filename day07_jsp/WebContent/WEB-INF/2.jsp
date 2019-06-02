<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>2.jsp jsp动作标签</h1>
	<!-- 用来转发页面 ,page用来指定路径，/代表项目根目录 -->
<%-- 	<jsp:forward page="/WEB-INF/3.jsp">
	<jsp:param value="xixi" name="username"/>
	<jsp:param value="female" name="gender"/>
	
	</jsp:forward> --%>
	
	<!-- 用来动态将3.jsp结果包含进当前文件中 -->
	<!-- 实际会翻译成各自的java文件，然后通过include方法将结果引入 -->
	<jsp:include page="/WEB-INF/3.jsp"></jsp:include>
</body>
</html>