<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<title>注册页面</title>
<script type="text/javascript">

$(function(){
	
	$("#sub_btn").click(function(){
		var username=$(".itxt[name='username']").val();
		var password=$(".itxt[name='password']").val();
		var repwd=$(".itxt[name='repwd']").val();
		var email=$(".itxt[name='email']").val();
		var code=$("#code").val();
		
		var reg_username=/^[a-z0-9_]{5,16}$/;
		var reg_password=/^[a-z0-9_-]{6,18}$/;
		var reg_email=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		
		
		if(!reg_username.test(username)){
			$(".errorMsg").text("用户名格式错误");
			return false;
		}
		if(!reg_password.test(password)){
			$(".errorMsg").text("密码格式错误");
			return false;
		}
		if(password!=repwd){
			$(".errorMsg").text("两次密码输入不一致");
			return false;
		}
		if(!reg_email.test(email)){
			$(".errorMsg").text("邮箱格式错误");
			return false;
		}
	
	});
	

	
	
});
</script>
</head>
<body>

				
				
								<h1>注册</h1>
								<span class="errorMsg">${empty msg?"":msg}</span>
								<form action="UserServlet" method="post">
								<input type="hidden" name="method" value="regist">
									<label>用户名称：</label>
									<input  type="text"  name="username" id="username" value="${param.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password"  name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password"  name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text"  name="email" id="email" value="${param.email }"/>
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
								</form>
							
</body>
</html>