<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/include/base.jsp" %>
<title>图书管理</title>
<script type="text/javascript">
	$(function(){
		$(".del").click(function(){
			//获取当前单击标签的祖先tr,并找到它的第1个后代td元素，取其文本值
			var title = $(this).parents("tr").find("td:first").text();
			//弹出确认框，再次确认后删除
			if(!confirm("您确认要删除< "+title+" >图书吗？")){
				return false;
			}
			
		})
	})

</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%@ include file="/WEB-INF/include/manager.jsp" %>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
		<c:forEach items="${page.list}" var="book">
			<tr>
				<td>${book.title }</td>
				<td>${book.price }</td>
				<td>${book.author }</td>
				<td>${book.sales }</td>
				<td>${book.stock }</td>
				<td><a href="ManagerBookServlet?method=getBookById&bookId=${book.id }">修改</a></td>
				<td><a href="ManagerBookServlet?method=deleteBook&bookId=${book.id }" class="del">删除</a></td>
			</tr>	
		
		</c:forEach>			
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>
		
	<%@ include file="/WEB-INF/include/page.jsp" %>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>