<%@page import="com.atguigu.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		text-align:center
	}
	table{
		width:50%;
		
	}
</style>
</head>
<body>
<!-- 获取共享数据，显示数据 -->

<h1>用户信息</h1>
<c:if test="${empty list }">
	当前暂时没有用户信息
</c:if>
<c:if test="${not empty list }">

	<table border="1" cellspacing="0" cellpadding="10" align="center">
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>邮箱</th>
		</tr>
		<c:forEach items="${list }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.email }</td>
			</tr>
		</c:forEach>
	</table>
</c:if>


</body>
</html>