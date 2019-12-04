<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/include/base.jsp" %>
<title>编辑图书</title>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
	
	#addPhoto{
		border:1px solid grey;
		text-size:30px;
		text-align: left;
	}
	
	#addPhoto div{
	 display:inline-block;
	}
	
</style>
<script type="text/javascript">
	$(function(){
		
			$("[name=imgPath]").change(function(event){
			
			   //获取当前文件
            var  files = event.target.files,file;
            if(files  && files.length>0){
                file = files[0];
            }
            var img = $(this).siblings("img");
			
            var reader = new FileReader();
        	reader.readAsDataURL(file);
        	console.log(reader.result)
        	reader.onload = function(e){
        		img.attr("src",e.target.result);
        	} 
			
		})
		
	})
	

</script>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%@ include file="/WEB-INF/include/manager.jsp" %>
		</div>
		
		<div id="main">
			<form action="ManagerBookServlet?method=saveOrUpdateBook2" method="post" enctype="multipart/form-data">
<!-- 			<form action="ManagerBookServlet?method=saveOrUpdateBook" method="post"> -->
			<%-- <c:if test="${empty book }">
				<input type="hidden" name="method" value="saveBook">
			</c:if>
			<c:if test="${!empty book }">
				<input type="hidden" name="method" value="updateBook">
			</c:if> --%>
				<input type="hidden" name="id" value="${book.id }">
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="title" type="text" value="${book.title }"/></td>
						<td><input name="price" type="text" value="${book.price }"/></td>
						<td><input name="author" type="text" value="${book.author }"/></td>
						<td><input name="sales" type="text" value="${book.sales }"/></td>
						<td><input name="stock" type="text" value="${book.stock }"/></td>
						<td><input  type="submit" value="提交"/></td>
					</tr>	
					<tr>
						<td colspan="6"><div id="addPhoto">
							<div>
								 <img src="static/img/add.jpg" height="160" width="160" id="add"/>
								 <input type="file" name="imgPath" value=""/>
							</div>
						</div></td>
						
					</tr>	
				</table>
			</form>
			
	
		</div>
		
		<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>