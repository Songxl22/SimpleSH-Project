package com.codingyun.core.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingyun.core.dao.ConferenceDao;
import com.codingyun.core.entity.vo.ConferenceVo;
import com.codingyun.core.entity.vo.PagingInfo;
import com.codingyun.core.entity.vo.PagingResult;
import com.codingyun.core.service.ConferenceService;

@Service
public class ConferenceServiceImpl implements ConferenceService {
	@Autowired
	private ConferenceDao confDao;
	private static Logger logger = Logger.getLogger(ConferenceServiceImpl.class);


	// 信息添加service实现
	@Override
	public void saveConference(ConferenceVo conferenceVo, HttpServletRequest request, HttpServletResponse response) {
		confDao.saveConference(conferenceVo, request);
	}

	// 根据id获取会议记录
	@Override
	public List<ConferenceVo> getConferenceById(int id) {
		List<ConferenceVo> list = confDao.getConferenceById(id);
		return list;
	}

	// 删除会议记录
	@Override
	public void deleteConference(int id) throws Exception{
		confDao.deleteConference(id);
	}

	// 结束会议
	@Override
	public void closeConference(int id) throws Exception{
		confDao.closeConference(id);
	}

	// 信息分页service实现-原始版
	@Override
	public PagingResult<ConferenceVo> getPage(PagingInfo<ConferenceVo> pageRequest, String searchValue) throws SQLException {
		// TODO Auto-generated method stub
		PagingResult<ConferenceVo> result = confDao.findPage(pageRequest, searchValue);
		return result;
	}

	@Override
	public List<ConferenceVo> getConferenceList(int pageNumber, int pageSize, String theme, int state){
		List<ConferenceVo> list = confDao.getConferenceList(pageNumber, pageSize, theme, state);
		return list;
	}

	@Override
	public int getListCount(String theme, int state){
		int total = confDao.getListCount(theme, state);
		return total;
	}


}
