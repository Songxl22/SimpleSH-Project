$(document).ready(function () {
	//初始化table
	initTable();


	$("#addRecord").on("click", function () {
        editRecord();
	})
})


function initTable(){
	$("#mainTable").bootstrapTable({
		url: "/system/Announcement/getAnnouncementList",
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
				title: '公告主题',//标题
				field: "theme",
				align : 'center',
				valign : 'middle',
				width : 60 ,
			},
			{
				title : '公告内容',
				field: "contents",
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
					var e = '<a href="javascript:void()" onclick="editRecord(\''+ row.id + '\')">编辑</a>&nbsp&nbsp&nbsp&nbsp';
					var d = '<a href="javascript:void()" onclick="deleteRecord(\''+ row.id +'\')">删除</a> ';
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
		}
		// });

	})
}

function deleteRecord(v){
	$.ajax({
		url: "/system/Announcement/deleteAnnouncement",
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
    window.location.href = "/system/Announcement/toAnnoAdd?id=" + v;
}
