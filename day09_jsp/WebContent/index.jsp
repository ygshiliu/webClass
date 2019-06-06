<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.atguigu.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index.jsp</h1>
	
	<%
		pageContext.setAttribute("user'agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36");
	
		pageContext.setAttribute("name", "wang");
		request.setAttribute("name", "xixi");
		session.setAttribute("name", "haha");
		application.setAttribute("name", "yiyi");
		
		User user = new User(1, "xixi", "xixi@163.com");
		pageContext.setAttribute("user", user);
		
		User user1 = new User(1, "xixi", "xixi@163.com");
		User user2 = new User(2, "haha", "haha@163.com");
		User user3 = new User(3, "yiyi", "yiyi@163.com");
		List list = new ArrayList();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		pageContext.setAttribute("list", list);
		
		Map map = new HashMap();
		map.put("user-1", user1);
		map.put("user-2", user2);
		map.put("user3", user3);
		pageContext.setAttribute("map", map);
	%>
	
	<br>
	<!-- 1.向页面输出常量值 -->
	${"123123"}
	${1111 }
	${1111-111 }
	${1111+111 }
	${1111/111 }
	<br>
	<!-- 2.变量:
		默认是从域中获取，会从小到大的顺序依次查找，找到就返回
		域：pageContext request session application
		与域对象对应的内置对象：pageScope requestScope sessionScope applicationScope
		可以指定查找位置。在EL表达式中内置了11个对象，可以通过指定对象来查找数据
		
		会话：一次打开浏览器到关闭浏览器的过程
	 -->
	${name}
	${pageScope.name}
	${requestScope.name}
	${sessionScope.name}
	${applicationScope.name}
	
	<br>
	<!-- 3.对象
		获取对象属性，可以使用'对象.属性'
		有el表达式中.操作的是对象相应的getter方法
		
		getter/setter是javaBean中的标配
		标准的javaBean具备属性私有化，同时提交属性的getter/setter方法，无参构造
	 -->
	${user }
	${user.name1 }
	${user.email }
	${user[email] }
	
	<br>
	
	<!-- 获取list集合中的数据 -->
	${list }<br>
	${list[0] }
	
	<p> 获取map集合中的数据:
	${map }
	<br>获取map中的一个键值对：map.key
	<br>
	<!-- 
	EL会对获取的数据自动进行类型转换
	当变量名中含有特殊字符时，可以使用 map['xxx']  map["xxx"]
	如果是list集合，中括号中指定下标
	如果是map集合，中括号中指定key
	 -->
	${map['user-1']}
	${map.user3}
	
	<br>
	</p>
	
	
	
</body>
</html>