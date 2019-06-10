package com.codingyun.core.action.system;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.codingyun.core.entity.JsonResult;
import com.codingyun.core.entity.vo.LeaveVo;
import com.codingyun.core.service.LeaveService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/system/leave")
public class SysLeaveController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private LeaveService LeaveService;
	@Autowired
	JsonResult jsonResult;
	/**
	 * 进入请假主页面
	 * @param request
	 * @return 返回请假主页面
	 * @throws Exception
	 */
	@RequestMapping(value = "getLeave", method = RequestMethod.GET)
	public String getLeave(HttpServletRequest request){
		logger.info("请假管理");		
		return "/system/Leave/leave";
	}

	@RequestMapping(value = "saveLeave", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult saveLeave(LeaveVo leaveVo, HttpServletRequest request, HttpServletResponse response) {
		try {
			if(leaveVo.getApplyName() == null || leaveVo.getApplyName() == ""){
				jsonResult.setCM(1001, "申请人不能为空");
				return jsonResult;
			}
			if(leaveVo.getLeaveType() == null || ("").equals(leaveVo.getLeaveType())){
				jsonResult.setCM(1001, "请假类型不能为空");
				return jsonResult;
			}
			if(leaveVo.getStartTime() == null || ("").equals(leaveVo.getStartTime())){
				jsonResult.setCM(1001, "开始时间时间不能为空");
				return jsonResult;
			}
            if(leaveVo.getEndTime() == null || ("").equals(leaveVo.getEndTime())){
                jsonResult.setCM(1001, "结束时间时间不能为空");
                return jsonResult;
            }
            if(leaveVo.getReason() == null || leaveVo.getReason() == ""){
                jsonResult.setCM(1001, "申请原因不能为空");
                return jsonResult;
            }
			leaveVo.setStatus(0);
			LeaveService.saveLeave(leaveVo, request, response);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("add Leave failed! ", e);
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
	@RequestMapping(value = "deleteLeave", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult deleteLeave(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			LeaveService.deleteLeave(Integer.valueOf(id));
		}catch (Exception e) {
			logger.error("record delete failed! ", e);
			return jsonResult.setCM(1003, "删除记录失败！");
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
	@RequestMapping(value = "updateLeave", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult updateLeave(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			String type = request.getParameter("type");
			LeaveService.updateLeave(Integer.valueOf(id), type);
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
	@RequestMapping(value = "getLeaveById", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult getLeaveById(HttpServletRequest request){
		String id = request.getParameter("id");
		try{
			List<LeaveVo> conf = LeaveService.getLeaveById(Integer.valueOf(id));
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
	 * @Author songxl
	 * @Description 分页获取会议记录
	 * @Date 2019/6/3
	 * @param request
	 * @param response
	 * @param pager
	 * @return
	 **/
	@RequestMapping(value = "getLeaveList", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getLeaveList(HttpServletRequest request, HttpServletResponse response,@RequestBody JSONObject pager){
		JSONObject json = new JSONObject();
		int pageNumber = pager.getInt("pageNumber");
		int pageSize = pager.getInt("pageSize");
		try{
            String applyName = null!=pager.get("person")&&!"".equals(pager.get("person"))?pager.getString("person").trim():null;
            int leave_type = null!=pager.get("leave_type")&&!"".equals(pager.get("leave_type"))?pager.getInt("leave_type"):-1;
            String start_time = null!=pager.get("start_time")&&!"".equals(pager.get("start_time"))?pager.getString("start_time"):null;
            List<LeaveVo> list = LeaveService.getLeaveList(pageNumber, pageSize, applyName, leave_type, start_time);
            int total = LeaveService.getListCount(applyName,leave_type, start_time);
            json.put("total", total);
            json.put("rows", list);
        }catch (Exception e){
		    e.printStackTrace();
        }
		return json;
	}
	
}
