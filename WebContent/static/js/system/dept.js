$(document).ready(function () {
	var selectIdArr = [];
	//初始化table
	initTable(selectIdArr);
	//搜索事件
	$("#search").on("click", function () {
		$('#mainTable').bootstrapTable('refresh', {
			query:
				{
					deptName:$("#deptName").val(),
				}
		});
	});

	//添加部门点击事件
	$("#addRecord").on("click", function () {
		$("#modalLabel").text("新建部门");
		$("#myModal").modal("toggle");
		$(':input','#deptForm')
			.not(':button, :submit, :reset')
			.val('')
			.removeAttr('checked')
			.removeAttr('selected');
	})

	//批量删除点击事件
	$("#batchDelete").on("click", function () {
		console.info(selectIdArr)
		if(selectIdArr.length <= 0){
			toastr["warning"]("请选择要删除的记录！");
			return;
		}
		$.ajax({
			url: "/system/dept/batchDelete",
			data: JSON.stringify(selectIdArr),
			type: "POST",
			dataType: "json",
			contentType : "application/json",
			traditional:true,
			success: function (data) {
				if(data.resultCode == 200){
					toastr["success"]("删除部门记录成功！");
					$('#mainTable').bootstrapTable("refresh");
					selectIdArr.splice(0,selectIdArr.length);
				}
			},
			error: function () {
				toastr["warning"]("删除部门记录失败！");
			}
		})
	})

	//提交表单
	$("#submit").on("click", function () {
		if($("#departmentName").val() === ""){
			toastr["warning"]("部门名称不能为空");
			return;
		}
		if($("#task").val() === ""){
			toastr["warning"]("部门职责不能为空");
			return;
		}
		$.ajax({
			url: "/system/dept/saveDepartment",
			type: "POST",
			dataType: "json",
			data:serializeNotNull($("#deptForm").serialize()),
			beforeSend: function(){

			},
			success: function (data) {
				if(data.resultCode == 200){
					toastr["success"]("操作成功！");
					$('#myModal').modal('toggle');
					$('#mainTable').bootstrapTable("refresh");
				}else{
					toastr["warning"](data.resultMessage);
				}
			},
			complete: function () {

			},
			error: function () {
				toastr["warning"]("操作失败！");
			}
		})
	})
})

function initTable(arr){
	$("#mainTable").bootstrapTable({
		url: "/system/dept/getDepartmentList",
		method: "post",
		dataType: "json",
		singleSelect: false,
		striped: true, //是否显示行间隔色
		cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		//sortable: true, //是否启用排序
		pagination: true, //显示分页按钮
		//sortOrder:"desc", //默认排序
		pageNumber: 1, //初始化加载第一页，默认第一页
		pageSize: 10, //默认显示的每页个数
		pageList: [10, 25, 50, 100], //可供选择的每页的行数（*）
		onPageChange: function(number,size){
			parent.autoFrame();
		},
		queryParamsType: '', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort // 设置为 '' 在这种情况下传给服务器的参数为：pageSize,pageNumber
		queryParams:function(params){
			var temp = {
				pageSize: params.pageSize, //页面大小
				pageNumber: params.pageNumber, //页码
				//sortName: params.sortName, //排序列
				//sortOrder: params.sortOrder, //排序方式
				//queryJson: JSON.stringify(getQueryData()), //查询数据
			}
			return temp;
		},
		responseHandler:function(res){
			// 动态渲染表格之前获取有后台传递的数据时,用于获取出除去本身渲染所需的数据的额外参数
			// 详见此函数参数的api
			return res;
		},
		//search: true, //显示搜索框（客户端搜索）
		sidePagination: "server", //服务端处理分页
		// showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
		// cardView: false,                    //是否显示详细视图
		detailView: false, //是否显示父子表
		columns: [
			{
				checkbox: true,
				align : 'center',
				valign : 'middle',
				width : 10,
			},
			{
				title: '部门名称',//标题
				field: "departmentName",
				align : 'center',
				valign : 'middle',
				width : 60 ,
			},
			{
				title : '部门职责',
				field: "task",
				align : 'center',
				width : 100,
				valign : 'middle',
			},
			{
				title : '操作',
				align : 'center',
				width : 120 ,
				valign : 'middle',
				formatter : function(value,row,index){
					var e = '<a href="javascript:void()" onclick="editRecord(\''+ row.departmentId + '\')">编辑</a>&nbsp&nbsp&nbsp&nbsp';
					var d = '<a href="javascript:void()" onclick="deleteRecord(\''+ row.departmentId +'\')">删除</a> ';
					return e+d;
				}
			}],
		onLoadSuccess: function(data){ //加载成功时执行
			if(data.rows.length <= 0){
				$(".no-records-found").height("320px") ;
			}
			parent.autoFrame();
		},
		onLoadError: function(){ //加载失败时执行
			alert("加载数据失败");
		},
		onCheck:function(row){
			arr.push(row.departmentId);
		},
		onUncheck:function(row){
			arr.remove(row.departmentId);
		},
		onCheckAll:function(rows){
			arr.splice(0,arr.length);
			for(var i = 0; i < rows.length; i++){
				arr.push(rows[i].departmentId);
			}
		},
		onUncheckAll:function(rows){
			arr.splice(0,arr.length);
		}

	})
}

function deleteRecord(v){
	$.ajax({
		url: "/system/dept/deleteDepartment",
		data:{
			id: v
		},
		type: "POST",
		dataType: "json",
		success: function (data) {
			if(data.resultCode == 200){
				toastr["success"]("删除部门记录成功！");
				$('#mainTable').bootstrapTable("refresh");
			}
		},
		error: function () {
			toastr["warning"]("删除部门记录失败！");
		}
	})
}
function editRecord(v){
	$.ajax({
		url: "/system/dept/getDepartmentById",
		data:{
			id: v
		},
		type: "POST",
		dataType: "json",
		success: function (data) {
			if(data.resultCode == 200){
				$("#modalLabel").text("修改部门");
				$("#departmentId").val(data.data[0].departmentId);
				$("#departmentName").val(data.data[0].departmentName);
				$("#task").val(data.data[0].task);
				$('#myModal').modal("toggle");
			}
		},
		error: function () {
			toastr["warning"]("获取部门记录失败！");
		}
	})
}








