<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
.img {
	border: 1px solid;
	width: 100px;
	height: 100px;
}
</style>



<base
	href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
<title>登录成功</title>
</head>
<body>

	<h1>登录成功</h1>

	<a href="UserServlet?method=logout">注销</a>
	<br>

	<c:choose>
		<c:when test="${empty user.headPath}">
			<form action="UserServlet?method=upHead" method="post"
				enctype="multipart/form-data">
				上传头像：<input type="file" name="head"> <input type="submit"
					value="确定">
			</form>
		</c:when>
		<c:otherwise>
			<div class="img">
				<img src="${user.headPath}">
			</div>
		</c:otherwise>


	</c:choose>



	<a href="pages/user/info.jsp">获取用户信息</a>
	<br>

	<a href="UserServlet?method=restrict">看看用户有没有过期</a>
</body>
</html>