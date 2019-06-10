<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${baseUrlStatic}/icon/favicon.png">
    <title>OA首页</title>
    <!-- Bootstrap core CSS -->
    <link href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- 我们自己的css样式文件放在这里 -->
    <link href="${baseUrlStatic}/css/system/dashboard.css" rel="stylesheet">
     <style type="text/css">
		textarea {
			display: block;
		}
    </style>
  </head>
<body>
<body>
  	<div id="contentDiv" class="">
          <ul id="contentUl" class="nav nav-tabs" role="tablist">
			  <li role="presentation" class="active firstLi"><a href="#">角色管理</a></li>
		  </ul>
   		  <div id="listDiv" class="listDiv">
	          <div class="sub-header">
	          		<span id="periodTitle" class="title h2">添加角色</span>
	          		<button id="newArticleBtn" class="btn btn-primary btn-xs" type="button" 
	          		style="float: right; margin-top: 4px;margin-right:4px;" onclick="window.location='getRole'">
						<span style="font-size:15px;">返回</span>						
					</button>	          		
			        </div>					 
			  </div>			  
			  <form id="addform">
		          <div >
		           <table align="center">
		              <tr>
		                <td style="font-size:150%;padding:10px 10px 10px 10px">角色编号：</td>
		                <td><input id="roleID" name="roleID" type="text" size=30></td>
		              </tr>		             
		              <tr>
		                <td style="font-size:150%;padding:10px 10px 10px 10px">角色名称：</td>
		                <td><input id="roleName" name="roleName" type="text" size=30></td>
		              </tr>		              
		              <tr>
		                <td style="font-size:150%;padding:10px 10px 10px 10px">所属部门：</td>
		                <td><input  id="roleDescription" name="roleDescription" type="text" size=30></td>
		              </tr>		              
		           </table>
		          </div>
		          <div align="center">
		          <span class="pull-left" style="margin-left:450px">
		          <button  id="addrole" type="button" class="btn btn-primary btn-sm" style="padding:5px 20px 5px 20px;font-size:100%;background-color: #363630;" >提交</button>                            	            
                  </span>
                  <span class="pull-right" style="margin-right:450px">
                  <button  type="reset" class="btn btn-primary btn-sm"  style="padding:5px 20px 5px 20px;font-size:100%;background-color: #363630;">取消</button>                  	    		          
		         
		          </div>
		          
                
	         </form>   
	     </div>     
    </div>
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- 请首先引用jquery，再引用其他js文件 -->
    <!-- Placed at the end of the document so the pages load faster -->
<%--     <script type="text/javascript" src="${baseUrlStatic}/js/common/jquery-1.11.1.min.js"></script> --%>
    <script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${baseUrlStatic}/js/common/commonFunc.js"></script>
    <script type="text/javascript" src="${baseUrlStatic}/kindeditor-4.1.7/kindeditor.js?ver=${version}"></script>
    <script type="text/javascript" src="${baseUrlStatic}/kindeditor-4.1.7/lang/zh_CN.js?ver=${version}"></script>
    <script type="text/javascript" src="${baseUrlStatic}/js/system/blogArticle.js?ver=${version}"></script>
    <script type="text/javascript" src="${baseUrlStatic}/js/system/role.js?ver=${version}"></script>
  
  </body>
</body>
</html>