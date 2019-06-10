package com.codingyun.core.dao;

import java.util.List;

import com.codingyun.core.entity.vo.DepartmentVo;

import javax.servlet.http.HttpServletRequest;

public interface DepartmentDao {

	List<DepartmentVo> getDepartmentList(int pageNumber, int pageSize, String deptName);

	int getListCount(String deptName);

	void saveDepartment(DepartmentVo departmentVo, HttpServletRequest request);

	void deleteDepartment(int id) throws Exception;

	List<DepartmentVo> getDepartmentById(int id) throws Exception;

	void batchDelete(Integer[] ids) throws Exception;
}
