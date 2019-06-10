package com.codingyun.core.dao;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.codingyun.core.entity.vo.ConferenceVo;
import com.codingyun.core.entity.vo.PagingInfo;
import com.codingyun.core.entity.vo.PagingResult;

public interface ConferenceDao {

	void saveConference(ConferenceVo confe, HttpServletRequest request);

	void deleteConference(int id) throws Exception;

	void closeConference(int id) throws Exception;
	
	List<ConferenceVo> getConferenceById(int id);

	PagingResult<ConferenceVo> findPage(PagingInfo<ConferenceVo> pageRequest, String searchValue) throws SQLException;


	List<ConferenceVo> getConferenceList(int pageNumber, int pageSize, String theme, int state);
	
    int getListCount(String theme, int state);

}
