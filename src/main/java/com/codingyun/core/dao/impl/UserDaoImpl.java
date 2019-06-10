package com.codingyun.core.dao.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.codingyun.core.dao.UserDao;
import com.codingyun.core.entity.vo.SysUserVo;
import com.codingyun.core.util.StringUtil;

@Repository
public  class UserDaoImpl extends GenericBaseCommonDao implements UserDao{
	
	Logger logger = Logger.getLogger(this.getClass());

	
	public SysUserVo getSysUserByUserName(String userName) throws Exception {
		if(StringUtil.isEmpty(userName)){
			return null;
		}
		String sql = "select id,user_name,user_pass from sys_user where user_name = '"+userName+"'";
		List<Object[]> result = findListbySql(sql);
		SysUserVo vo = new SysUserVo();
		if(result != null && result.size() > 0){
			vo.setUserName(result.get(0)[1].toString());
			vo.setUserPass(result.get(0)[2].toString());
		}
		return vo;
	}
		
}
	
	

