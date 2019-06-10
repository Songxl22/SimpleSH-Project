<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="OA系统">
<link rel="shortcut icon" href="${baseUrlStatic}/icon/favicon.png">
<title>OA办公自动化系统登录</title>
<link rel="stylesheet" href="${baseUrlStatic}/bootstrap/css/bootstrap.css">
<link href="${baseUrlStatic}/css/system/login.css" rel="stylesheet">
</head>
<body onload="javascript:document.getElementById('userName').focus();">
<div class="container">
	<div class="row main">
		<div class="panel-heading">
			<div class="panel-title text-center">
				<h1 class="title">OA-System</h1>
				<hr />
			</div>
		</div>
		<div class="main-login main-center">
			<form class="form-horizontal" id="loginForm" method="post" action="#">

				<div class="form-group">
					<label class="cols-sm-2 control-label">用户名</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
							<input type="text" class="form-control" name="userName" id="userName"  placeholder="Enter your Username"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="cols-sm-2 control-label">密码</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock" aria-hidden="true"></i></span>
							<input type="password" class="form-control" name="userPass" id="userPass"  placeholder="Enter your Password"/>
						</div>
					</div>
				</div>

				<div class="form-group ">
					<button type="button" class="btn btn-primary btn-lg btn-block login-button" id="loginBtn">登录</button>
				</div>
			</form>
		</div>
	</div>
</div>
	<script type="text/javascript" src="${baseUrlStatic}/js/common/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${baseUrlStatic}/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="${baseUrlStatic}/js/common/commonFunc.js"></script>
	<script type="text/javascript" src="${baseUrlStatic}/js/system/login.js"></script>
</body>

</html>

