<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/include/base.jsp" %>
<title>订单详情页</title>
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}
</style>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">订单详情页</span>
		<%@ include file="/WEB-INF/include/client.jsp" %>
	</div>

	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>金额</td>
				<td>单价</td>
			</tr>	
			<c:forEach items="${odList }" var="detail">
			
				<tr>
					<td>${detail.title }</td>
					<td>${detail.bcount }</td>
					<td>${detail.amount }</td>
					<td>${detail.price }</td>
				</tr>	
			
			</c:forEach>	
			
				
			
		</table>
		
	
	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2018 </span>
	</div>
</body>
</html>