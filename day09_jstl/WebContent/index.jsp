<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//	pageContext.setAttribute("name", "haha");
	//pageContext.setAttribute("name", "<script>alert('hello everybody!')</script>");

%>

	<h1>index.jsp</h1>
	<!-- 作用：将value属性指定的值输出到页面
		类似jsp表达式及EL表达式
		通常jstl标签的使用与EL结合使用
		
		default:用来指定默认值
		escapeXml:是否解析特殊字符,默认为true
	 -->
	<c:out value="${name }" default="xixi" escapeXml="false" ></c:out>
	
	<!-- 向域中设置数据，默认pageContext -->
	<!-- 
		scope用来指定域 
		var指定在域中的key
		value指定值
	-->
	<c:set  scope="request" value="18" var="age"></c:set>
	
	<br>年龄：${requestScope.age }
	
</body>
</html>