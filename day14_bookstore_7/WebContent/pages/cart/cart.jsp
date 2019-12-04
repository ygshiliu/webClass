<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/include/base.jsp" %>
<title>购物车</title>
<script type="text/javascript">
	$(function(){
		$(".del").click(function(){
			var title = $(this).parents("tr").find("td:first").html();
			if(!confirm("请问确实要删除< "+title+" >图书吗？")){
				return false;
			}
			
			var delA = $(this);
			var url = delA.attr("href")
			$.get(url,null,function(result){
				console.log(result);
				var map = $.parseJSON(result);
				$(".b_count:first").text(map.totalCount)
				$(".b_price:first").text(map.totalAmount)
				delA.parents("tr").remove();
			})
			
			return false;
		})
		
		$(".update").change(function(){
			var count = $(this).val();
			var bookId = $(this).attr("id");
			var amount = $(this).parents("tr").find("td:eq(3)");
			
			var url = "${pageContext.request.contextPath}/CartServlet?method=updateCountByBookId&bookId="+bookId+"&count="+count;
			//异步处理
			$.get(url,null,function(result){
				console.log(result)
				var map = $.parseJSON(result)
				$(".b_count:first").text(map.totalCount)
				$(".b_price:first").text(map.totalAmount)
				amount.text(map.amount);
			})
			
			//同步处理：
			//location.href = "${pageContext.request.contextPath}/CartServlet?method=updateCountByBookId&bookId="+bookId+"&count="+count;
			
		})
	})
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@ include file="/WEB-INF/include/client.jsp" %>
	</div>
	
	<c:choose>
		<c:when test="${empty cart.cartItemList }">
			<div id="main"  style="text-align:center;color:red;" >
				<h1><span><br><br>购物车目前是空的，快去购物吧！！</span></h1>
			</div>
		</c:when>
		<c:otherwise>
		
			<div id="main">
			
				<table>
					<tr>
						<td>商品名称</td>
						<td>数量</td>
						<td>单价</td>
						<td>金额</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${sessionScope.cart.cartItemList }" var="item">
					
						<tr>
							<td>${item.book.title }</td>
							<td><input class="update" id="${item.book.id }" value="${item.count }" style="width:30px;text-align:center"></td>
							<td>${item.book.price }</td>
							<td>${item.amount}</td>
							<td><a class="del" href="CartServlet?method=deleteCartItemByBookId&bookId=${item.book.id }">删除</a></td>
						</tr>	
						
					</c:forEach>		
					
					
				</table>
				
				<div class="cart_info">
					<span class="cart_span">购物车中共有<span class="b_count">${cart.totalCount }</span>件商品</span>
					<span class="cart_span">总金额<span class="b_price">${cart.totalAmount }</span>元</span>
					<span class="cart_span"><a href="CartServlet?method=clearCart">清空购物车</a></span>
					<span class="cart_span"><a href="OrderServlet?method=createOrder">去结账</a></span>
				</div>
			
			</div>
		</c:otherwise>
	</c:choose>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>