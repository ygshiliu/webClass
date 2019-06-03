<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/base.jsp" %>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
<!-- 导入jquery -->
<script type="text/javascript">
	$(function(){
		$("#sub_btn").click(function(){
			
			//获取用户名、密码、确认密码、邮箱、验证码信息
			var username = $("[name='username']").val();
			var password = $("[name='password']").val();
			var repwd = $("[name='repwd']").val();
			var email = $("[name='email']").val();
			var code = $("[name='code']").val();
			
			//验证处理
			var nameReg =  /^[a-z0-9_-]{3,16}$/;
			if(!nameReg.test(username)){
				alert("您输入的用户名不符合要求，请重新输入 ...")
				return false;
			}
			
			var pwdReg = /^[a-z0-9_-]{6,18}$/;
			if(!pwdReg.test(password)){
				alert("您输入的密码不符合要求，请重新输入 ...")
				return false;
			}
			
			if(password!=repwd){
				alert("两次密码设置不一致，请重新输入 ...")
				return false;
			}
			
			var emailReg= /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!emailReg.test(email)){
				alert("邮箱格式不正确，请重新输入 ...")
				return false;
			}
			
			if(code==""){
				alert("验证码不能为空 ...")
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
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<%
									String msg =(String)request.getAttribute("msg");
									if(msg==null){
								%>
								<span class="errorMsg"></span>
								<%
									}else{
								%>
								<span class="errorMsg"><%=msg %></span>
								<%
									}
								%>
							</div>
							<div class="form">
								<form action="UserServlet">
								<input type="hidden" name="method" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" value="<%=request.getParameter("username")==null?"":request.getParameter("username") %>" name="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password"  />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" value="<%=request.getParameter("email")==null?"":request.getParameter("email") %>"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
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