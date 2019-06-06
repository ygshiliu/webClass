<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1.jsp</h1>

<%
Cookie cookie = new Cookie("name","wnn");
response.addCookie(cookie);
%>

<p>

	El中内置了11个对象：pageContext pageScope requestScope sessionScope applicationScope param paramValues
	header headerValues initParam cookie
</p>
<p>
<hr>
	类型：PageContext
	作用：与jsp中pageContext一样，可以获取其它8个jsp内置对象
	<br>${pageContext }
<hr>
	<![CDATA[
	类型：Map<String,Object>
	作用：与域对应，用来在指定域获取数据 	
	]]>
 	<br>${pageScope}
	<br>${requestScope}
	<br>${sessionScope}
	<br>${applicationScope}
	

<hr>	
	<![CDATA[
	类型：Map<String,String>
	作用：用来从请求参数中获取1个key的1个数据
	]]>
	<br>${param}
	
<hr>	
	<![CDATA[
	类型：Map<String,String[]>
	作用：用来从请求参数中获取相同key的多个数据
	]]>
	<br>${paramValues}
	
<hr>
	<br><![CDATA[
	类型：Map<String,String>
	作用：用来从请求参数头中获取1个key的1个数据
	]]>
	<br>${header}
<hr>
	<br><![CDATA[
	类型：Map<String,String[]>
	作用：用来从请求头中获取相同key的多个数据
	]]>
	<br>${headerValues}
<hr>
	<br><![CDATA[
	类型：Map<String,String>
	作用：用来获取jsp对应的servlet配置信息中的初始参数
	]]>
	<br>${initPrama}
<hr>
	<br><![CDATA[
	类型：Map<String,cookie>
	作用：用来获取cookie
	]]>
	<br>${cookie}


</body>
</html>