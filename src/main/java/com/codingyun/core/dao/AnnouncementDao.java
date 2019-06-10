package com.codingyun.core.dao;

import java.util.List;
import com.codingyun.core.entity.vo.AnnouncementVo;

import javax.servlet.http.HttpServletRequest;


public interface AnnouncementDao {

	List<AnnouncementVo> getAnnouncementList(int pageNumber, int pageSize);

	int getListCount();

	void deleteAnnouncement(int id) throws Exception;

	List<AnnouncementVo> getAnnouncementById(int id);

	void saveAnnouncement(AnnouncementVo announcementVo, HttpServletRequest request);
  
}
	  
	  



	
	  
