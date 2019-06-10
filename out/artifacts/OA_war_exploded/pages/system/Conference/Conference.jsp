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
<title>Conference</title>
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
        <li role="presentation" class="active"><a href="javascript:void(0)">会议管理</a></li>
    </ul>
    <div class="search-area">
        <div class="input-group input-group-sm" style="width:100%">
            <input type="text" class="form-control" placeholder="会议主题" style="width: 150px" id="theme">
            <select class="form-control" style="width:150px;margin-left: 16px" id="state">
                <option value="">请选择会议状态</option>
                <option value="0">未开始</option>
                <option value="1">已结束</option>
            </select>
            <button type="button" class="btn btn-primary btn-sm search-button" id="search">查询</button>
            <button type="button" class="btn btn-primary btn-sm add-button" id="addRecord">添加会议记录</button>
        </div>
    </div>
    <div class="table-center">
        <form>
            <table class="table table-striped" id="mainTable">

            </table>
        </form>
    </div>
    <%--弹出框--%>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal" data-backdrop="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content" style="width:500px">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="modalLabel">添加会议记录</h4>
                </div>
                <div class="modal-body">
                    <form id="confForm">
                        <input type="hidden" id="id" value="" name="id">
                        <div class="form-group">
                            <label class="control-label">会议主题:</label>
                            <input type="text" class="form-control" id="subject" name="subject" style="width:90%;">
                        </div>
                        <div class="form-group">
                            <label class="control-label">会议地点:</label>
                            <input class="form-control" id="site" name="site" style="width:90%;">
                        </div>
                        <div class="form-group">
                            <label class="control-label">会议时间:</label>
                            <div class="input-group" style="width:90%;">
                                <input type="text" class="form-control" id="hour" name="hour" readonly>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label">组织人:</label>
                            <input type="text" class="form-control" id="person" name="person" style="width:90%;">
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
</div>
<script type="text/javascript" src="${baseUrlStatic}/js/system/Conf.js"></script>
<script type="text/javascript" src="${baseUrlStatic}/js/common/commonFunc.js"></script>
</body>
</html>