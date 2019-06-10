 <%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@ include file="/pages/common/taglibs.jsp"%>

 <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid" style="height: 56px;line-height: 56px;font-size: 14px">
        <div class="navbar-header">
          <a class="navbar-brand" href="/system" style="margin-left:6px;line-height: 42px;font-size: 24px">
			<span class="glyphicon glyphicon-home" style="color:white"></span>&nbsp;
          	<c:if test="${!empty sysUser}">
          		系统管理
			</c:if>
          </a>
        </div>
        
        <div class="navbar-collapse collapse">
		  <div class="pull-right">
	          <c:if test="${!empty sysUser}">
	          	  <p style="padding-top: 10px;color: #777;">
	          	  <%--<span style="color: white">
	          	  <span id="Cdd"></span>
	          	  <span id="Cdh"></span>
	          	  <span id="Cdm"></span>
	          	  <span id="Cds"></span>
	          	  </span>&nbsp;&nbsp;--%>
	          	 <span id="clock" style="color:  #d1d1e0"></span>&nbsp;&nbsp;&nbsp;
	          	  <span class="glyphicon glyphicon-user" ></span> 欢迎您，
		          	<a href="#" class="navbar-link">${sysUser.userName}</a>&nbsp;&nbsp;
		          	<button id="sysAdminLogout" type="button" class="btn btn-danger btn-sm logout" onfocus="this.blur()">退出</button>
		          </p>
			  </c:if>
		  </div>
        </div>
      </div>
    </div>
<script type="text/javascript" src="${baseUrlStatic}/js/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${baseUrlStatic}/js/system/index.js?ver=${version}"></script>
