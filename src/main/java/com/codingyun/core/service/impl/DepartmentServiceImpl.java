package com.codingyun.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingyun.core.dao.DepartmentDao;
import com.codingyun.core.entity.vo.DepartmentVo;
import com.codingyun.core.service.DepartmentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao deptDao;

	@Override
	public List<DepartmentVo> getDepartmentList(int pageNumber, int pageSize, String deptName){
		List<DepartmentVo> list = deptDao.getDepartmentList(pageNumber, pageSize, deptName);
		return list;
	}

	@Override
	public int getListCount(String theme){
		int total = deptDao.getListCount(theme);
		return total;
	}

	@Override
	public void saveDepartment(DepartmentVo departmentVo, HttpServletRequest request, HttpServletResponse response) {
		deptDao.saveDepartment(departmentVo, request);
	}

	@Override
	public List<DepartmentVo> getDepartmentById(int id) throws Exception{
		List<DepartmentVo> list = deptDao.getDepartmentById(id);
		return list;
	}

	@Override
	public void deleteDepartment(int id) throws Exception{
		deptDao.deleteDepartment(id);
	}

	@Override
	public void batchDelete(Integer[] ids) throws Exception{
		deptDao.batchDelete(ids);
	}
}
