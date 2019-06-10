package com.codingyun.core.action.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.codingyun.core.entity.JsonResult;
import com.codingyun.core.entity.vo.SysUserVo;
import com.codingyun.core.exception.ServiceException;
import com.codingyun.core.service.UserService;
import com.google.gson.Gson;

/**
 * 后台管理用户登录
 * @author codingyun.com
 * 2014年5月30日
 */
@Controller
@RequestMapping("/system/login")
public class SysLoginController{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String login(HttpServletRequest request){
		logger.info("系统管理员登录");
		return "system/login";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		logger.info("系统管理员退出登录");
		request.getSession().invalidate();
		return "system/login";
	}
	
	/**
	 * 系统管理员登录接口
	 * @user coding云
	 * 2014-9-20
	 */
	@RequestMapping(value = "loginCheck", method = RequestMethod.POST)//定义访问的URL
	@ResponseBody     /*这个注解可以直接放在方法上，表示返回类型将会直接作为HTTP响应字节流输出(不被放置在Model，也不被拦截为视图页面名称)。可以用于ajax。 */

	public String loginCheck( @RequestBody SysUserVo user, HttpServletRequest request, HttpServletResponse response){
		logger.info("sys admin login info:" + user.toString());
		boolean flag = false;//标识
		String errorMessage = "用户登录失败";
		JsonResult jsonResult = new JsonResult();
		//异常捕获
		try {
			user = userService.sysAdminLogin(user, request, response);
			flag = true;
			//request.setAttribute("user", user);
		}catch (ServiceException serviceE){
			logger.error("sys admin login failed!", serviceE);
			errorMessage = serviceE.getMessage();
		}catch (Exception e) {
		logger.error("sys admin login failed! ", e);
		}
		jsonResult.setResultCode(flag ? 0 : 1);
		jsonResult.setResultMessage(flag ? "用户登录成功" : errorMessage);
		jsonResult.setData(user);
		return new Gson().toJson(jsonResult);
	}
	
}
