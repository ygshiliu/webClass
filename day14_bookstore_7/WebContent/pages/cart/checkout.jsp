<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/include/base.jsp" %>
<title>结算页面</title>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">结算</span>
			<%@ include file="/WEB-INF/include/client.jsp" %>
	</div>
	
	<div id="main">
		
		<c:choose>
			<c:when test="">
				<h1><span  style="color:red">${msg}</span></h1>
			</c:when>
			<c:otherwise>
				<h1>你的订单已结算，订单号为<span style="color:red">${orderId}</span></h1>
			</c:otherwise>
		</c:choose>
		
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>