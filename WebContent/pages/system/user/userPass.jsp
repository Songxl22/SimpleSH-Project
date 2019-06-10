<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="coding云博客首页，作为一个java程序员，coding云希望将自己懂得技术，包含但不限于nginx，tomcat，spring mvc，ssh等分享给大家。">
<meta name="keywords"
	content="coding云,coding,java网站,spring mvc,阿里云,建站,java web网站,系统演示,java做的网站" />
<meta name="author" content="jack">
<link rel="shortcut icon" href="${baseUrlStatic}/icon/favicon.png">
<title>用户管理</title>
<!-- Bootstrap core CSS -->
<link
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<!-- 我们自己的css样式文件放在这里 -->
<link href="${baseUrlStatic}/css/system/dashboard.css" rel="stylesheet">
<style type="text/css">
textarea {
	display: block;
}
</style>
</head>
<script type="text/javascript">
	function checkpassword() {
		var subject = document.getElementById("userpass").value;
		if (subject == "" || subject.length >= 20 || subject.length <= 5
				|| subject.match(/[^A-Za-z0-9]/ig)) {
			$("#userpasswordError").show();
			flag = false;
		} else {
			$("#userpasswordError").hide();
			flag = true;
		}
		return flag;
	}
	function checknewpass() {
		var subject = document.getElementById("newpass").value;
		if (subject == "" || subject.length >= 20 || subject.length <= 5
				|| subject.match(/[^A-Za-z0-9]/ig)) {
			$("#newpassError").show();
			flag = false;
		} else {
			$("#newpassError").hide();
			flag = true;
		}
		return flag;
	}
	function checknewpass1() {
		var passA = document.getElementById("newpass").value;
		var passB = document.getElementById("newpass1").value;
		if (passB != passA) {
			$("#newpass1Error").show();
			flag = false;
		} else {
			$("#newpass1Error").hide();
			flag = true;
		}
		return flag;
	}
</script>
<body>
	<div id="contentDiv" class="">
		<ul id="contentUl" class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active firstLi"><a href="#">用户管理</a></li>
		</ul>
		<div id="listDiv" class="listDiv">
			<div class="sub-header">
				<span id="periodTitle" class="title h2">修改密码</span>
				<button class="btn btn-primary btn-xs" type="button"
					style="float: right; margin-top: 4px; margin-left: 4px"
					onclick="location.href='javascript:history.go(-1);'">
					<span style="font-size: 15px;">返回</span>
				</button>

				<form id="userPassForm" class="form-vertical" action="/system/user"
					method="POST">
					<div style="float: left; margin-top: 4px; margin-left: 300px">
						<table>
							<c:forEach var="data" items="${userid}" varStatus="status">
								<tr>
									<td><input type="hidden" id="userid" name="userid"
										value="${data.userid}"></td>

									<td><input type="hidden" id="userempno" name="userempno"
										size="30" value="${data.userempno}"></td>

									<td><input type="hidden" id="username" name="username"
										value="${data.username}"></td>

									<td><input type="hidden" id="userposition"
										name="userposition" size="30" value="${data.userposition}"></td>

									<td><input size="30" type="hidden" id="userdept"
										name="userdept" value="${data.userdept}"></td>

									<td><input type="hidden" id="usersex" name="usersex"
										size="30" value="${data.usersex}"></td>

									<td><input type="hidden" id="usernative" name="usernative"
										size="30" value="${data.usernative}"></td>

									<td><input type="hidden" id="useremail" name="useremail"
										size="30" value="${data.useremail}"></td>

									<td><input type="hidden" id="usertel" name="usertel"
										size="30" value="${data.usertel}"></td>

									<td><input type="hidden" id="userquan" name="userquan"
										size="30" value="${data.userquan}"></td>

									<td><input type="hidden" id="usernativeplace"
										name="usernativeplace" size="30"
										value="${data.usernativeplace}"></td>

									<td><input type="hidden" id="useraddress"
										name="useraddress" size="30" value="${data.useraddress}"></td>

									<td><input type="hidden" id="useridnum" name="useridnum"
										size="30" value="${data.useridnum}"></td>

									<td><input type="hidden" id="userpols" name="userpols"
										size="30" value="${data.userpols}"></td>
								</tr>
							</c:forEach>
							<tr>
								<td style="font-size: 150%; padding: 10px 10px 10px 10px">请输入密码</td>
								<td><input type="password" name="userpass" id="userpass"
									onblur="checkpassword()"></td>
								<td id="userpasswordError" style="display: none"><font
									color="red" size="-1">用户密码为字母数字组合长度为6-20！</font></td>
							</tr>
							<tr>
								<td style="font-size: 150%; padding: 10px 10px 10px 10px">输入新密码:</td>
								<td><input id="newpass" name="newpass" type="password"
									onblur="checknewpass()" /></td>
								<td id="newpassError" style="display: none"><font
									color="red" size="-1">新密码为字母数字组合长度为6-20！</font></td>
							</tr>
							<tr>
								<td style="font-size: 150%; padding: 10px 10px 10px 10px">再输入一次：</td>
								<td><input id="newpass1" name="newpass1" type="password"
									onblur="checknewpass1()" /></td>
								<td id="newpass1Error" style="display: none"><font
									color="red" size="-1">两次输入不一样！</font></td>
							</tr>
						</table>
						<br>
						<button class="btn btn-primary btn-xs" id="passcheck"
							onclick="return ckpwd" type="button"
							style="margin-top: 4px; margin-left: 150px">
							<span style="font-size: 15px;">提 交</span>
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- 请首先引用jquery，再引用其他js文件 -->
	<!-- Placed at the end of the document so the pages load faster -->
	<%--     <script type="text/javascript" src="${baseUrlStatic}/js/common/jquery-1.11.1.min.js"></script> --%>
	<script type="text/javascript"
		src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${baseUrlStatic}/js/common/commonFunc.js"></script>
	<script type="text/javascript"
		src="${baseUrlStatic}/kindeditor-4.1.7/kindeditor.js?ver=${version}"></script>
	<script type="text/javascript"
		src="${baseUrlStatic}/kindeditor-4.1.7/lang/zh_CN.js?ver=${version}"></script>
	<script type="text/javascript" src="${baseUrlStatic}/js/system/user.js"></script>
</body>
</html>
