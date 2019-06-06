<%@page import="com.atguigu.bean.User"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>2.jsp</h1>
	<!-- 
		在EL表达式中可以使用算术运算符、比较运算符等，同时还有一个特殊运算符empty
		empty可以用来判断空字符串、空数组、空集合，所谓空就是大小长度为0时，结果默认为真
		同时可以结合！ 或 not ,取反操作
		判断域中对象是否为null
	 -->
	<%
	String str="";
	pageContext.setAttribute("str", str);
	
	List list = new ArrayList();
	pageContext.setAttribute("list", list);
	
	String[] ss = new String[0];
	pageContext.setAttribute("ss", ss);
	
	Map map = new HashMap();
	pageContext.setAttribute("map", map);
	
	User user = new User();
	pageContext.setAttribute("user", null);
	%>
	
	<!-- 运算符empty -->
	<br>empty "":${empty "" }
	<br>empty "122":${empty "122" }
	<br>empty str:${empty str }
	<br>empty list:${empty list }
	<br>empty array:${empty ss }
	<br>empty map:${empty map }
	<br>empty user:${user != null}
	<br>empty user:${empty user}
	
	<!-- 
	String[] ss = new String[0];
	java.lang.ArrayIndexOutOfBoundsException: 0 
	-->
	<br>empty array:${ss[0] } ---- <%=((String[])pageContext.getAttribute("ss"))[0] %>
	
	
</body>
</html>