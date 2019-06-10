package com.codingyun.core.action.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/system")
public class SysIndexController{

	/**
	 * 初始页面默认到系统管理员主页
	 * 2014-6-4 16:46:32
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(HttpServletRequest request){
		return "system/index";
	}

}
