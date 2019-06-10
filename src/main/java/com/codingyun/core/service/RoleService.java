package com.codingyun.core.service;

import java.util.List;
import com.codingyun.core.entity.vo.RoleVo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RoleService {

	//添加角色记录
	void saveRole(RoleVo roleVo , HttpServletRequest request , HttpServletResponse response);

	//删除角色记录
	void deleteRole(int id) throws Exception;

	//根据Id获取角色记录
	List<RoleVo> getRoleById(int id);

	//获取角色记录
	List<RoleVo> getRoleList(int pageNumber, int pageSize, String roleName);

	//获取记录数量
	int getListCount(String roleName);

}
