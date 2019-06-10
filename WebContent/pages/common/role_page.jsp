<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 引用该分页jsp时，请包含在主页面的form表单内 -->
<%@ page language="java" pageEncoding="UTF-8" contentType="textml; charset=UTF-8"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<div class="module-head" style="height:45px;line-height:45px;">
	<span class="title" style="margin-left: 20px;">当前第${pageInfo.pageNumber}页，共 ${pageInfo.pageCount} 页， 总共 ${pageInfo.totalCount} 条记录</span>
	<ul class="pagination" style="float: right;margin: 8px 30px;">
<!-- 	页面跳转 -->
	<li><span style="border:0;margin:0;">	
	            第<input type="text"id="input" name="input" value="${pageInfo.pageNumber}" 
	            style="width:50px;height:20px;padding-left:20px">页</span>	    
	    <a href="#"
	    onclick="location.href='/system/role/getRole?page='+document.getElementById('input').value;">跳转</a>
	</li>
	<c:if test="${pageInfo.pageCount <= 1 }">  
			<li class="disabled"><a href="#">上一页</a></li>
			<li class="active"><a href="/system/role/getRole?page=1">1</a></li>
			<li class="disabled"><a href="#">下一页</a></li>
		</c:if>
		<c:if test="${pageInfo.pageCount >1 }">   
			<c:if test="${pageInfo.pageNumber == 1 }"> 
				<li class="disabled"><a href="#">上一页</a>
			</c:if>
			<c:if test="${pageInfo.pageNumber > 1 }"> 
				<li><a href="/system/role/getRole?page=${pageInfo.pageNumber-1}">上一页</a>
			</c:if>
<!-- 	根据总页数显示页码，最多5页 -->
			<c:set var="pageStart" value="1" />
			<c:set var="pageStop" value="${pageInfo.pageCount}" />
			<c:if test="${pageInfo.pageNumber + 2 >= pageInfo.pageCount && pageInfo.pageCount > 5}">
				<c:set var="pageStart" value="${pageInfo.pageCount - 4}" />
			</c:if>
			<c:if test="${pageInfo.pageNumber + 2 < pageInfo.pageCount && pageInfo.pageCount > 5}">
				<c:set var="pageStart" value="${pageInfo.pageNumber - 2}" />
				<c:set var="pageStop" value="${pageInfo.pageNumber + 2}" />
				<c:if test="${pageInfo.pageNumber < 3}">
					<c:set var="pageStart" value="1" />
					<c:set var="pageStop" value="5" />
				</c:if>
			</c:if>	
<!-- 	将判断得到的页码传到controller中 -->
			<c:forEach var ="iNum" begin="${pageStart}" end="${pageStop}" step="1">
		  		<c:if test="${pageInfo.pageNumber != iNum}">
		  			<li><a href="/system/role/getRole?page=${iNum}">${iNum}</a>
		  		</c:if>
		  		<c:if test="${pageInfo.pageNumber == iNum}">
					<li class="active"><a href="#">${iNum}</a>
		  		</c:if>
		    </c:forEach>	    
		    <c:if test="${pageInfo.pageNumber >= pageInfo.pageCount }">   
		    	<li class="disabled"><a href="#" onclick="return false;">下一页</a>
		    </c:if>
			<c:if test="${pageInfo.pageNumber < pageInfo.pageCount }"> 
				<li><a href="/system/role/getRole?page=${pageInfo.pageNumber+1}">下一页</a>
			</c:if>
		</c:if>
	</ul>
</div>
<script type="text/javascript">
 	var pageCount = "${pageInfo.pageCount}"; 
</script>
<script type="text/javascript" src="${baseUrlStatic}/js/common/page.js?ver=${version}"></script>