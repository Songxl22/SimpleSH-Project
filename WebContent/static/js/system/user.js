$(document).ready(function() {
	// 添加用户
	$("#userAddBtn").on('click', function() {
	});
});

function checkid() {
	var subject = document.getElementById("userid").value;
	if (subject == "" || isNaN(subject)) {
		$("#useridError").show();
		flag = false;
	} else {
		$("#useridError").hide();
		flag = true;
	}
	return flag;
}
function checkempno() {
	var subject = document.getElementById("userempno").value;
	if (subject == "" || isNaN(subject)) {
		$("#userempnoError").show();
		flag = false;
	} else {
		$("#userempnoError").hide();
		flag = true;
	}
	return flag;
}
function checkname() {
	var subject = document.getElementById("username").value;
	if (subject == "" || subject.length >= 20) {
		$("#usernameError").show();
		flag = false;
	} else {
		$("#usernameError").hide();
		flag = true;
	}
	return flag;
}
function checkpass() {
	var subject = document.getElementById("userpass").value;
	if (subject == "" || subject.length >= 20 || subject.length <= 5
			|| subject.match(/[^A-Za-z0-9]/ig)) {
		$("#userpassError").show();
		flag = false;
	} else {
		$("#userpassError").hide();
		flag = true;
	}
	return flag;
}
function checkdept() {
	var subject = document.getElementById("userdept").value;
	if (subject == "") {
		$("#userdeptError").show();
		flag = false;
	} else {
		$("#userdeptError").hide();
		flag = true;
	}
	return flag;
}
function checkemail() {
	var regemail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
	var subject = document.getElementById("useremail").value;
	if (!regemail.test(subject)) {
		$("#useremailError").show();
		flag = false;
	} else {
		$("#useremailError").hide();
		flag = true;
	}
	return flag;
}
function checktel() {
	var subject = document.getElementById("usertel").value;
	if (subject == "" || isNaN(subject)) {
		$("#usertelError").show();
		flag = false;
	} else {
		$("#usertelError").hide();
		flag = true;
	}
	return flag;
}
function checkidnum() {
	var idnum = /^[0-9]+$/ || /^[0-9]+x+$/;
	var subject = document.getElementById("useridnum").value;
	if (!idnum.test(subject) || subject.length != 18) {
		$("#useridnumError").show();
		flag = false;
	} else {
		$("#useridnumError").hide();
		flag = true;
	}
	return flag;
}
function check() {
	checkid();
	checkempno();
	checkname();
	checkpass();
	checkdept();
	checkemail();
	checktel();
	checkidnum();
	if (checkid() && checkempno() && checkname() && checkpass() && checkdept()
			&& checkemail() && checktel() && checkidnum()) {
		userAdd();
		return false;
	} else {
		alert("完善信息！");
		return false;

	}
}
function userAdd() {
	var datasent = $("#userEditForm").serializeObject();// 序列化
	params = JSON.stringify(datasent); // 把原来是对象的类型转换成字符串类型（或者更确切的说是json类型的）。
	$.ajax({
		type : "POST",
		url : "/system/user/useridCheck",
		dataType : "json",
		contentType : "application/json;charset=utf-8",
		data : params,
		async : false,
		success : function(data) {
			if (data.resultCode == 0) {
				$.ajax({
					type : "POST",
					url : "/system/user/userAdd",
					dataType : "json",
					contentType : "application/json;charset=utf-8",
					data : params,
					async : false,
					success : function(data) {
						if (data.resultCode == 0) {
							alert("保存成功！");
							window.location.href = "/system/user/getUser";
						} else {
							alert(data.resultMessage);
						}
					}
				});
			} else {
				alert(data.resultMessage);
			}
		}
	});
}

// 更新
$(function() {
	$("#updata").on('click', function() {
		checkup();
	});
});
function checkup(){
	checkdept();
	checkemail();
	checktel();
	checkidnum();
	if(checkdept() && checkemail() && checktel() && checkidnum()){
		updata();
		return true;
	}else{
		alert("完善信息！");
		return false;
	}
}
function updata() {
	var btn = $("#updata");
	var datasent = $("#userEditForm").serializeObject();// 序列化
	params = JSON.stringify(datasent); // 把原来是对象的类型转换成字符串类型（或者更确切的说是json类型的）。
	$.ajax({
		type : "POST",
		url : "/system/user/updata",
		dataType : "json",
		contentType : "application/json;charset=utf-8",
		data : params,
		async : false,
		success : function(data) {
			if (data.resultCode == 0) { // 登录成功
				alert("保存成功！");
				window.location.href = "/system/user/getUser";
			} else {

				alert(data.resultMessage);
			}
			btn.button('reset');
		}
	});
}
// 删除用户
function delUserById(userDelete) {
	var datasent = userDelete;
	params = JSON.stringify(datasent); // 把原来是对象的类型转换成字符串类型（或者更确切的说是json类型的）。
	$.ajax({
		type : "POST",
		url : "/system/user/userDelete",
		dataType : "json",
		contentType : "application/json;charset=utf-8",
		data : params,
		async : false,
		success : function(data) {
			if (data.resultCode == 0) {
				window.location.href = "/system/user/getUser";

			} else {
				alert(data.resultMessage);
			}
		}
	});
}

// 多项删除
function delUsersel() {
	var obj = document.getElementsByName("ck");
	var userselect = "";
	for (var i = 0; i < obj.length; i++) {
		if (obj[i].checked)
			userselect += obj[i].value + ','; // 如果选中，将value添加到变量userselect中
	}
	if (userselect == "") {
		alert("请选择要删除的项。")
		return false;
	}
	$.ajax({
		type : "POST",
		url : "/system/user/userDelete",
		dataType : "json",
		contentType : "application/json;charset=utf-8",
		data : userselect,
		async : false,
		success : function(data) {
			if (data.resultCode == 0) {
				alert("删除成功！")
				window.location.href = "/system/user/getUser";

			} else {
				alert(data.resultMessage);
			}
		}
	});
}
// 密码验证
$(function() {
	$("#passcheck").on('click', function() {
		ckpwd();
	});
});

function checkpassword() {
	var subject = document.getElementById("userpass").value;
	if (subject == "" || subject.length >= 20 || subject.length <= 5
			|| subject.match(/[^A-Za-z0-9]/ig)) {
		$("#userpasswordError").show();
		flag = false;
	} else {
		$("#userpasswordError").hide();
		flag = true;
	}
	return flag;
}
function checknewpass() {
	var subject = document.getElementById("newpass").value;
	if (subject == "" || subject.length >= 20 || subject.length <= 5
			|| subject.match(/[^A-Za-z0-9]/ig)) {
		$("#newpassError").show();
		flag = false;
	} else {
		$("#newpassError").hide();
		flag = true;
	}
	return flag;
}
function checknewpass1() {
	var passA = document.getElementById("newpass").value;
	var passB = document.getElementById("newpass1").value;
	if (passB != passA) {
		$("#newpass1Error").show();
		flag = false;
	} else {
		$("#newpass1Error").hide();
		flag = true;
	}
	return flag;
}

function ckpwd() {
	checkpassword();
	checknewpass();
	checknewpass1();
	if (checkpassword() && checknewpass() && checknewpass1()) {
		passcheck();
		return false;
	} else {
		alert("请按要求输入正确信息！");
		return false;
	}
}
function passcheck() {
	var datasent = $("#userPassForm").serializeObject();// 序列化
	params = JSON.stringify(datasent); // 把原来是对象的类型转换成字符串类型（或者更确切的说是json类型的）。
	$.ajax({
		type : "POST",
		url : "/system/user/passCheck",
		dataType : "json",
		contentType : "application/json;charset=utf-8",
		data : params,
		async : false,
		success : function(data) {
			if (data.resultCode == 0) { // 登录成功
				alert("保存成功！");
				window.location.href = "/system/user/getUser";
			} else {

				alert(data.resultMessage);
			}
			btn.button('reset');
		}
	});
	return true;
}