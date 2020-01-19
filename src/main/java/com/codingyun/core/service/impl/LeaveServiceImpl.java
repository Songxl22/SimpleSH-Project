package com.codingyun.core.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.codingyun.core.dao.LeaveDao;
import com.codingyun.core.entity.vo.LeaveVo;
import com.codingyun.core.service.LeaveService;
import org.apache.log4j.Logger;

@Service
public class LeaveServiceImpl implements LeaveService{
	@Autowired
	private LeaveDao leaveDao;
	
	private static Logger logger = Logger.getLogger(LeaveServiceImpl.class);

	// 信息添加service实现
	@Override
	public void saveLeave(LeaveVo leaveVo, HttpServletRequest request, HttpServletResponse response) {
		leaveDao.saveLeave(leaveVo, request);
	}

	// 根据id获取请假记录
	@Override
	public List<LeaveVo> getLeaveById(int id) {
		List<LeaveVo> list = leaveDao.getLeaveById(id);
		return list;
	}

	// 删除请假记录
	@Override
	public void deleteLeave(int id) throws Exception{
		leaveDao.deleteLeave(id);
	}

	// 结束请假
	@Override
	public void updateLeave(int id, String type) throws Exception{
		leaveDao.updateLeave(id, type);
	}

	@Override
	public List<LeaveVo> getLeaveList(int pageNumber, int pageSize, String applyName, int leaveType, String startTime) throws Exception{
		List<LeaveVo> list = leaveDao.getLeaveList(pageNumber, pageSize, applyName, leaveType, startTime);
		return list;
	}

	@Override
	public int getListCount(String applyName, int leaveType, String startTime) throws Exception{
		int total = leaveDao.getListCount(applyName, leaveType, startTime);
		return total;
	}
}


