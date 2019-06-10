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

</style>
<body>
<div>
	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a href="javascript:void(0)">添加公告</a></li>
	</ul>
	<div class="table-center">
		<form id="annoForm">
			<input type="hidden" id="id" value="" name="id">
			<div class="form-group">
				<label class="control-label">公告主题:</label>
				<input type="text" class="form-control" id="theme" name="theme" style="width:90%;">
			</div>
			<div class="form-group">
				<label class="control-label">公告内容:</label>
				<script id="container" name="contents" type="text/plain">
				</script>
			</div>
            <button type="button" class="btn btn-default" id="cancel">取消</button>
            <button type="button" class="btn btn-primary" id="submit">确定</button>
		</form>
	</div>
</div>
<script type="text/javascript" src="${baseUrlStatic}/js/system/anno_add.js"></script>
<script type="text/javascript" src="${baseUrlStatic}/js/common/commonFunc.js"></script>
<script type="text/javascript" src="${baseUrlStatic}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${baseUrlStatic}/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="${baseUrlStatic}/ueditor/lang/zh-cn/zh-cn.js"></script>
</body>
</html>