package com.codingyun.core.dao;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.codingyun.core.entity.vo.LeaveVo;

public interface LeaveDao {

	void saveLeave(LeaveVo leave, HttpServletRequest request);

	void deleteLeave(int id) throws Exception;

	void updateLeave(int id, String type) throws Exception;

	List<LeaveVo> getLeaveById(int id);

	List<LeaveVo> getLeaveList(int pageNumber, int pageSize, String applyName, int leaveType, String startTime) throws Exception;

	int getListCount(String applyName, int leaveType, String startTime) throws Exception;
}

