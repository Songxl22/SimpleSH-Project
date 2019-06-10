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
	function checkid() {
		var subject = document.getElementById("userid").value;
		if (subject == "" || isNaN(subject)) {
			$("#useridError").show();
			flag = false;
		} else {
			$("#useridError").hide();
			flag = true;
		}
		return flag;
	}
	function checkempno() {
		var subject = document.getElementById("userempno").value;
		if (subject == "" || isNaN(subject)) {
			$("#userempnoError").show();
			flag = false;
		} else {
			$("#userempnoError").hide();
			flag = true;
		}
		return flag;
	}
	function checkname() {
		var subject = document.getElementById("username").value;
		if (subject == "" || subject.length >= 20) {
			$("#usernameError").show();
			flag = false;
		} else {
			$("#usernameError").hide();
			flag = true;
		}
		return flag;
	}
	function checkpass() {
		var subject = document.getElementById("userpass").value;
		if (subject == "" || subject.length >= 20 || subject.length <= 5
				|| subject.match(/[^A-Za-z0-9]/ig)) {
			$("#userpassError").show();
			flag = false;
		} else {
			$("#userpassError").hide();
			flag = true;
		}
		return flag;
	}
	function checkdept() {
		var subject = document.getElementById("userdept").value;
		if (subject == "") {
			$("#userdeptError").show();
			flag = false;
		} else {
			$("#userdeptError").hide();
			flag = true;
		}
		return flag;
	}
	function checkemail() {
		var regemail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
		var subject = document.getElementById("useremail").value;
		if (!regemail.test(subject)) {
			$("#useremailError").show();
			flag = false;
		} else {
			$("#useremailError").hide();
			flag = true;
		}
		return flag;
	}
	function checktel() {
		var subject = document.getElementById("usertel").value;
		if (subject == "" || isNaN(subject)) {
			$("#usertelError").show();
			flag = false;
		} else {
			$("#usertelError").hide();
			flag = true;
		}
		return flag;
	}
	function checkidnum() {
		var idnum = /^[0-9]+$/ || /^[0-9]+x+$/;
		var subject = document.getElementById("useridnum").value;
		if (!idnum.test(subject) || subject.length != 18) {
			$("#useridnumError").show();
			flag = false;
		} else {
			$("#useridnumError").hide();
			flag = true;
		}
		return flag;
	}
</script>
<body>
	<ul id="contentUl" class="nav nav-tabs" role="tablist">
		<li role="presentation" class="active firstLi"><a href="#">用户管理</a></li>
	</ul>
	<div id="listDiv" class="listDiv">
		<!-- 			新建 -->
		<c:if test="${ edituser == 'add'}">
			<div class="sub-header">
				<span id="periodTitle" class="title h2">编辑详情</span>
				<button class="btn btn-primary btn-xs" type="button"
					style="float: right; margin-top: 4px; margin-left: 4px"
					onclick="location.href='javascript:history.go(-1);'">
					<span style="font-size: 15px;">返回</span>
				</button>
			</div>
			<form id="userEditForm" name="userEditForm" onsubmit="return check()" method="POST">
				<div style="float: left; margin-top: 4px; margin-left: 300px">
					<table>
						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">用户id：</td>
							<td><input type="text" id="userid" name="userid" size="30"
								onblur="checkid()"></td>
							<td id="useridError" style="display: none"><font color="red"
								size="-1">用户ID不为空且是数字！</font></td>
						</tr>
						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">用户号：</td>
							<td><input type="text" id="userempno" name="userempno"
								onblur="checkempno()" size="30"></td>
							<td id="userempnoError" style="display: none"><font
								color="red" size="-1">用户号不为空且是数字！ </font></td>
						</tr>
						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">用户名：</td>
							<td><input type="text" id="username" name="username"
								onblur="checkname()" size="30"></td>
							<td id="usernameError" style="display: none"><font
								color="red" size="-1">用户名长度为1-20！ </font></td>
						</tr>
						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">用户密码：</td>
							<td><input type="password" id="userpass" name="userpass"
								onblur="checkpass()" size="30"></td>
							<td id="userpassError" style="display: none"><font
								color="red" size="-1">用户密码为字母数字组合长度为6-20！</font></td>
						</tr>

						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">职位：</td>
							<td><input type="text" id="userposition" name="userposition"
								size="30"></td>
						</tr>
						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">所在部门：</td>
							<td><input type="text" id="userdept" name="userdept"
								onblur="checkdept()" size="30"></td>
							<td id="userdeptError" style="display: none"><font
								color="red" size="-1">部门不能为空！</font></td>
						</tr>

						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">性别：</td>
							<td><select name="usersex" id="usersex">
									<option value="">请选择</option>
									<option value="男">男</option>
									<option value="女">女</option>
							</select></td>
						</tr>
						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">民族：</td>
							<td><input type="text" id="usernative" name="usernative"
								size="30"></td>
						</tr>

						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">邮箱：</td>
							<td><input type="text" id="useremail" name="useremail"
								onblur="checkemail()" size="30"></td>
							<td id="useremailError" style="display: none"><font
								color="red" size="-1">邮箱格式错误！</font></td>
						</tr>
						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">联系方式：</td>
							<td><input type="text" id="usertel" name="usertel"
								onblur="checktel()" size="30"></td>
							<td id="usertelError" style="display: none"><font
								color="red" size="-1">输入正确的联系方式！</font></td>
						</tr>

						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">学历：</td>
							<td><select name="userquan" id="userquan">
									<option value="">请选择</option>
									<option value="初中及以下">初中及以下</option>
									<option value="高中/中专">高中/中专</option>
									<option value="专科">专科</option>
									<option value="本科">本科</option>
									<option value="硕士及以上">硕士及以上</option>
							</select></td>
						</tr>
						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">籍贯：</td>
							<td><input type="text" id="usernativeplace"
								name="usernativeplace" size="30"></td>
						</tr>

						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">住址：</td>
							<td><input type="text" id="useraddress" name="useraddress"
								size="30"></td>
						</tr>
						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">身份证号：</td>
							<td><input type="text" id="useridnum" name="useridnum"
								onblur="checkidnum()" size="30"></td>
							<td id="useridnumError" style="display: none"><font
								color="red" size="-1">身份证号错误！</font></td>
						</tr>

						<tr>
							<td style="font-size: 120%; padding: 10px 10px 10px 10px">政治面貌：</td>
							<td><input type="text" id="userpols" name="userpols"
								size="30"></td>
						</tr>
					</table>
					<button  id="userAddBtn" onclick="return check()"
						class="btn btn-primary btn-xs" type="button"
						style="margin-top: 4px; margin-left: 150px">
						<span style="font-size: 15px;">保存</span>
					</button>
					<button type="reset" class="btn btn-primary btn-xs"
						style="margin-top: 4px; margin-left: 4px">
						<span style="font-size: 15px;">取消</span>
					</button>
				</div>
			</form>
		</c:if>
		<!-- 		           查看   -->
		<c:if test="${ edituser == 'select'}">
			<div class="sub-header">
				<span id="periodTitle" class="title h2">查看详情</span>
				<button class="btn btn-primary btn-xs" type="button"
					style="float: right; margin-top: 4px; margin-left: 4px"
					onclick="location.href='javascript:history.go(-1);'">
					<span style="font-size: 15px;">返回</span>
				</button>
			</div>
			<br>
			<table align="center" id="selectuser">
				<c:forEach var="data" items="${updata}" varStatus="status">

					<tr>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">用户id:</td>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">${data.userid}</td>
					</tr>

					<tr>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">用户号：</td>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">${data.userempno}</td>

					</tr>

					<tr>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">用户名:</td>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">${data.username}</td>
					</tr>


					<tr>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">职位：</td>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">${data.userposition}</td>
					</tr>

					<tr>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">所在部门:</td>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">${data.userdept}</td>
					</tr>


					<tr>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">性别：</td>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">${data.usersex}</td>
					</tr>

					<tr>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">民族：</td>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">${data.usernative}</td>

					</tr>

					<tr>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">邮箱：</td>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">${data.useremail}</td>
					</tr>

					<tr>

						<td style="font-size: 120%; padding: 10px 10px 10px 10px">联系方式：</td>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">${data.usertel}</td>

					</tr>

					<tr>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">学历：</td>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">${data.userquan}</td>
					</tr>

					<tr>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">籍贯：</td>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">${data.usernativeplace}</td>

					</tr>

					<tr>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">住址：</td>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">${data.useraddress}</td>
					</tr>

					<tr>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">身份证号：</td>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">${data.useridnum}</td>
					</tr>

					<tr>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">政治面貌：</td>
						<td style="font-size: 120%; padding: 10px 10px 10px 10px">${data.userpols}</td>

					</tr>
					<tr align="center">
						<td style="font-size: 100%; padding: 10px 10px 10px 10px"
							align="center">
							<form action="/system/user/userUpdata" method="post"
								style="display: inline">
								<input type="hidden" name="edit" value="edit" /> <input
									type="hidden" name="id" value="${data.userid}" /> <input
									type="submit" value="修改信息" class="btn btn-primary btn-xs"
									style="background: #428bca; color: #ffffff" />
							</form>
						</td>
						<td style="font-size: 100%; padding: 10px 10px 10px 10px"
							align="center">
							<form action="/system/user/userPassUpdata" method="post"
								style="display: inline">
								<input type="hidden" name="edit" value="edit" /> <input
									type="hidden" name="id" value="${data.userid}" /> <input
									type="submit" value="修改密码" class="btn btn-primary btn-xs"
									style="background: #428bca; color: #ffffff" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<!-- 			更改 -->
		<c:if test="${ edituser == 'edit'}">
			<div class="sub-header">
				<span id="periodTitle" class="title h2">编辑详情</span>
				<button class="btn btn-primary btn-xs" type="button"
					style="float: right; margin-top: 4px; margin-left: 4px"
					onclick="location.href='javascript:history.go(-1);'">
					<span style="font-size: 15px;">返回</span>
				</button>
			</div>
			<form id="userEditForm" action="deluserById(${data.userid})">
				<br>
				<div style="float: left; margin-top: 4px; margin-left: 300px">
					<table>
						<c:forEach var="data" items="${updata}" varStatus="status">

							<tr>
								<td style="font-size: 120%; padding: 10px 10px 10px 10px">用户id:</td>
								<td><input size="30" type="hidden" id="userid"
									name="userid" readOnly value="${data.userid}">${data.userid}</td>
							</tr>
							<tr>
								<td style="font-size: 120%; padding: 10px 10px 10px 10px">用户号：</td>
								<td><input type="hidden" id="userempno" name="userempno"
									size="30" value="${data.userempno}">${data.userempno}</td>
							</tr>
							<tr>
								<td style="font-size: 120%; padding: 10px 10px 10px 10px">用户名:</td>
								<td><input size="30" type="hidden" id="username"
									name="username" value="${data.username}">${data.username}</td>
							</tr>
							<tr>
								<!-- 							<td style="font-size: 120%; padding: 10px 10px 10px 10px">用户密码：</td> -->
								<td><input type="hidden" id="userpass" name="userpass"
									size="30" value="${data.userpass}"></td>
							</tr>
							<tr>
								<td style="font-size: 120%; padding: 10px 10px 10px 10px">职位：</td>
								<td><input type="text" id="userposition"
									name="userposition" size="30" value="${data.userposition}"></td>
							</tr>

							<tr>
								<td style="font-size: 120%; padding: 10px 10px 10px 10px">所在部门：</td>
								<td><input type="text" id="userdept" name="userdept"
									onblur="checkdept()" size="30" value="${data.userdept }"></td>
								<td id="userdeptError" style="display: none"><font
									color="red" size="-1">部门不能为空！</font></td>
							</tr>

							<tr>
								<td style="font-size: 120%; padding: 10px 10px 10px 10px">性别：</td>
								<td>
									<select name="usersex" id="usersex" >
									<option value="${data.usersex}">${data.usersex}</option>
									<option value="男">男</option>
									<option value="女">女</option>
							</select></td>
							</tr>
							<tr>
								<td style="font-size: 120%; padding: 10px 10px 10px 10px">民族：</td>
								<td><input type="text" id="usernative" name="usernative"
									size="30" value="${data.usernative}"></td>
							</tr>

							<tr>
								<td style="font-size: 120%; padding: 10px 10px 10px 10px">邮箱：</td>
								<td><input type="text" id="useremail" name="useremail"
									onblur="checkemail()" size="30" value="${data.useremail }"></td>
								<td id="useremailError" style="display: none"><font
									color="red" size="-1">邮箱格式错误！</font></td>
							</tr>
							<tr>
								<td style="font-size: 120%; padding: 10px 10px 10px 10px">联系方式：</td>
								<td><input type="text" id="usertel" name="usertel"
									onblur="checktel()" size="30"value="${data.usertel }"></td>
								<td id="usertelError" style="display: none"><font
									color="red" size="-1">输入正确的联系方式！</font></td>
							</tr>

							<tr>
								<td style="font-size: 120%; padding: 10px 10px 10px 10px">学历：</td>
								<td>
									<select name="userquan" id="userquan">
									<option value="${data.userquan}">${data.userquan}</option>
									<option value="初中及以下">初中及以下</option>
									<option value="高中/中专">高中/中专</option>
									<option value="专科">专科</option>
									<option value="本科">本科</option>
									<option value="硕士及以上">硕士及以上</option>
							</select></td>
							</tr>
							<tr>
								<td style="font-size: 120%; padding: 10px 10px 10px 10px">籍贯：</td>
								<td><input type="text" id="usernativeplace"
									name="usernativeplace" size="30"
									value="${data.usernativeplace}"></td>
							</tr>

							<tr>
								<td style="font-size: 120%; padding: 10px 10px 10px 10px">住址：</td>
								<td><input type="text" id="useraddress" name="useraddress"
									size="30" value="${data.useraddress}"></td>
							</tr>
							<tr>
								<td style="font-size: 120%; padding: 10px 10px 10px 10px">身份证号：</td>
								<td><input type="text" id="useridnum" name="useridnum"
									onblur="checkidnum()" size="30" value="${data.useridnum }"></td>
								<td id="useridnumError" style="display: none"><font
									color="red" size="-1">身份证号错误！</font></td>
							</tr>

							<tr>
								<td style="font-size: 120%; padding: 10px 10px 10px 10px">政治面貌：</td>
								<td><input type="text" id="userpols" name="userpols"
									size="30" value="${data.userpols}"></td>
							</tr>
						</c:forEach>
					</table>
					<button id="updata" class="btn btn-primary btn-xs" type="button"
						style="margin-top: 4px; margin-left: 150px"
						onclick="retuen check()" style="margin-top: 4px;">
						<span style="font-size: 15px;">保存</span>
					</button>
					<button type="reset" class="btn btn-primary btn-xs"
						style="margin-top: 4px; margin-left: 4px">
						<span style="font-size: 15px;">取消</span>
					</button>
				</div>
			</form>
		</c:if>
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
	<script type="text/javascript"
		src="${baseUrlStatic}/js/system/user.js?ver=${version}"></script>
</body>
</html>
