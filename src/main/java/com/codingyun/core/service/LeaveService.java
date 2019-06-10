package com.codingyun.core.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.codingyun.core.entity.vo.LeaveVo;

public interface LeaveService {
	
	//添加请假记录
	void saveLeave(LeaveVo leaveVo , HttpServletRequest request , HttpServletResponse response);

	//删除请假记录
	void deleteLeave(int id) throws Exception;

	//结束请假
	void updateLeave(int id, String type) throws Exception;

	//根据Id获取请假记录
	List<LeaveVo> getLeaveById(int id);

	//获取请假记录
	List<LeaveVo> getLeaveList(int pageNumber, int pageSize, String applyName, int leaveType, String startTime) throws Exception;

	//获取记录数量
	int getListCount(String applyName, int leaveType, String startTime) throws Exception;
}
