$(document).ready(function () {
	//初始化table
	initTable();
	//搜索事件
	$("#search").on("click", function () {
		$('#mainTable').bootstrapTable('refresh', {
			query:
				{
					person:$("#person").val(),
					leave_type:$("#leave_type").val(),
					start_time: $("#start_time").val()
				}
		});
	});

	$("#clearDate").on("click", function () {
		$("#start_time").val("");
	})

	$(".own-date").datetimepicker({
		format: 'yyyy-mm-dd',
		minView: 2,
		autoclose: true,
		language: 'zh-CN',
	});

	$("#addRecord").on("click", function () {
		$("#modalLabel").text("添加记录");
		$("#myModal").modal("toggle");
		$(':input','#leaveForm')
			.not(':button, :submit, :reset')
			.val('')
			.removeAttr('checked')
			.removeAttr('selected');
	})

	$("#pass").on("click",function () {
		$.ajax({
			url: "/system/leave/updateLeave",
			data:{
				id: $("#transferId").val(),
				type: "pass"
			},
			type: "POST",
			dataType: "json",
			success: function (data) {
				if(data.resultCode == 200){
					toastr["success"]("审核成功！");
					$('#verifyModal').modal('toggle');
					$('#mainTable').bootstrapTable("refresh");
				}
			},
			error: function () {
				toastr["warning"]("审核失败！");
			}
		})
	})
	$("#nopass").on("click",function () {
		$.ajax({
			url: "/system/leave/updateLeave",
			data:{
				id: $("#transferId").val(),
				type: "nopass"
			},
			type: "POST",
			dataType: "json",
			success: function (data) {
				if(data.resultCode == 200){
					toastr["success"]("审核成功！");
					$('#verifyModal').modal('toggle');
					$('#mainTable').bootstrapTable("refresh");
				}
			},
			error: function () {
				toastr["warning"]("审核失败！");
			}
		})
	})

	//提交表单
	$("#submit").on("click", function () {
		if($("#applyName").val() === ""){
			toastr["warning"]("请假人不能为空");
			return;
		}
		if($("#leaveType").val() === ""){
			toastr["warning"]("请假类型不能为空");
			return;
		}
		if($("#startTime").val() === ""){
			toastr["warning"]("开始时间不能为空");
			return;
		}
		if($("#endTime").val() === ""){
			toastr["warning"]("结束时间不能为空");
			return;
		}
		if($("#reason").val() === ""){
			toastr["warning"]("请假原因不能为空");
			return;
		}
		$.ajax({
			url: "/system/leave/saveLeave",
			type: "POST",
			dataType: "json",
			data:serializeNotNull($("#leaveForm").serialize()),
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


function initTable(){
	$("#mainTable").bootstrapTable({
		url: "/system/leave/getLeaveList",
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
				title: '序号',//标题
				align : 'center',
				valign : 'middle',
				width : 10,
				formatter: function (value, row, index) {
					var options = $("#mainTable").bootstrapTable("getOptions");
					return options.pageSize * (options.pageNumber - 1) + index + 1;
				}
			},
			{
				title : '请假人',
				field: "applyName",
				align : 'center',
				width : 100,
				valign : 'middle',
			},
			{
				title: '开始时间',//标题
				field: "startTime",
				align : 'center',
				valign : 'middle',
				width : 60 ,
				formatter: function (value, row, index) {
					return formatJsonDate(value);
				}
			},
			{
				title: '结束时间',//标题
				field: "endTime",
				align : 'center',
				valign : 'middle',
				width : 60 ,
				formatter: function (value, row, index) {
					return formatJsonDate(value);
				}
			},
			{
				title : '请假类型',
				field: "leaveType",
				align : 'center',
				width : 100,
				valign : 'middle',
				formatter: function (value,row,index) {
					var show;
					if(value === 0){
						show = "事假"
					}else if(value === 1){
						show = "病假"
					}else if(value === 2){
						show = "调休假"
					}
					return show;
				}
			},
			{
				title : '请假原因',
				field: "reason",
				align : 'center',
				width : 100,
				valign : 'middle',
			},
			{
				title : '状态',
				field: "status",
				align : 'center',
				width : 100,
				valign : 'middle',
				formatter: function (value, row, index) {
					var real;
					if(value === 0){
						real = "待审核";
					}else if(value === 1){
						real = "已通过";
					}else if(value === 2){
						real = "不通过";
					}
					return real;
				}
			},
			{
				title : '操作',
				align : 'center',
				width : 120 ,
				valign : 'middle',
				formatter : function(value,row,index){
					var e = '<a href="javascript:void()" onclick="editRecord(\''+ row.leaveId + '\')">编辑</a>&nbsp&nbsp&nbsp&nbsp';
					var f = '<a href="javascript:void()" onclick="verifyRecord(\''+ row.leaveId + '\')">审核</a>&nbsp&nbsp&nbsp&nbsp';
					var d = '<a href="javascript:void()" onclick="deleteRecord(\''+ row.leaveId +'\')">删除</a> ';
					return e+f+d;
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
		}
		// });

	})
}

function deleteRecord(v){
	$.ajax({
		url: "/system/leave/deleteLeave",
		data:{
			id: v
		},
		type: "POST",
		dataType: "json",
		success: function (data) {
			if(data.resultCode == 200){
				toastr["success"]("删除记录成功！");
				$('#mainTable').bootstrapTable("refresh");
			}
		},
		error: function () {
			toastr["warning"]("删除记录失败！");
		}
	})
}
function editRecord(v){
	$.ajax({
		url: "/system/leave/getLeaveById",
		data:{
			id: v
		},
		type: "POST",
		dataType: "json",
		success: function (data) {
			if(data.resultCode == 200){
				$("#modalLabel").text("修改记录");
				$("#leaveId").val(data.data[0].leaveId);
				$("#applyName").val(data.data[0].applyName);
				$("#leaveType").val(data.data[0].leaveType);
				$("#startTime").val(formatDate(data.data[0].startTime));
				$("#endTime").val(formatDate(data.data[0].endTime));
				$("#reason").val(data.data[0].reason);
				$('#myModal').modal("toggle");
			}
		},
		error: function () {
			toastr["warning"]("获取记录失败！");
		}
	})
}
function verifyRecord(v){
	$("#verifyModal").modal("toggle");
	$("#transferId").val(v);
}
