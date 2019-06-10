<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="${baseUrlStatic}/css/common/layout.css" rel="stylesheet">
	<jsp:include page="../common/commonStatic.jsp"></jsp:include>
	<title>role</title>
</head>
<style>
	.search-button{
		margin-left: 16px;
	}
	.add-button{
		float: right;
	}
</style>
<body>
<div>
	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a href="javascript:void(0)">公告管理</a></li>
	</ul>
	<div class="search-area">
		<div class="input-group input-group-sm" style="width:100%">
			<button type="button" class="btn btn-primary btn-sm add-button" id="addRecord">添加公告</button>
		</div>
	</div>
	<div class="table-center">
		<form>
			<table class="table table-striped" id="mainTable">

			</table>
		</form>
	</div>
</div>
<script type="text/javascript" src="${baseUrlStatic}/js/system/Announcement.js"></script>
<script type="text/javascript" src="${baseUrlStatic}/js/common/commonFunc.js"></script>
</body>
</html>