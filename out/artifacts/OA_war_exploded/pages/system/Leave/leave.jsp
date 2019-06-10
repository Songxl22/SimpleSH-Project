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
	<title>Leave</title>
</head>
<style>
	.search-button{
		margin-left: 16px;
	}
	.add-button{
		float: right;
	}
	.date-div{
		width:30px;
		height:30px;
		background-color: #eee;
		display: inline-block;
		text-align:center;
		vertical-align: middle;
		border: 1px solid #ccc;
	}
	.date-border{
		border-top-right-radius: 3px;
		border-bottom-right-radius: 3px;
	}
</style>
<body>
<div>
	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a href="javascript:void(0)">请假管理</a></li>
	</ul>
	<div class="search-area">
		<div class="input-group input-group-sm" style="width:100%;">
			<input type="text" class="form-control" placeholder="请假人" style="width: 150px" id="person">
			<select class="form-control" style="width:150px;margin-left: 16px" id="leave_type">
				<option value="">请选择请假类型</option>
				<option value="0">事假</option>
				<option value="1">病假</option>
				<option value="2">调休假</option>
			</select>
			<input type="text" class="form-control own-date" id="start_time" readonly style="width:180px;margin-left: 16px;">
			<div class="date-div" id="clearDate"><span class="glyphicon glyphicon-remove" style="line-height: 25px;cursor: pointer"></span></div>
			<div class="date-div date-border"><span class="glyphicon glyphicon-calendar" style="line-height: 25px;"></span></div>
			<button type="button" class="btn btn-primary btn-sm search-button" id="search">查询</button>
			<button type="button" class="btn btn-primary btn-sm add-button" id="addRecord">添加记录</button>
		</div>
	</div>
	<div class="table-center">
		<form>
			<table class="table table-striped" id="mainTable">

			</table>
		</form>
	</div>
	<%--弹出框--%>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal" data-backdrop="false" style="overflow: hidden">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="width:500px">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="modalLabel">添加会议记录</h4>
				</div>
				<div class="modal-body">
					<form id="leaveForm">
						<input type="hidden" id="leaveId" value="" name="leaveId">
						<div class="form-group">
							<label class="control-label">请假人:</label>
							<input type="text" class="form-control" id="applyName" name="applyName" style="width:90%;">
						</div>
						<div class="form-group">
							<label class="control-label">请假类型:</label>
							<select class="form-control" id="leaveType" name="leaveType" style="width:90%;">
								<option value="0">事假</option>
								<option value="1">病假</option>
								<option value="2">调休假</option>
							</select>
						</div>
						<div class="form-group">
							<label class="control-label">开始时间:</label>
							<div class="input-group" style="width:90%;">
								<input type="text" class="form-control own-date" id="startTime" name="startTime" readonly>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">结束时间:</label>
							<div class="input-group" style="width:90%;">
								<input type="text" class="form-control own-date" id="endTime" name="endTime" readonly>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">请假原因:</label>
							<input type="text" class="form-control" id="reason" name="reason" style="width:90%;">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="submit">确定</button>
				</div>
			</div>
		</div>
	</div>
	<%--审核弹窗--%>
	<div class="modal fade" id="verifyModal" tabindex="-1" role="dialog" aria-labelledby="myModal" data-backdrop="false" style="overflow: hidden">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="width:300px;height:170px">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="verifyModalLabel">请假记录审核</h4>
				</div>
				<br>
				<div class="modal-body" style="text-align: center">
					<input type="hidden" id="transferId" value="">
					<button type="button" class="btn btn-default" id="nopass">不通过</button>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-primary" id="pass">通过</button>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${baseUrlStatic}/js/system/leave.js"></script>
<script type="text/javascript" src="${baseUrlStatic}/js/common/commonFunc.js"></script>
</body>
</html>