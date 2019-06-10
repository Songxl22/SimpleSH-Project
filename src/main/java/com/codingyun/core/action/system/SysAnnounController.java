package com.codingyun.core.action.system;


import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.codingyun.core.entity.JsonResult;
import com.codingyun.core.entity.vo.AnnouncementVo;
import com.codingyun.core.service.AnnouncementService;

@Controller
@RequestMapping("/system/Announcement")
public class SysAnnounController {

	private static Logger logger = Logger.getLogger(SysAnnounController.class);

	@Autowired
	private AnnouncementService announcementService;
	@Autowired
	private JsonResult jsonResult;

	/**
	 * @Author songxl
	 * @Description 跳转公告管理
	 * @Date 2019/6/9
	 * @param request
	 * @return
	 **/
	@RequestMapping(value = "getAnno", method = RequestMethod.GET)
	public String getAnno(HttpServletRequest request){
		return "system/Announcement/Announcement";
	}

	@RequestMapping(value = "getAnnouncementList", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getAnnouncementList(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject pager){
		JSONObject json = new JSONObject();
		int pageNumber = pager.getInt("pageNumber");
		int pageSize = pager.getInt("pageSize");
		List<AnnouncementVo> list = announcementService.getAnnouncementList(pageNumber, pageSize);
		int total = announcementService.getListCount();
		json.put("total", total);
		json.put("rows", list);
		return json;
	}

	@RequestMapping(value = "toAnnoAdd", method = RequestMethod.GET)
	public String toAnnoAdd(HttpServletRequest request) {
	    logger.info("添加公告");
	    try{
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		} catch (Exception e) {
			logger.error("fail ", e);
		}
		return "system/Announcement/anno_add";
	}


	@RequestMapping(value = "deleteAnnouncement", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult deleteAnnouncement(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			announcementService.deleteAnnouncement(Integer.valueOf(id));
		}catch (Exception e) {
			logger.error("record delete failed! ", e);
			return jsonResult.setCM(1003, "删除记录失败！");
		}
		jsonResult.setCM(200, "删除记录成功！");
		return jsonResult;
	}

	@RequestMapping(value = "getAnnouncementById", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult getAnnouncementById(HttpServletRequest request){
		String id = request.getParameter("id");
		try{
			List<AnnouncementVo> conf = announcementService.getAnnouncementById(Integer.valueOf(id));
			jsonResult.setCMD(200, "获取成功", conf);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("获取失败");
			jsonResult.setCM(1003, "获取失败");
			return jsonResult;
		}
		return jsonResult;
	}

	@RequestMapping(value = "saveAnnouncement", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult saveAnnouncement(AnnouncementVo announcementVo, HttpServletRequest request, HttpServletResponse response) {
		try {
			if(announcementVo.getTheme() == null || announcementVo.getTheme() == ""){
				jsonResult.setCM(1001, "公告主题不能为空");
				return jsonResult;
			}
			if(announcementVo.getContents() == null || announcementVo.getContents() == ""){
				jsonResult.setCM(1001, "公告内容不能为空");
				return jsonResult;
			}
			announcementVo.setCreateUser("system");
			announcementVo.setCreateDate(new Date());
			announcementService.saveAnnouncement(announcementVo, request, response);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("add announcement failed! ", e);
			jsonResult.setCM(1003, "操作失败");
			return jsonResult;
		}
		jsonResult.setCM(200, "操作成功");
		return jsonResult;
	}
}
