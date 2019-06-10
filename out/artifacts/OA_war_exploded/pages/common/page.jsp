<!-- 引用该分页jsp时，请包含在主页面的form表单内 -->
<%@ page language="java" pageEncoding="UTF-8" contentType="textml; charset=UTF-8"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<c:if test="${set == 'anno'}">
<div class="module-head" style="height:45px;line-height:45px;">
	<span class="title" style="margin-left: 20px;">当前第${pageInfo.pageNumber}页，共 ${pageInfo.pageCount} 页， 总共 ${pageInfo.totalCount} 条记录</span>
	<ul class="pagination" style="float: right;margin: 8px 30px;">
<!-- 	页面跳转 -->
	<li><span style="border:0;margin:0;">
	            第<input type="text" id="input" style="width:50px;height:20px;padding-left:20px" value="${pageInfo.pageNumber}">页</span>
	    <a href="#" onclick="location.href='/system/Announcement/getAnno?page='+document.getElementById('input').value;"">
	                     跳转</a></li>	
<!-- 	   根据总页数判断分别显示 -->
	<c:if test="${pageInfo.pageCount <= 1 }">  
			<li class="disabled"><a href="/system/Announcement/getAnno">上一页</a></li>
			<li class="active"><a href="/system/Announcement/getAnno?page=1">1</a></li>
			<li class="disabled"><a href="/system/Announcement/getAnno">下一页</a></li>
		</c:if>
		<c:if test="${pageInfo.pageCount >1 }">   
			<c:if test="${pageInfo.pageNumber == 1 }"> 
				<li class="disabled"><a href="#" onclick="return previous()">上一页</a></li>
			</c:if>
			<c:if test="${pageInfo.pageNumber > 1 }"> 
				<li><a href="/system/Announcement/getAnno?page=${pageInfo.pageNumber-1}">上一页</a></li>
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
		  			<li><a href="/system/Announcement/getAnno?page=${iNum}">${iNum}</a></li>
		  		</c:if>
		  		<c:if test="${pageInfo.pageNumber == iNum}">
					<li class="active"><a href="#">${iNum}</a></li>
		  		</c:if> 
		    </c:forEach>	    
		    <c:if test="${pageInfo.pageNumber >= pageInfo.pageCount }">   
		    	<li class="disabled"><a href="#" onclick="return false;">下一页</a></li>
		    </c:if>
			<c:if test="${pageInfo.pageNumber < pageInfo.pageCount }"> 
				<li><a href="/system/Announcement/getAnno?page=${pageInfo.pageNumber+1}">下一页</a></li>
			</c:if>
		</c:if>
	</ul>
</div>
</c:if>




<c:if test="${set == 'announce'}">
<div class="module-head" style="height:45px;line-height:45px;">
	<span class="title" style="margin-left: 20px;">当前第${pageInfo.pageNumber}页，共 ${pageInfo.pageCount} 页， 总共 ${pageInfo.totalCount} 条记录</span>
	<ul class="pagination" style="float: right;margin: 8px 30px;">
<!-- 	页面跳转 -->
	<li><span style="border:0;margin:0;">
	            第<input type="text" id="input" style="width:50px;height:20px;padding-left:20px" value="${pageInfo.pageNumber}">页</span>
	    <a href="#" onclick="location.href='/system/Announcement/annoRetrieve?page='+document.getElementById('input').value;"">
	                     跳转</a></li>	
<!-- 	   根据总页数判断分别显示 -->
	<c:if test="${pageInfo.pageCount <= 1 }">  
			<li class="disabled"><a href="/system/Announcement/annoRetrieve">上一页</a></li>
			<li class="active"><a href="/system/Announcement/annoRetrieve?page=1">1</a></li>
			<li class="disabled"><a href="/system/Announcement/annoRetrieve">下一页</a></li>
		</c:if>
		<c:if test="${pageInfo.pageCount >1 }">   
			<c:if test="${pageInfo.pageNumber == 1 }"> 
				<li class="disabled"><a href="#" onclick="return previous()">上一页</a></li>
			</c:if>
			<c:if test="${pageInfo.pageNumber > 1 }"> 
				<li><a href="/system/Announcement/annoRetrieve?page=${pageInfo.pageNumber-1}">上一页</a></li>
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
		  			<li><a href="/system/Announcement/annoRetrieve?page=${iNum}">${iNum}</a></li>
		  		</c:if>
		  		<c:if test="${pageInfo.pageNumber == iNum}">
					<li class="active"><a href="#">${iNum}</a></li>
		  		</c:if> 
		    </c:forEach>	    
		    <c:if test="${pageInfo.pageNumber >= pageInfo.pageCount }">   
		    	<li class="disabled"><a href="#" onclick="return false;">下一页</a></li>
		    </c:if>
			<c:if test="${pageInfo.pageNumber < pageInfo.pageCount }"> 
				<li><a href="/system/Announcement/annoRetrieve?page=${pageInfo.pageNumber+1}">下一页</a></li>
			</c:if>
		</c:if>
	</ul>
</div>
</c:if>

<c:if test="${set == 'user'}">
	<div class="module-head" style="height: 45px; line-height: 45px;">
		<span class="title" style="margin-left: 20px;">当前第${pageInfo.pageNumber}页，共
			${pageInfo.pageCount} 页， 总共 ${pageInfo.totalCount} 条记录</span>
		<ul class="pagination" style="float: right; margin: 8px 30px;">
			<li><span style="border: 0; margin: 0;">第<input
					type="text" id="input" value="${pageInfo.pageNumber}"style="width: 50px; height: 20px">页
			</span> <a href="#"
				onclick="location.href='/system/user/getUser?page='+document.getElementById('input').value;">跳转</a></li>
			<c:if test="${pageInfo.pageCount <= 1 }">
				<li class="disabled"><a href="/system/user/getUser">上一页</a></li>
				<li class="active"><a href="/system/user/getUser?page=1">1</a></li>
				<li class="disabled"><a href="/system/user/getUser">下一页</a></li>
			</c:if>
			<c:if test="${pageInfo.pageCount >1 }">
				<c:if test="${pageInfo.pageNumber == 1 }">
					<li class="disabled"><a href="#" >上一页</a></li>
				</c:if>
				<c:if test="${pageInfo.pageNumber > 1 }">
					<li><a
						href="/system/user/getUser?page=${pageInfo.pageNumber-1}">上一页</a></li>
				</c:if>
				<c:set var="pageStart" value="1" />
				<c:set var="pageStop" value="${pageInfo.pageCount}" />
				<c:if
					test="${pageInfo.pageNumber + 2 >= pageInfo.pageCount && pageInfo.pageCount > 5}">
					<c:set var="pageStart" value="${pageInfo.pageCount - 4}" />
				</c:if>
				<c:if
					test="${pageInfo.pageNumber + 2 < pageInfo.pageCount && pageInfo.pageCount > 5}">
					<c:set var="pageStart" value="${pageInfo.pageNumber - 2}" />
					<c:set var="pageStop" value="${pageInfo.pageNumber + 2}" />
					<c:if test="${pageInfo.pageNumber < 3}">
						<c:set var="pageStart" value="1" />
						<c:set var="pageStop" value="5" />
					</c:if>
				</c:if>
				<c:forEach var="iNum" begin="${pageStart}" end="${pageStop}"
					step="1">
					<c:if test="${pageInfo.pageNumber != iNum}">
						<li><a href="/system/user/getUser?page=${iNum}">${iNum}</a></li>
					</c:if>
					<c:if test="${pageInfo.pageNumber == iNum}">
						<li class="active"><a href="#">${iNum}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pageInfo.pageNumber >= pageInfo.pageCount }">
					<li class="disabled"><a href="#" onclick="return false;">下一页</a></li>
				</c:if>
				<c:if test="${pageInfo.pageNumber < pageInfo.pageCount }">
					<li><a
						href="/system/user/getUser?page=${pageInfo.pageNumber+1}">下一页</a></li>
				</c:if>
			</c:if>
		</ul>
	</div>
</c:if>
<c:if test="${set == 'dept'}">
	<div class="module-head" style="height: 45px; line-height: 45px;">
		<span class="title" style="margin-left: 20px;">当前第${pageInfo.pageNumber}页，共
			${pageInfo.pageCount} 页， 总共 ${pageInfo.totalCount} 条记录</span>
		<ul class="pagination" style="float: right; margin: 8px 30px;">
			<li><span style="border: 0; margin: 0;">第<input
					type="text" id="input" value="${pageInfo.pageNumber}"style="width: 50px; height: 20px">页
			</span><a href="#"
				onclick="location.href='/system/dept/getDept?&page='+document.getElementById('input').value;">跳转</a></li>
			<c:if test="${pageInfo.pageCount <= 1 }">
				<li class="disabled"><a href="/system/dept/getDept">上一页</a></li>
				<li class="active"><a href="/system/dept/getDept?page=1">1</a></li>
				<li class="disabled"><a href="/system/dept/getDept">下一页</a></li>
			</c:if>
			<c:if test="${pageInfo.pageCount >1 }">
				<c:if test="${pageInfo.pageNumber == 1 }">
					<li class="disabled"><a href="#" onclick="return previous()">上一页</a></li>
				</c:if>
				<c:if test="${pageInfo.pageNumber > 1 }">
					<li><a
						href="/system/dept/getDept?page=${pageInfo.pageNumber-1}">上一页</a></li>
				</c:if>
				<c:set var="pageStart" value="1" />
				<c:set var="pageStop" value="${pageInfo.pageCount}" />
				<c:if
					test="${pageInfo.pageNumber + 2 >= pageInfo.pageCount && pageInfo.pageCount > 5}">
					<c:set var="pageStart" value="${pageInfo.pageCount - 4}" />
				</c:if>
				<c:if
					test="${pageInfo.pageNumber + 2 < pageInfo.pageCount && pageInfo.pageCount > 5}">
					<c:set var="pageStart" value="${pageInfo.pageNumber - 2}" />
					<c:set var="pageStop" value="${pageInfo.pageNumber + 2}" />
					<c:if test="${pageInfo.pageNumber < 3}">
						<c:set var="pageStart" value="1" />
						<c:set var="pageStop" value="5" />
					</c:if>
				</c:if>
				<c:forEach var="iNum" begin="${pageStart}" end="${pageStop}"
					step="1">
					 <c:if test="${pageInfo.pageNumber != iNum}">
						<li><a href="/system/dept/getDept?page=${iNum}">${iNum}</a></li>
					</c:if>
					<c:if test="${pageInfo.pageNumber == iNum}">
						<li class="active"><a href="#">${iNum}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pageInfo.pageNumber >= pageInfo.pageCount }">
					<li class="disabled"><a href="#" onclick="return false;">下一页</a></li>
				</c:if>
				<c:if test="${pageInfo.pageNumber < pageInfo.pageCount }">
					<li><a
						href="/system/dept/getDept?page=${pageInfo.pageNumber+1}">下一页</a></li>
				</c:if>
			</c:if>
		</ul>
	</div>
</c:if>
<script type="text/javascript">
 	var pageCount = "${pageInfo.pageCount}"; 
</script>
<script type="text/javascript" src="${baseUrlStatic}/js/common/page.js?ver=${version}"></script>