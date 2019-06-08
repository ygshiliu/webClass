<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/base.jsp" %>
<meta charset="UTF-8">
<title>尚硅谷会员登录页面</title>
<!-- 导入jquery -->
<script type="text/javascript">
	$(function(){
		//给提交按钮绑定单击事件
		$("#sub_btn").click(function(){
			//对用户名做校验
			var reg = /^[a-z0-9_-]{3,16}$/;
			var username=$("[name='username']").val();
			if(!reg.test(username)){
				alert("您输入的用户名不符合要求，请重新输入 ...")
				return false;
			}
			
			//对密码做校验
			reg = /^[a-z0-9_-]{6,18}$/;
			var password = $("[name='password']").val();
			if(!reg.test(password)){
				alert("您输入的密码不符合要求，请重新输入 ...")
				return false;
			}
			
			
			
			
		})
		
	})
	

</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								${msg==null?"请输入用户名和密码":msg }
								
							</div>
							<div class="form">
								<form action="UserServlet">
									<input type="hidden" name="method" value="login">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" value="${param.username }"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>