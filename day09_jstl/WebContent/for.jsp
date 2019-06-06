<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.atguigu.bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<h1>循环</h1>
<%
	List list = new ArrayList();
	//list.add(1);
	//list.add(2);
	//list.add(3);
	//list.add(4);
	
	list.add(new User(1,"xixi","xixi@163.com"));
	list.add(new User(2,"yiyi","yiyi@163.com"));
	list.add(new User(3,"waiwai","waiwai@163.com"));
	list.add(new User(4,"niuniu","niuniu@163.com"));
	
	pageContext.setAttribute("list", list);
	
	Map map = new HashMap();
	map.put("name","wowo");
	map.put("age",18);
	map.put("email","wowo@163.com");
	pageContext.setAttribute("map", map);

%>

<!-- 实现循环处理，与java中的for对比学习
	- 可以模拟出分页数字
		begin:用来指定初始值
		end:用来指定终值
		var:将每次遍历的值，以var指定的值为key,以遍历的值为value设置到pageContext域中，有效范围是在标签内
		step:用来设置步长，默认是1
	- 可以遍历集合，将元素分别取出显示到页面中
		items:用来获取集合
		var:将每次遍历的元素取出作为value, 以var指定的值为key 存放到pageContext域中，有效范围是在标签内
	- 遍历map时，每次是一个entity即一个key=value形式
		varStatus:会将当前遍历的元素相关信息封装LoopTagSupport对象
		count:用来获取当前元素在集合中的顺序，从1开始，通常我们可以用它在页面中充当编号使用
		index:在集合中的下标，从0开始
		first:用来判断是否为第1个，返回boolean值
		last:用来判断是否为最后1个，返回boolean值
 -->
  <c:forEach items="${map }" var="entity" varStatus="vs">
 	${entity}<br>
<%--  	${entity.key}<br>
 	${entity.value}<br> --%>
 	LoopTagSupport:${vs}<br>
 	顺序：${vs.count}<br>
 	下标：${vs.index}<br>
 	是否为第1个：${vs.first}<br>
 	是否为最后1个：${vs.last}<br>
 	
 	<hr>
 </c:forEach>
 
 <br> 
 <br>
 <br>
 
 
 <c:forEach items="${list }" var="user" >
 	${user.id }<br>
 	${user.name1 }<br>
 	${user.email }<br>
 </c:forEach>
 
 <br> 
 <br>
 <br>
 
 
<c:forEach begin="1" end="10" var="page" step="2" >
	<a href="#">${page }</a>
</c:forEach>

</body>
</html>