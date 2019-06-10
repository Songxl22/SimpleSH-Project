package com.codingyun.core.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.codingyun.core.entity.vo.SysUserVo;

public class SysAdminInterceptor extends HandlerInterceptorAdapter {
	
private final Logger logger = Logger.getLogger(this.getClass());
	
	private static final Set<String> noMappingSet = new HashSet<String>();
	static{
		noMappingSet.add("/system/login");
		noMappingSet.add("/system/login/loginCheck");
	}
	
	/**
	 * 定义登录页面
	 */
	public static final String LOGIN_PAGE = "/system/login";
	
//	@Autowired
//	LoginService loginService;
	
	/** 
	 * Controller之前执行
     * 在业务处理器处理请求之前被调用 
     * 如果返回false 
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
     *  
     * 如果返回true 
     *    执行下一个拦截器,直到所有的拦截器都执行完毕 
     *    再执行被拦截的Controller 
     *    然后进入拦截器链, 
     *    从最后一个拦截器往回执行所有的postHandle() 
     *    接着再从最后一个拦截器往回执行所有的afterCompletion() 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("interceptor excute order:1.preHandle================");  
        logger.info("request url:" + request.getRequestURI());
		if(noMappingSet.contains(request.getRequestURI())){
			logger.info("The login page don't need validate!");
            return true;   
        }  
		SysUserVo sysUser = (SysUserVo) request.getSession().getAttribute("sysUser");
		if(sysUser == null){
//			request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
//        	response.sendRedirect(request.getContextPath() + LOGIN_PAGE);
        	response.sendRedirect("/system/login");  
        	return false;   
		}
        return true;  
	}
	
	  //在业务处理器处理请求执行完成后,生成视图之前执行的动作   
    @Override  
    public void postHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler,  
            ModelAndView modelAndView) throws Exception {  
    	logger.info("interceptor excute order:2.postHandle================");  
    }  
  
    /** 
     * 在DispatcherServlet完全处理完请求后被调用  
     *  
     *   当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
     */  
    @Override  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex)  
            throws Exception {  
    	logger.info("interceptor excute order:3.afterCompletion================");  
    }  

}
