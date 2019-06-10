package com.codingyun.core.action.system;

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
import com.codingyun.core.entity.vo.RoleVo;
import com.codingyun.core.service.RoleService;

@Controller
@RequestMapping("/system/role")
public class SysRoleController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private RoleService RoleService;
	@Autowired
	private JsonResult jsonResult;
	/**
	 * @Author songxl
	 * @Description 跳转角色管理
	 * @Date 2019/6/6
	 * @param request
	 * @param response
	 * @return
	 **/
	@RequestMapping(value = "getRole", method = RequestMethod.GET)
	public String getRole(HttpServletRequest request,HttpServletResponse response){
		logger.info("角色管理");
		return "system/Role/role";
	}

	/**
	 * @Author songxl
	 * @Description 角色保存
	 * @Date 2019/6/6
	 * @param roleVo
	 * @param request
	 * @param response
	 * @return
	 **/
	@RequestMapping(value = "saveRole", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult saveRole(RoleVo roleVo, HttpServletRequest request, HttpServletResponse response) {
		try {
			if(roleVo.getRoleName() == null || roleVo.getRoleName() == ""){
				jsonResult.setCM(1001, "会议主题不能为空");
				return jsonResult;
			}
			if(roleVo.getRoleDescription() == null || roleVo.getRoleDescription() == ""){
				jsonResult.setCM(1001, "会议地点不能为空");
				return jsonResult;
			}
			RoleService.saveRole(roleVo, request, response);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("add role failed! ", e);
			jsonResult.setCM(1003, "操作失败");
			return jsonResult;
		}
		jsonResult.setCM(200, "操作成功");
		return jsonResult;
	}

	/**
	 * @Author songxl
	 * @Description 删除角色
	 * @Date 2019/6/6
	 * @param request
	 * @return
	 **/
	@RequestMapping(value = "deleteRole", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult deleteRole(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			RoleService.deleteRole(Integer.valueOf(id));
		}catch (Exception e) {
			logger.error("record delete failed! ", e);
			return jsonResult.setCM(1003, "删除会议记录失败！");
		}
		jsonResult.setCM(200, "删除记录成功！");
		return jsonResult;
	}

	/**
	 * @Author songxl
	 * @Description 根据id获取角色
	 * @Date 2019/6/6
	 * @param request
	 * @return
	 **/
	@RequestMapping(value = "getRoleById", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult getRoleById(HttpServletRequest request){
		String id = request.getParameter("id");
		try{
			List<RoleVo> role = RoleService.getRoleById(Integer.valueOf(id));
			jsonResult.setCMD(200, "获取成功", role);
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
	 * @Description 获取角色记录列表
	 * @Date 2019/6/6
	 * @param request
	 * @param response
	 * @param pager
	 * @return
	 **/
	@RequestMapping(value = "getRoleList", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getRoleList(HttpServletRequest request, HttpServletResponse response,@RequestBody JSONObject pager){
		JSONObject json = new JSONObject();
		int pageNumber = pager.getInt("pageNumber");
		int pageSize = pager.getInt("pageSize");
		String roleName = pager.get("roleName")!=null?pager.getString("roleName").trim():null;
		List<RoleVo> list = RoleService.getRoleList(pageNumber, pageSize, roleName);
		int total = RoleService.getListCount(roleName);
		json.put("total", total);
		json.put("rows", list);
		return json;
	}

}