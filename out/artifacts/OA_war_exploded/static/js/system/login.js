$(document).ready(function(){
	$("#loginBtn").on('click',function(){ 
		login();		
    });
	// 按回车执行查询
	$("#userName").on("keypress", function(){
		var event = arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异 
		if (event.keyCode == 13) {
//			$("#loginForm").submit();
			login();
		} // 回车键的键值为13
	}); 
	$("#userPass").on("keypress", function(){
		var event = arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异 
		if (event.keyCode == 13) {
			login();
		} // 回车键的键值为13
	}); 
	$("#authCode").on("keypress", function(){
		var event = arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异 
		if (event.keyCode == 13) {
			login();		
		} // 回车键的键值为13
	});
});

function login(){
	var btn = $("#loginBtn");	
    btn.button('loading');   
	var datasent = $("#loginForm").serializeObject();//序列化
	params = JSON.stringify(datasent); //把原来是对象的类型转换成字符串类型（或者更确切的说是json类型的）。
	$.ajax({                 
		type : "POST",
		url : "/system/login/loginCheck",
		dataType : "json",
		contentType : "application/json;charset=utf-8",
		data : params,
		async : false,		
		success : function(data) {
			if(data.resultCode == 0){   //登录成功				
				window.location.href="/system";

			}
			
		}
	});
}



