package com.codingyun.core.service;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.codingyun.core.entity.vo.ConferenceVo;
import com.codingyun.core.entity.vo.PagingInfo;
import com.codingyun.core.entity.vo.PagingResult;

public interface ConferenceService {

	//添加会议记录
	void saveConference(ConferenceVo conferenceVo , HttpServletRequest request , HttpServletResponse response);

	//删除会议记录
	void deleteConference(int id) throws Exception;

	//结束会议
	void closeConference(int id) throws Exception;

	//根据Id获取会议记录
	List<ConferenceVo> getConferenceById(int id);

	//会议记录分页-原始版
	PagingResult<ConferenceVo> getPage(PagingInfo<ConferenceVo> pageRequest, String searchValue) throws SQLException;

	//获取会议记录
	List<ConferenceVo> getConferenceList(int pageNumber, int pageSize, String theme, int state);

	//获取记录数量
	int getListCount(String theme, int state);

}