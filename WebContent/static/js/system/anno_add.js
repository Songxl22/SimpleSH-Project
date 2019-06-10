$(document).ready(function () {

	var ue = UE.getEditor('container', {
        initialFrameHeight: 260,
    });

	$("#cancel").on("click", function () {
        window.location.href = "/system/Announcement/getAnno";
	})

    //提交表单
    $("#submit").on("click", function () {
        if($("#theme").val() === ""){
            toastr["warning"]("公告主题不能为空");
            return;
        }
        if($("#contents").val() === ""){
            toastr["warning"]("公告内容不能为空");
            return;
        }
        $.ajax({
            url: "/system/Announcement/saveAnnouncement",
            type: "POST",
            dataType: "json",
            data:serializeNotNull($("#annoForm").serialize()),
            beforeSend: function(){

            },
            success: function (data) {
                if(data.resultCode == 200){
                    toastr["success"]("操作成功！");
                    window.location.href = "/system/Announcement/getAnno";
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
