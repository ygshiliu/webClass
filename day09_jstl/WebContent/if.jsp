<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	pageContext.setAttribute("cj",95);

%>

	<h1>if..else</h1>
	
	<!-- 
		类似：java中的if语句
		作用：用来处理页面中条件逻辑输出，满足条件才会执行 
		test:用来判断是否满足条件，返回boolean，为true才会执行
	-->
	<c:if test="${empty str }">
		域中没有设置属性str<br>
	</c:if>
	
	<!-- 
		类似java中的if..else if ... else if... else
		注：
			choose是when 和 otherwise的父标签，它们不可以脱离choose标签使用
			所有when都没有满足的情况下，otherwise会被执行
			注意设置条件判断时的先后顺序，有一个满足后面就不会执行了
	 -->
	 <c:choose>
	 	<c:when test="${cj>60 }">
	 		及格
	 	</c:when>
	 	<c:when test="${cj>70 }">
	 		一般
	 	</c:when>
	 	<c:when test="${cj>80 }">
	 		良好
	 	</c:when>
	 	<c:when test="${cj>90}">
	 		优秀
	 	</c:when>
	 	<c:otherwise>
	 		需要提升
	 	</c:otherwise>
	 </c:choose>
</body>
</html>