package com.codingyun.core.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingyun.core.entity.vo.SysUserVo;

public interface UserService {
	
	/**
	 * 系统管理员登录
	 * @user coding云
	 * 2014年6月24日
	 */
	public SysUserVo sysAdminLogin(SysUserVo user, HttpServletRequest request, HttpServletResponse response) throws Exception;

}

