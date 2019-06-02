<%@page import="com.atguigu.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
	List<User> list = (List<User>)request.getAttribute("list");
%>
<h1>用户信息</h1>
	<table border="1" cellspacing="0" cellpadding="10" align="center">
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>性别</th>
		</tr>
		<%
		for(int i=0;i<list.size();i++){
			User user = list.get(i);
		%>
		<tr>
			<td><%=user.getId() %></td>
			<td><%=user.getName() %></td>
			<td><%=user.getGender() %></td>
		</tr>
		<%
		}
		%>
	</table>



</body>
</html>