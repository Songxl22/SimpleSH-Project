package com.codingyun.core.service;

import java.util.List;

import com.codingyun.core.entity.vo.DepartmentVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DepartmentService {

	//获取部门记录
	List<DepartmentVo> getDepartmentList(int pageNumber, int pageSize, String deptName);

	//获取记录数量
	int getListCount(String deptName);

	void saveDepartment(DepartmentVo departmentVo , HttpServletRequest request , HttpServletResponse response);

	void deleteDepartment(int id) throws Exception;

	List<DepartmentVo> getDepartmentById(int id) throws Exception;

	void batchDelete(Integer[] ids) throws Exception;
}
