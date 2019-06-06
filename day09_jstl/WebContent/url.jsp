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
	
	<h1>路径相关</h1>
	<!-- 
	用来重写url路径 ，如果是绝对路径会加上项目名，如果是相对路径而没有什么变化
	同时会在第1次访问页面时产生“jsessionid=362571F525D458BCA32AB93E2B2188F8”字符串附加在url路径后面
	以后再访问服务器，浏览器都会带着这个字符串。这个字符串就是浏览器与服务器之间通过的标识
	
	value:指定需要重写的url
	var:将重写后的url设置一个作为域中的键名
	scope:指定要存放的域
	
	注：如果指定var则会将url保存到域中，不会输出显示;否则反之
	 -->
	<c:url value="/index.jsp"   ></c:url>
	==== ${index }
	<!-- 可以实现重定向到url指定的位置
		注意路径优先使用绝对路径，而在这里的/代表的是项目名
		url:指定要重定向的url
	 -->
 	<c:redirect url="/index.jsp" ></c:redirect> 
	
</body>
</html>