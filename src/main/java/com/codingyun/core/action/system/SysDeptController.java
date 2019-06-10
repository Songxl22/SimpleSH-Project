package com.codingyun.core.action.system;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingyun.core.entity.JsonResult;
import com.codingyun.core.exception.ServiceException;
import com.google.gson.Gson;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.codingyun.core.entity.vo.DepartmentVo;
import com.codingyun.core.service.DepartmentService;

@Controller
@RequestMapping("/system/dept")
public class SysDeptController {

	private static Logger logger = Logger.getLogger(SysDeptController.class);

	@Autowired
	private DepartmentService DeptService;
	@Autowired
	private JsonResult jsonResult;
	/**
	 * @Author songxl
	 * @Description
	 * @Date 2019/6/5
	 * @param request
	 * @param response
	 * @return
	 **/
	@RequestMapping(value = "getDept", method = RequestMethod.GET)
	public String getDept(HttpServletRequest request, HttpServletResponse response) {
		logger.info("部门管理");
		return "system/dept/dept";
	}


	@RequestMapping(value = "getDepartmentList", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getDepartmentList(HttpServletRequest request, HttpServletResponse response,@RequestBody JSONObject pager){
		JSONObject json = new JSONObject();
		int pageNumber = pager.getInt("pageNumber");
		int pageSize = pager.getInt("pageSize");
		String deptName = pager.get("deptName")!=null?pager.getString("deptName").trim():null;
		List<DepartmentVo> list = DeptService.getDepartmentList(pageNumber, pageSize, deptName);
		int total = DeptService.getListCount(deptName);
		json.put("total", total);
		json.put("rows", list);
		return json;
	}

	@RequestMapping(value = "saveDepartment", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult saveDepartment(DepartmentVo departmentVo, HttpServletRequest request, HttpServletResponse response) {
		try {
			if(departmentVo.getDepartmentName() == null || departmentVo.getDepartmentName() == ""){
				jsonResult.setCM(1001, "部门名称不能为空");
				return jsonResult;
			}
			if(departmentVo.getTask() == null || departmentVo.getTask() == ""){
				jsonResult.setCM(1001, "部门职责不能为空");
				return jsonResult;
			}
			DeptService.saveDepartment(departmentVo, request, response);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("add department failed! ", e);
			jsonResult.setCM(1003, "操作失败");
			return jsonResult;
		}
		jsonResult.setCM(200, "操作成功");
		return jsonResult;
	}

	@RequestMapping(value = "deleteDepartment", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult deleteDepartment(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			DeptService.deleteDepartment(Integer.valueOf(id));
		}catch (Exception e) {
			logger.error("record delete failed! ", e);
			return jsonResult.setCM(1003, "删除会议记录失败！");
		}
		jsonResult.setCM(200, "删除记录成功！");
		return jsonResult;
	}

	@RequestMapping(value = "getDepartmentById", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult getDepartmentById(HttpServletRequest request){
		String id = request.getParameter("id");
		try{
			List<DepartmentVo> dept = DeptService.getDepartmentById(Integer.valueOf(id));
			jsonResult.setCMD(200, "获取成功", dept);
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
	 * @Description 批量删除
	 * @Date 2019/6/6
	 * @param ids
	 * @return
	 **/
	@RequestMapping(value = "batchDelete", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult batchDelete(@RequestBody Integer[] ids) {
		boolean flag = false;// 标识
		String errorMessage = "删除失败！";
		try {
			DeptService.batchDelete(ids);
			flag = true;
		} catch (ServiceException serviceE) {
			logger.error("batch delete failed!", serviceE);
			errorMessage = serviceE.getMessage();
		} catch (Exception e) {
			logger.error("batch delete failed! ", e);
		}
		jsonResult.setResultCode(flag ? 200 : 1003);
		jsonResult.setResultMessage(flag ? "删除成功！" : errorMessage);
		return jsonResult;
	}

}
