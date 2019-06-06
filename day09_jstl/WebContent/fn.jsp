<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>fn.jsp</h1>

	<%
		//在page域中设置属性
		pageContext.setAttribute("str", "helloworld");
		String[] arr = new String[]{"welcome","to","Beijing"};
		pageContext.setAttribute("arr", arr);
	%>
	
	<br>fn:length:${fn:length(str) } 输出字符串长度
	<br>fn:contains:${fn:contains(str,"llo") } 输出boolean
	<br>fn:contains:${fn:contains(str,"LLO") } 不忽略大小是否包含子串
	<br>fn:containsIgnoreCase:${fn:containsIgnoreCase(str,"LLO") } 忽略大小写是否包含子串
	<br>fn:endsWith:${fn:endsWith(str,"rld") }  是否以子串结尾
	<br>fn:startsWith:${fn:startsWith(str,"hell") } 是否以子串开始
	<br>fn:indexOf:${fn:indexOf(str,"ll") } 返回子串的位置，没有返回-1
	<br>fn:join:${fn:join(arr,"-") } 将字符串数组使用连接符拼起来
	<br>fn:split:${fn:split(str,"-")} 将字符串拆分成数组 ***
	<br>fn:substring:${fn:substring(str,2,4) } 截取子串
	<br>fn:toLowerCase:${fn:toLowerCase("YOU ARE OK！") } 转小写
	<br>fn:toUpperCase:${fn:toUpperCase("are you ok?") } 转大写
	<br>fn:toUpperCase:${fn:trim("   hello   , honey ") } 去掉前后空格
	

</body>
</html>