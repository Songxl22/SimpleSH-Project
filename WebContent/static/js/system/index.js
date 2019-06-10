$(document).ready(function(){
	$(".logout").on('click',function(){
		logout();
    });
});

function logout(){
	window.location.href="/system/login/logout";
}

//左侧菜单切换
jQuery(document).on('click', '#lside .menubar li', function(elem) {
	var menu = jQuery(this);
	if (menu.is('.cascade')) {
		menu.toggleClass('open');
	}else {
		menu.closest('.menubar').find('li').removeClass('active');
		menu.closest('.menubar').find('.cascade').removeClass('open');
		menu.closest('.cascade').addClass('open');
		menu.addClass('active');
	}
	/*var href = elem.attr('href');
	menu.find('a').blur();
	return false;*/
});

function realSysTime(clock){
	var now=new Date();
	var year=now.getFullYear();
	var month=now.getMonth();
	var date=now.getDate();
	var day=now.getDay();
	var hour=now.getHours();
	var minu=now.getMinutes();
	
	if (minu<10){
		minu = '0' + minu;
	}
	var sec=now.getSeconds();
	if(sec<10){
		sec = '0' + sec;
	}
	month=month+1;
	var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
	var week=arr_week[day];
	var time=year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec;
	clock.innerHTML="当前时间："+time;
}
	window.onload=function(){
		window.setInterval("realSysTime(clock)",1000);
	    
}
	
	/*
	纪念日
	function getCdTime(){
		var endTime = new Date('2017/05/28 10:00:00');
		var nowTime = new Date();
		var t = endTime -nowTime;
		
		var d = Math.floor(t/1000/60/60/24);
		var h = Math.floor(t/1000/60/60%24);
		var m = Math.floor(t/1000/60%60);
		var s = Math.floor(t/1000%60);
		
		document.getElementById("Cdd").innerHTML = d + "天";
		document.getElementById("Cdh").innerHTML = h + "时";
		document.getElementById("Cdm").innerHTML = m + "分";
		document.getElementById("Cds").innerHTML = s + "秒";		
	}
    setInterval("getCdTime()",1000);*/
	window.autoFrame = function() {
			document.getElementById("mainframe").height=0;
			document.getElementById("mainframe").height=document.getElementById("mainframe").contentDocument.body.scrollHeight;
	}
