package com.codingyun.core.dao;

import com.codingyun.core.entity.vo.SysUserVo;

public interface UserDao{

	public SysUserVo getSysUserByUserName(String userName) throws Exception;

}
