package com.codingyun.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.codingyun.core.dao.DepartmentDao;
import com.codingyun.core.entity.vo.DepartmentVo;

import javax.servlet.http.HttpServletRequest;

@Repository
public class DepartmentDaoImpl extends GenericBaseCommonDao implements DepartmentDao {

	Logger logger = Logger.getLogger(this.getClass());

	@Override
	public List<DepartmentVo> getDepartmentList(int pageNumber, int pageSize, String deptName){
		int startNo = pageSize * (pageNumber - 1);
		StringBuilder hql = new StringBuilder("from DepartmentVo");
		if(deptName != null){
			hql.append(" where department_name like '%").append(deptName).append("%'");
		}
		hql.append(" order by department_id desc");
		List<DepartmentVo> result = new ArrayList<>();
		try{
			result = findByQueryString(hql.toString(), startNo, pageSize);
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getListCount(String deptName){
		StringBuilder sql = new StringBuilder("select count(1) from department");
		if(deptName != null){
			sql.append(" where department_name like '%").append(deptName).append("%'");
		}
		List list = findListbySql(sql.toString());
		return Integer.parseInt(list.get(0).toString());
	}

	@Override
	public void saveDepartment(DepartmentVo departmentVo, HttpServletRequest request) {
		saveOrUpdate(departmentVo);
	}

	@Override
	public void deleteDepartment(int id) throws Exception{
		DepartmentVo departmentVo = new DepartmentVo();
		deleteEntityById(departmentVo.getClass(), id);
	}

	@Override
	public List<DepartmentVo> getDepartmentById(int id) throws Exception {
		String hql = "from DepartmentVo where department_id = " + id;
		List<DepartmentVo> list = findByQueryString(hql);
		return list;
	}

	@Override
	public void batchDelete(Integer[] ids) throws Exception{
		for(int id : ids){
			String sql = "delete from department where department_id =" + id;
			executeSql(sql);
		}
	}

}
