package com.codingyun.core.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingyun.core.dao.AnnouncementDao;
import com.codingyun.core.entity.vo.AnnouncementVo;
import com.codingyun.core.entity.vo.PagingInfo;
import com.codingyun.core.entity.vo.PagingResult;
import com.codingyun.core.service.AnnouncementService;
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

	@Autowired
	private AnnouncementDao announcementdao;

	private static Logger logger = Logger.getLogger(AnnouncementServiceImpl.class);

	@Override
	public List<AnnouncementVo> getAnnouncementList(int pageNumber, int pageSize){
		List<AnnouncementVo> list = announcementdao.getAnnouncementList(pageNumber, pageSize);
		return list;
	}

	@Override
	public int getListCount(){
		int total = announcementdao.getListCount();
		return total;
	}

	// 根据id获取记录
	@Override
	public List<AnnouncementVo> getAnnouncementById(int id) {
		List<AnnouncementVo> list = announcementdao.getAnnouncementById(id);
		return list;
	}

	// 删除记录
	@Override
	public void deleteAnnouncement(int id) throws Exception{
		announcementdao.deleteAnnouncement(id);
	}

	@Override
	public void saveAnnouncement(AnnouncementVo announcementVo, HttpServletRequest request, HttpServletResponse response) {
		announcementdao.saveAnnouncement(announcementVo, request);
	}
	
}

