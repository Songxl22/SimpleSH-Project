<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="OA后台管理系统">
    <meta name="author" content="jack">
    <title>OA-System</title>
    <link rel="stylesheet" href="${baseUrlStatic}/bootstrap/css/bootstrap.css">
    <link href="${baseUrlStatic}/css/system/dashboard.css" rel="stylesheet">
     <style type="text/css">
		textarea {
			display: block;
		}
    </style>


  </head>
<body style="padding-top: 70px;">
	<jsp:include page="common/topSideBar.jsp" />
    <div class="container-fluid">
      <div class="row">
       	<jsp:include page="common/leftSideBar.jsp" />
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <div id="indexDiv">
       		  <div id="mainDiv">
				  <iframe id="mainframe" frameborder="0" width="100%" style="min-height:580px" scrolling="no" src="/system//Conference/getConf" name="mainframe" onload="autoFrame()"> </iframe>
			 
			  </div>
		  </div>  
        </div>
      </div>
    </div>          
   
    <jsp:include page="common/footerSideBar.jsp"/>

    <script type="text/javascript" src="${baseUrlStatic}/js/common/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${baseUrlStatic}/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" charset=UTF-8" src="${baseUrlStatic}/js/system/index.js"></script>
</body>
</html>
