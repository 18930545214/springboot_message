
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" isErrorPage="true"%>
<html>
<head>
<title>海文 在线短信平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
	<script src="${pageContext.request.contextPath}/scripts/alertify.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/scripts/jquery.js" type="text/javascript"></script>
	<script>
		var $name, $pwd, $affirm, $email, $error;
		/**
		 * 是否验证通过
		 */
		function validate() {
			$name = $("#name");
			$pwd = $("#pwd");
			$affirm = $("#affirm");
			$email = $("#email");
			$error = $("#error");
			if ($name.val() == "") {
				$error.css("color", "red").html("用户名不能为空");
				return false;//不用提交表单
			}else {
				return queryUserByName();
			}
			if ($pwd.val() == "") {
				$error.css("color", "red").html("密码不能为空");
				return false;//不用提交表单
			}else {
				return true;
			}
			if ($affirm.val() == "") {
				$error.css("color", "red").html("确认密码不能为空");
				return false;//不用提交表单
			}else {
				return true;
			}

			if ($pwd.val() != $affirm.val()) {
				$error.css("color", "red").html("两次密码不一致");
				return false;//不用提交表单
			}else {
				return true;
			}
			if ($email.val() == "") {
				$error.css("color", "red").html("邮箱不能为空");
				return false;//不用提交表单
			}else {
				return true;
			}
			var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
			if (reg.test($email.val()) == false) {
				$error.css("color", "red").html("邮箱格式不正确");
				return false;
			}else {
				return true;
			}
			return false;
		}
		function register() {
			if (validate()){
				$.ajaxSettings.async = false;
				$.post("${pageContext.request.contextPath}/register", {
					"name": $("#name").val(),
					"pwd": $("#pwd").val(),
					"email": $("#email").val()
				}, function (data) {
					$("#error").html(data.info);
				})
			}
		}
		function queryUserByName() {
			var name = $("#name").val();
			var flag = true;
			$.ajaxSettings.async = false;
			$.get("queryUserByName", {
				"name": name
			}, function (data) {
				if (!data.info) {
					flag = false;
					$("#error").html("此用户名已经注册").css("color", "red");
				} else {
					$("#error").html("此用户名可用").css("color", "green");
				}
			},"json");
			return flag;

		}
	</script>
</head>

<body>
	<div id="regTitle" class="png"></div>
	<div id="regForm" class="userForm png">

		<dl>
			<div id="error" style="color:red"></div>
			<dt>用 户 名：</dt>
			<dd>
				<input type="text" name="name" id="name" onblur="queryUserByName()"/>
			</dd>
			<dt>密 码：</dt>
			<dd>
				<input type="password" name="pwd" id="pwd" />
			</dd>
			<dt>确认密码：</dt>
			<dd>
				<input type="password" name="affirm" id="affirm" />
			</dd>
			<dt>邮 箱：</dt>
			<dd>
				<input type="text" name="email" id="email" />
			</dd>
		</dl>
		<div class="buttons">
			<input class="btn-reg png" type="button" name="register" value=" " id="register" onclick="register()"/><input
				class="btn-reset png" type="reset" name="reset" value=" " />
		</div>
		<div class="goback">
			<a href="index.jsp" class="png">返回登录页</a>
		</div>
	</div>
</body>
</html>
