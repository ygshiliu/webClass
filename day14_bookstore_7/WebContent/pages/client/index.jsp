<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	$(function(){
		$(".addA").click(function(){
			
			var url =$(this).attr("href");
			
			$.get(url,null,function(result){
				console.log(result)
				var map = $.parseJSON(result)
				$("#msg").find("span").text("您的购物车中有"+map.totalCount +"件商品");
				$("#msg").find("div").html("您刚刚将<span style='color: red'>"+map.title+"</span>加入到了购物车中");
			})
			
			return false;
		})
	})
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<%@ include file="/WEB-INF/include/client.jsp" %>
	</div>
	
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="${page.path }">
				<input type="hidden" name="method" value="${param.method }">
				价格：<input type="text" name="min" value="${param.min}"> 元 - <input type="text" name="max" value="${param.max }"> 元 
				<input type="submit" value="查询">
				</form>
			</div>
			

				
					
			 <c:choose>
				<c:when test="${not empty sessionScope.title}">
					<div style="text-align: center" id="msg">
						<span>您的购物车中有${sessionScope.totalCount }件商品</span>
						<div>
							您刚刚将<span style="color: red">${sessionScope.title}</span>加入到了购物车中
						</div>
					</div>
				
				</c:when>
				<c:otherwise>
					<div style="text-align: center" id="msg">
						<span>您的购物车中没有商品</span>
						<div></div>
					</div>
					
				</c:otherwise>
			</c:choose> 
			
			<c:forEach items="${page.list }" var="book">
			
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="${book.imgPath }" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.title }</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author }</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥${book.price }</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales }</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add">
						<button><a class="addA" href="CartServlet?method=addBook2Cart&bookId=${book.id }">加入购物车</a></button>
					</div>
				</div>
			</div>
			</c:forEach>
		
		</div>
		
		<%@ include file="/WEB-INF/include/page.jsp" %>
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>