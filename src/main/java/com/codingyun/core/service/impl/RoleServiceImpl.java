package com.codingyun.core.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingyun.core.dao.RoleDao;
import com.codingyun.core.entity.vo.RoleVo;
import com.codingyun.core.service.RoleService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	private static Logger logger = Logger.getLogger(RoleServiceImpl.class);

	@Override
	public void saveRole(RoleVo roleVo, HttpServletRequest request, HttpServletResponse response) {
		roleDao.saveRole(roleVo, request);
	}

	// 根据id获取会议记录
	@Override
	public List<RoleVo> getRoleById(int id) {
		List<RoleVo> list = roleDao.getRoleById(id);
		return list;
	}

	// 删除会议记录
	@Override
	public void deleteRole(int id) throws Exception{
		roleDao.deleteRole(id);
	}

	@Override
	public List<RoleVo> getRoleList(int pageNumber, int pageSize, String roleName){
		List<RoleVo> list = roleDao.getRoleList(pageNumber, pageSize, roleName);
		return list;
	}

	@Override
	public int getListCount(String roleName){
		int total = roleDao.getListCount(roleName);
		return total;
	}
}
	


