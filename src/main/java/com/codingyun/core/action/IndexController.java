package com.codingyun.core.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController{
	
	/**
	 * 进入首页
	 * 2014年9月4日
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(HttpServletRequest request){
		//对应的是WebContent目录下的WEB-INF目录下的jsp目录下的demo下的index.jsp
		//请查看配置文件springMvc3-servlet.xml仔细体会一下
		return "index";   
	}

}
