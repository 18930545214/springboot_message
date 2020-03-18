<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" isErrorPage="true"%>
<html>
<head>
<title>读短消息</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css"/>
</head>
<body>
	<div id="main">
		<div class="mainbox">
			<div class="title readMessage png"></div>
			<%@include file="menu.jsp"%>
			<div class="content">
				<div class="message">
					<div class="tmenu">
						<ul class="clearfix">
							<li>题目：${msg.title}</li>
							<li>来自：${msg.sendUser.name}</li>
							<li>时间：${msg.msg_Create_Date}</li>
						</ul>
					</div>
					<div class="view">
						<p>${msg.msgContent}</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
