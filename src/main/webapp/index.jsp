
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" isErrorPage="true"%>
<html>
<head>
<title>短消息平台</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css" />
	<script src="${pageContext.request.contextPath}/scripts/jquery.js" type="text/javascript" charset="UTF-8"></script>
	<script src="${pageContext.request.contextPath}/scripts/login.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
	<div id="loginTitle" class="png"></div>
	<div id="loginForm" class="userForm png">
		<dl>
			<div id="error" style="color:red"></div>
			<dt>用户名：</dt>
			<dd>
				<input type="text" name="name" id="name" onblur="queryUserByName(this.value)"/>
			</dd>
			<dt>密 码：</dt>
			<dd>
				<input type="password" name="pwd" id="pwd"/>
			</dd>
			<dt>验证码：</dt>
			<dd>
				<input type="text" name="code" id="code" onblur="code()"/>
			</dd>
			<dd>
				<a href="#"><img src="code.jsp" id="imgCode"/></a><a href="javascript:refresh()" id="refresh">换一张</a>
			</dd>

		</dl>
		<div class="buttons">
			<input class="btn-login png" type="button" onclick="login()" name="submit" value=" " />
			<a href="register.jsp"><input class="btn-reg png" type="button" name="register" value=" " /></a>
		</div>
	</div>
	
	
</body>
</html>








