<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">

<title>登录页面</title>
</head>
<body>
				

								<a href="pages/user/regist.jsp">立即注册</a>
								<hr>
								<b></b>
								<span class="errorMsg">
								${empty msg?"请输入用户名和密码":msg} </span>
							<div class="form">
										<form action="UserServlet" method="post">
										<input type="hidden" name="method" value="login">
									<label>用户名称 </label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"  />
									<br />
									<br />
									<label>用户密码 </label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
</body>
</html>