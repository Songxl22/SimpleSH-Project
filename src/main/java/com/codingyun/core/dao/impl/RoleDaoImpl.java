package com.codingyun.core.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.codingyun.core.dao.RoleDao;
import com.codingyun.core.entity.vo.RoleVo;
import javax.servlet.http.HttpServletRequest;

@Repository
public class RoleDaoImpl extends GenericBaseCommonDao implements RoleDao {

	Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void saveRole(RoleVo roleVo, HttpServletRequest request) {
		saveOrUpdate(roleVo);
	}

	@Override
	public void deleteRole(int id) throws Exception{
		RoleVo roleVo = new RoleVo();
		deleteEntityById(roleVo.getClass(), id);
	}

	@Override
	public List<RoleVo> getRoleById(int id) {
		String hql = "from RoleVo where role_id = " + id;
		List<RoleVo> list = findByQueryString(hql);
		return list;
	}

	@Override
	public List<RoleVo> getRoleList(int pageNumber, int pageSize, String roleName){
		int startNo = pageSize * (pageNumber - 1);
		StringBuilder hql = new StringBuilder("from RoleVo");
		if(roleName != null){
			hql.append(" where role_name like '%").append(roleName).append("%'");
		}
		hql.append(" order by role_id desc");
		List<RoleVo> result = new ArrayList<>();
		try{
			result = findByQueryString(hql.toString(), startNo, pageSize);
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}

	public int getListCount(String roleName){
		StringBuilder sql = new StringBuilder("select count(1) from role");
		if(roleName != null){
			sql.append(" where role_name like '%").append(roleName).append("%'");
		}
		List list = findListbySql(sql.toString());
		return Integer.parseInt(list.get(0).toString());
	}
}