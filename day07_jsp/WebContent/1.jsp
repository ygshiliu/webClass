<%@page import="java.util.ArrayList"%>
<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    autoFlush="true"
    buffer="8kb" 
    errorPage=""
    info="xxx"
    isELIgnored="false"
    isErrorPage="false"
    isThreadSafe="true"
    session="true"
    trimDirectiveWhitespaces="true"
    deferredSyntaxAllowedAsLiteral="false"%>
    
 <!-- 
 共有15个属性可以进行设置：
 language="java" 用来指定当前jsp页面使用哪种语言，只有一种java
 contentType="text/html; charset=UTF-8" 设置响应头mime值及字符集
 pageEncoding="UTF-8"  翻译成java文件时使用的字符集
 autoFlush="true"  自动刷新缓存
 buffer="8kb"  设置缓存大小
 errorPage=""  指定跳转的出错页面
 extends=""	  给jsp翻译后的类指定父类
 import=""  用来导入类
 info=""  用来对jsp进行文本描述
 isELIgnored="false"  是否乎略EL表达
 isErrorPage="false" 是否是错误页面
 isThreadSafe="true" 
 	--是否支持多线程，设置false时，翻译后类后多实现一个接口javax.servlet.SingleThreadModel
 session="true" 是否创建session对象
 trimDirectiveWhitespaces="false" 这个命令可以使jsp输出的html时去除多余的空行（jsp上使用EL和tag会产生大量的空格和空行）。
 
 deferredSyntaxAllowedAsLiteral="false" 是否允许文本"#{"在页面中出现
 	--在JSP 2.1中，字符序列#{被保留给表达式语言使用，你不能在模板本中使用字符序列#{。如果JSP页面运行在JSP 2.1之前版本的容器中，则没有这个限制。对于JSP 2.1的容器，如果在模板文本中需要出现字符序列#{，那么可以将该属性设置为true
  -->
  
<%@ include file="index.jsp" %>
<%-- <%@taglib prefix="" tagdir="" uri="" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>1.jsp</h1>
		
		<p>sfasdsdas</p>
		
		<%-- #{ } --%>
		
		
		<!-- 脚本片段 -->
		<%
		int i=0;
		 //i=2;
		/* public void getI(){
			System.out.print(i);
		} */
		
		final Integer number;
		
		/* static {
			System.out.print(i);
		} */
		%>
		<!-- jsp表达式 -->
		<%= i %>
		<%
		//int i=2;
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		for(int j=0;j<list.size();j++){
			//System.out.println(list.get(j));
%>
		<!-- jsp表达式 -->
		<%=j %>
<%
		}
		%>
		
		<!-- jsp声明 -->
		<%!
	 	private static int i=0;
		
		static {
			i++;
		}
		public void getI(){
			System.out.print(i);
		}
		 
		%>
		<%-- jps注释 --%>
		<!--html注释  -->
</body>
</html>