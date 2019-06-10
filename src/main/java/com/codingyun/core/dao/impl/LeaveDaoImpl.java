package com.codingyun.core.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.codingyun.core.dao.LeaveDao;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.codingyun.core.entity.vo.LeaveVo;

@Repository
public class LeaveDaoImpl extends GenericBaseCommonDao implements LeaveDao {

	Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void saveLeave(LeaveVo leaveVo, HttpServletRequest request) {
		saveOrUpdate(leaveVo);
	}

	@Override
	public void deleteLeave(int id) throws Exception{
		LeaveVo leaveVo = new LeaveVo();
		deleteEntityById(leaveVo.getClass(), id);
	}

	@Override
	public void updateLeave(int id, String type) throws Exception{
		String sql = "";
		if("pass".equals(type)){
			sql = "update leave_manage set status = 1 where leave_id = " + id;
		}else if("nopass".equals(type)){
			sql = "update leave_manage set status = 2 where leave_id = " + id;
		}
		updateBySqlString(sql);
	}

	@Override
	public List<LeaveVo> getLeaveById(int id) {
		String hql = "from LeaveVo where leave_id = " + id;
		List<LeaveVo> list = findByQueryString(hql);
		return list;
	}

	@Override
	public List<LeaveVo> getLeaveList(int pageNumber, int pageSize, String applyName, int leaveType, String startTime) throws Exception{
		int startNo = pageSize * (pageNumber - 1);
		StringBuilder hql = new StringBuilder("from LeaveVo where 1 = 1");
		if(applyName != null && applyName != ""){
			hql.append(" and apply_name like '%").append(applyName).append("%'");
		}
		if(leaveType >= 0){
			hql.append(" and leave_type = ").append(leaveType);
		}
		if(startTime != null && startTime != ""){
			hql.append(" and start_time >= '").append(startTime).append("'");
		}
		hql.append(" order by leave_id desc");
		List<LeaveVo> result = new ArrayList<>();
		try{
			result = findByQueryString(hql.toString(), startNo, pageSize);
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getListCount(String applyName, int leaveType, String startTime) throws Exception{
		StringBuilder sql = new StringBuilder("select count(1) from leave_manage where 1 = 1");
		if(applyName != null && !"".equals(applyName)){
			sql.append(" and apply_name like '%").append(applyName).append("%'");
		}
		if(leaveType >= 0){
			sql.append(" and leave_type = ").append(leaveType);
		}
		if(startTime != null && startTime != ""){
			Date xx = new Date();
			sql.append(" and start_time >= '").append(startTime).append("'");
		}
		List list = findListbySql(sql.toString());
		return Integer.parseInt(list.get(0).toString());
	}
}
