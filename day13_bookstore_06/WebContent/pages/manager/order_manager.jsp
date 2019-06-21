<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/include/base.jsp" %>
<title>订单管理</title>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
			<%@ include file="/WEB-INF/include/manager.jsp" %>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>订单编号</td>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
				
			</tr>		
			<c:forEach items="${orders }" var="order">
				<tr>
					<td>${order.id }</td>
					<td><fmt:formatDate value="${order.createDate }" type="both"/></td>
					<td>${order.totalAmount }</td>
					<td><a href="OrderServlet?method=findOrderDetailsByOrderId&orderId=${order.id }">查看详情</a></td>
					<td>
					<c:choose>
						<c:when test="${order.state==0 }">
							<a href="OrderManagerServlet?method=sendGoods&orderId=${order.id }">点击发货</a>
						</c:when>
						<c:when test="${order.state==1 }">
							等待用户签收
						</c:when>
						<c:otherwise>
							交易完成
						</c:otherwise>
					</c:choose>
				</tr>	
			
			</c:forEach>
				
		</table>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>