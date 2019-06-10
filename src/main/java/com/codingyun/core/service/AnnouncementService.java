package com.codingyun.core.service;

import java.util.List;
import com.codingyun.core.entity.vo.AnnouncementVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AnnouncementService {
	//获取记录
	List<AnnouncementVo> getAnnouncementList(int pageNumber, int pageSize);

	//获取记录数量
	int getListCount();

	//删除记录
	void deleteAnnouncement(int id) throws Exception;

	//根据Id获取记录
	List<AnnouncementVo> getAnnouncementById(int id);

	void saveAnnouncement(AnnouncementVo announcementVo , HttpServletRequest request , HttpServletResponse response);

}
