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
<link rel="stylesheet" type="text/css"
	href="../../../../easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../../../../esayui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../../../../easyui/demo.css">
<style type="text/css">
textarea {
	display: block;
}
</style>
</head>
<script type="text/javascript">
	function checktext(){
		var subject = document.getElementById("username").value;
		if(subject==""){
			alert("请输入要检索的内容。")
			return false;
		}
	}
</script>
<body>
	<div class="easyui-tabs" style="width: auto; height: auto">
		<div class="listDiv" title="用户管理">
			<div class="sub-header">
				<span id="periodTitle" class="title h2">用户管理</span>
				<form action="/system/user/getuserEdit" method="post"
					style="display: inline; float: right;">
					<input type="hidden" name="add" value="add">
					<button id="newArticleBtn" class="btn btn-primary btn-xs"
						type="submit"
						style="float: right; margin-top: 4px; margin-right: 4px;">
						<span style="font-size: 15px;">添加用户</span>
					</button>
				</form>
				<button id="delUsersel" onclick="delUsersel()"
					class="btn btn-primary btn-xs" type="button"
					style="float: right; margin-top: 4px; margin-right: 4px;">
					<span style="font-size: 15px;">删除选中</span>
				</button>
				<form action="/system/user/usernameRetrieve" method="POST"
					onsubmit="return checktext()" target="mainframe">
					<button id="usernameRetrieve" class="btn btn-primary btn-xs"
						type="submit"
						style="float: right; margin-top: -29px; margin-right: 156px;">
						<span style="font-size: 15px;">检索</span>
					</button>
					<input type="text" placeholder="姓名/部门" id="username"
						name="username" class="form-control"
						style="float: right; width: 150px; margin-top: -32px; margin-right: 200px; display: inline;">
				</form>
			</div>
			<!-- 			<form id="userListForm" onclick="system/user"> -->
			<div class="table table-striped"
				style="margin-top: 33px; height: 400px">
				<table class="easyui-datagrid" id="user">
					<thead>
						<tr>
							<th field="ck" checkbox="true" style="width: 4%"></th>
							<th field="name2" class="text-center" style="width: 24%">员工号</th>
							<th field="name3" class="text-center" style="width: 24%">姓名</th>
							<th field="name4" class="text-center" style="width: 24%">所属部门</th>
							<th field="name5	" class="text-center" style="width: 24%">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="data" items="${user1}" varStatus="status">
							<tr>
								<td>${data.userid}</td>
								<td style="width: 25%;">${data.userid}</td>
								<td style="width: 25%;">${data.username}</td>
								<td style="whdth: 25%;">${data.userdept}</td>
								<td class="text-center" style="width: 21%;">

									<form action="/system/user/userSelect" method="post"
										style="display: inline">
										<input type="hidden" name="select" value="select" /> <input
											type="hidden" name="id" value="${data.userid}" /> <input
											type="submit" value="查看"
											style="background: #ffffff; border: none; color: #428bca" />
									</form>|
									<form action="/system/user/userUpdata" method="post"
										style="display: inline">
										<input type="hidden" name="edit" value="edit" /> <input
											type="hidden" name="id" value="${data.userid}" /> <input
											type="submit" value="修改"
											style="background: #ffffff; border: none; color: #428bca" />
									</form>| <input type=button value="删除"
									onclick="delUserById(${data.userid})"
									style="background: #ffffff; border: none; color: #428bca">
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<jsp:include page="/pages/common/page.jsp" />
		</div>
	</div>

	<script type="text/javascript"
		src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://cdn.bootcss.com/bootstr
		ap/3.2.0/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${baseUrlStatic}/js/common/commonFunc.js"></script>
	<script type="text/javascript"
		src="${baseUrlStatic}/kindeditor-4.1.7/kindeditor.js?ver=${version}"></script>
	<script type="text/javascript"
		src="${baseUrlStatic}/kindeditor-4.1.7/lang/zh_CN.js?ver=${version}"></script>
	<script type="text/javascript" src="${baseUrlStatic}/js/system/user.js"></script>
	<script type="text/javascript" src="../../../../easyui/jquery.min.js"></script>
	<script type="text/javascript"
		src="../../../../easyui/jquery.easyui.min.js"></script>
</body>
</html>