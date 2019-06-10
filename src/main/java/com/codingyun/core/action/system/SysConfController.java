package com.codingyun.core.action.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codingyun.core.entity.JsonResult;

import com.codingyun.core.entity.vo.ConferenceVo;
import com.codingyun.core.entity.vo.PagingInfo;
import com.codingyun.core.entity.vo.PagingResult;

import com.codingyun.core.exception.ServiceException;
import com.codingyun.core.service.ConferenceService;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

/** 
* 
*----------Dragon be here!----------/ 
* 　　　┏┓　　　┏┓ 
* 　　┏┛┻━━━┛┻┓ 
* 　　┃　　　　　　　┃ 
* 　　┃　　　━　　　┃ 
* 　　┃　┳┛　┗┳　┃ 
* 　　┃　　　　　　　┃ 
* 　　┃　　　┻　　　┃ 
* 　　┃　　　　　　　┃ 
* 　　┗━┓　　　┏━┛ 
* 　　　　┃　　　┃神兽保佑 
* 　　　　┃　　　┃代码无BUG！ 
* 　　　　┃　　　┗━━━┓ 
* 　　　　┃　　　　　　　┣┓ 
* 　　　　┃　　　　　　　┏┛ 
* 　　　　┗┓┓┏━┳┓┏┛ 
* 　　　　　┃┫┫　┃┫┫ 
* 　　　　　┗┻┛　┗┻┛ 
* ━━━━━━神兽出没━━━━━━
*/

@Controller
@RequestMapping("/system/Conference")
public class SysConfController {
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private ConferenceService ConfService;
	@Autowired
	JsonResult jsonResult;

	/**
	 * 会议记录跳转
	 * @param request
	 * @return
	 * @throws Exception
	 * 2016年11月10日
	 */
	@RequestMapping(value = "getConf", method = RequestMethod.GET)
	public String getConf(HttpServletRequest request) throws Exception {
		logger.info("会议管理");
		return "system/Conference/Conference";
	}

	/**
	 * @Author songxl
	 * @Description 会议记录添加
	 * @Date 2019/6/4
	 * @param conferenceVo
	 * @param request
	 * @param response
	 * @return
	 **/
	@RequestMapping(value = "saveConference", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult saveConference(ConferenceVo conferenceVo, HttpServletRequest request, HttpServletResponse response) {
		try {
			if(conferenceVo.getSubject() == null || conferenceVo.getSubject() == ""){
				jsonResult.setCM(1001, "会议主题不能为空");
				return jsonResult;
			}
			if(conferenceVo.getSite() == null || conferenceVo.getSite() == ""){
				jsonResult.setCM(1001, "会议地点不能为空");
				return jsonResult;
			}
			if(conferenceVo.getHour() == null || ("").equals(conferenceVo.getHour())){
				jsonResult.setCM(1001, "会议时间不能为空");
				return jsonResult;
			}
			conferenceVo.setState(0);
			ConfService.saveConference(conferenceVo, request, response);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("add conference failed! ", e);
			jsonResult.setCM(1003, "操作失败");
			return jsonResult;
		}
		jsonResult.setCM(200, "操作成功");
		return jsonResult;
	}

	/**
	 * @Author songxl
	 * @Description 删除会议记录
	 * @Date 2019/6/4
	 * @param request
	 * @return
	 **/
	@RequestMapping(value = "deleteConference", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult deleteConference(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			ConfService.deleteConference(Integer.valueOf(id));
		}catch (Exception e) {
			logger.error("record delete failed! ", e);
			return jsonResult.setCM(1003, "删除会议记录失败！");
		}
		jsonResult.setCM(200, "删除记录成功！");
		return jsonResult;
	}

	/**
	 * @Author songxl
	 * @Description 结束会议
	 * @Date 2019/6/6
	 * @param request
	 * @return
	 **/
	@RequestMapping(value = "closeConference", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult closeConference(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			ConfService.closeConference(Integer.valueOf(id));
		}catch (Exception e) {
			logger.error("record update failed! ", e);
			return jsonResult.setCM(1003, "状态变更失败！");
		}
		jsonResult.setCM(200, "状态变更成功！");
		return jsonResult;
	}

	/**
	 * @Author songxl
	 * @Description 根据id获取会议记录
	  @Date 2019/6/4
	 * @param request
	 * @return
	 **/
	@RequestMapping(value = "getConferenceById", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult getConferenceById(HttpServletRequest request){
		String id = request.getParameter("id");
		try{
			List<ConferenceVo> conf = ConfService.getConferenceById(Integer.valueOf(id));
			jsonResult.setCMD(200, "获取成功", conf);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("获取失败");
			jsonResult.setCM(1003, "获取失败");
			return jsonResult;
		}
		return jsonResult;
	}

	/**
	 * 分页信息显示和查询-原始版
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 2016年11月10日
	 */
	@RequestMapping(value = "confPagination", method = RequestMethod.POST)
	@ResponseBody
	public String confPagination(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String searchValue = request.getParameter("searchValue");
		String pageNumberParam = request.getParameter("page"); // 页码
		String pageSizeParam = request.getParameter("rows"); // 记录条数
		int pageNumber = 1;
		int pageSize = 10;
		if (pageNumberParam != null) {
			pageNumber = Integer.parseInt(pageNumberParam);
		}
		if (pageSizeParam != null) {
			pageSize = Integer.parseInt(pageSizeParam);
		}
		// List<Conf> conf = ConfService.sysConf(request);
		PagingInfo<ConferenceVo> pageRequest = createPagingInfo(pageNumber, pageSize);
		PagingResult<ConferenceVo> pagingResult;
		try {
			pagingResult = ConfService.getPage(pageRequest,searchValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pagingResult = new PagingResult<>(1, pageSize, 0);
		}
		// 构造一个map
		Map<String, Object> jsonMap = new HashMap<String, Object>(); // 定义map
		jsonMap.put("total", pagingResult.getTotalCount()); // 总页数
		jsonMap.put("pageNumber", pagingResult.getThisPageNumber());
		jsonMap.put("rows", pagingResult.getResult());
		// java与json字符串转换
		JSONObject json = JSONObject.fromObject(jsonMap);
		String jsonResult = json.toString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(jsonResult);
		return null;
		//return "system/Conference/Conference";
	}
	private PagingInfo<ConferenceVo> createPagingInfo(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return new PagingInfo<>(pageNumber, pageSize);
	}

	/**
	 * @Author songxl
	 * @Description 分页获取会议记录
	 * @Date 2019/6/3
	 * @param request
	 * @param response
	 * @param pager
	 * @return
	 **/
	@RequestMapping(value = "getConferenceList", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getConferenceList(HttpServletRequest request, HttpServletResponse response,@RequestBody JSONObject pager){
		JSONObject json = new JSONObject();
		int pageNumber = pager.getInt("pageNumber");
		int pageSize = pager.getInt("pageSize");
		String theme = null!=pager.get("theme")&&!"".equals(pager.get("theme"))?pager.getString("theme").trim():null;
		int state = null!=pager.get("state")&&!"".equals(pager.get("state"))?pager.getInt("state"):-1;
		List<ConferenceVo> list = ConfService.getConferenceList(pageNumber, pageSize, theme, state);
        int total = ConfService.getListCount(theme,state);
		json.put("total", total);
		json.put("rows", list);
		return json;
	}
}