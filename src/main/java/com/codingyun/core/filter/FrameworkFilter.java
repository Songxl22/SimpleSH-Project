package com.codingyun.core.filter;

/**
 * Filter过滤器对请求进行判断
 * @author 王勇
 * @date 2014-5-27 15:10:40
 */

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrameworkFilter implements Filter {
	
	private FilterConfig config;
	private static final String baseUrlStatic = "baseUrlStatic";
	/**
	 * 定义登录页面
	 */
	public static final String LOGIN_PAGE = "/jsp/system/login_system.jsp";
	public static String[] EXCEPT_PAGE;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
//		System.out.println("baseUrlStatic:" + config.getInitParameter(baseUrlStatic));
//		System.out.println("1." + config.getServletContext().getContextPath());
//		System.out.println("2." + config.getServletContext().getRealPath(config.getInitParameter(baseUrlStatic)));
		request.setAttribute("baseUrlStatic", config.getInitParameter(baseUrlStatic));    //所有jsp页面引用的js、css均从这里提供根路径，页面只需以jstl取值即可"${baseUrlStatic}"
		request.setAttribute("version", new Random().nextInt());
//		BodyReaderHttpServletRequestWrapper requestWrapper = new BodyReaderHttpServletRequestWrapper(request);
//		if(requestWrapper != null) {
//			request = requestWrapper;
//		}
		for (String exception : EXCEPT_PAGE) {
			if (request.getRequestURI().endsWith(exception)) {
				/**
				 * 关于chain.doFilter(request,response)
				 * 他的作用是将请求转发给过滤器链上下一个对象。这里的下一个指的是下一个filter，
				 * 如果没有filter那就是你请求的资源。 一般filter都是一个链,web.xml 里面配置了几个就有几个。一个一个的连在一起 
				 * request -> filter1 -> filter2 ->filter3 -> .... -> request resource.
				 */
				filterChain.doFilter(request, response);
				return;
			}
		}

//		String ref = request.getHeader("REFERER");
//		HttpSession session = request.getSession(false);
//		String type = request.getHeader("X-Requested-With");
//		if (session == null
//				|| session.getAttribute("oaUser") == null
//				|| ref == null || "".equals(ref)) {
//			if ("XMLHttpRequest".equalsIgnoreCase(type)) {// AJAX REQUEST
//															// PROCESS
//				response.setHeader("sessionstatus", "timeout");
//				return;
//			}
//			response.sendRedirect(request.getContextPath() + LOGIN_PAGE);
//			return;
//		}

		filterChain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String exception = filterConfig.getInitParameter("exception");
		if (exception != null && !"".equals(exception)) {
			EXCEPT_PAGE = exception.split(",");
		}
		this.config = filterConfig;
	}

}
