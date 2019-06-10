<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/common/taglibs.jsp"%>
	<script type="text/javascript">
    function addTab(title, url){
    	if ($('#tt').tabs('exists', title)){
    		$('#tt').tabs('select', title);
    	} else {
    		var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
    		$('#tt').tabs('add',{
    			title:title,
    			content:content,
    			closable:true
    		});
    	}
    }
	</script>

<c:if test="${!empty sysUser}">
	<div id="lside" class="col-sm-3 col-md-2 sidebar" style="top: 57px!important;">
		<ul class="nav nav-sidebar menubar">
			<li class="article active" ><a href="/system//Conference/getConf" target="mainframe">会议管理</a></li>
			<li class="article" ><a href="/system/dept/getDept?value=dept" target="mainframe">部门管理</a></li>
			<li class="article" ><a href="/system/role/getRole" target="mainframe">角色管理</a></li>
			<li class="article" ><a href="/system/Announcement/getAnno" target="mainframe">公告管理</a></li>
			<li class="article" ><a href="/system/leave/getLeave" target="mainframe">请假管理</a></li>
			<li class="article" ><a href="/system//Conference/getConf" target="mainframe">用户管理</a></li>
			<li class="article" ><a href="/system//Conference/getConf" target="mainframe">任务管理</a></li>
			<li class="article" ><a href="/system/article" target="mainframe">ECharts</a></li>

	    </ul>

	</div>

</c:if>



