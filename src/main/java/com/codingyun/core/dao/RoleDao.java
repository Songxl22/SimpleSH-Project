package com.codingyun.core.dao;

import java.util.List;
import com.codingyun.core.entity.vo.RoleVo;

import javax.servlet.http.HttpServletRequest;

public interface RoleDao {

	void saveRole(RoleVo roleVo, HttpServletRequest request);

	void deleteRole(int id) throws Exception;

	List<RoleVo> getRoleById(int id);

	List<RoleVo> getRoleList(int pageNumber, int pageSize, String roleName);

	int getListCount(String roleName);

}
