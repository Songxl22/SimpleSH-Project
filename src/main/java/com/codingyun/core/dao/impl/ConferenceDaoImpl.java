package com.codingyun.core.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import com.codingyun.core.dao.ConferenceDao;
import com.codingyun.core.entity.vo.ConferenceVo;
import com.codingyun.core.entity.vo.PagingInfo;
import com.codingyun.core.entity.vo.PagingResult;

@Repository
public class ConferenceDaoImpl extends GenericBaseCommonDao implements ConferenceDao {

	Logger logger = Logger.getLogger(this.getClass());


	/**
	 * @Author songxl
	 * @Description 添加会议记录
	 * @Date 2019/6/4
	 * @param conferenceVo
	 * @param request
	 * @return
	 **/
	@Override
	public void saveConference(ConferenceVo conferenceVo, HttpServletRequest request) {
		saveOrUpdate(conferenceVo);
	}
     /**
	 * 会议信息删除底层数据交互
	 */
	@Override
	public void deleteConference(int id) throws Exception{
		ConferenceVo conferenceVo = new ConferenceVo();
		deleteEntityById(conferenceVo.getClass(), id);
	}

	/**
	 * @Author songxl
	 * @Description 结束会议
	 * @Date 2019/6/6
	 * @param id
	 * @return
	 **/
	@Override
	public void closeConference(int id) throws Exception{
		String sql = "update conference set state = 1 where id = " + id;
		updateBySqlString(sql);
	}
	
	/**
     * 会议信息按id查询底层数据交互
	 */
	@Override
	public List<ConferenceVo> getConferenceById(int id) {
		String hql = "from ConferenceVo where id = " + id;
		List<ConferenceVo> list = findByQueryString(hql);
		return list;
	}

	/**
	 * 会议信息分页-原始版
	 */
	@Override
	public PagingResult<ConferenceVo> findPage(PagingInfo<ConferenceVo> pageRequest, String searchValue) throws SQLException{
		int ps = pageRequest.getPageSize();
		int pn = pageRequest.getPageNumber();
		int sxl = ps*(pn-1);
		String sql = "select id,subject,hour,site,person from conference order by hour desc limit " + sxl + "," + ps;
		if(searchValue == null | searchValue == ""){
			sql = sql;
	    }else{
			sql="select id,subject,hour,site,person from conference where subject = N'"+searchValue+"' order by hour desc limit " + sxl + "," + ps;
		}
		int totalCount = getTotalCount(searchValue);
		List<ConferenceVo> confer = findListbySql(sql);
		PagingResult<ConferenceVo> result = new PagingResult<ConferenceVo>(pageRequest.getPageNumber(), pageRequest.getPageSize(), totalCount);
	//填充页码信息
	    result.setResult(confer); //填充结果数据
		return result;
	}
	private int getTotalCount(String searchValue) {
		//获取totalCount
		if(searchValue == null | searchValue == ""){
		int count = DataAccessUtils.intResult(getSession().createSQLQuery(
				"select count(*) from conference").list());
		return count;
		}else{
			int count = DataAccessUtils.intResult(getSession().createSQLQuery(
					"select count(*) from conference where subject = N'"+searchValue+"'").list());
			return count;
		}
	}

	/**
	 * @Author songxl
	 * @Description 会议记录列表获取
	 * @Date 2019/6/5
	 * @param pageNumber
	 * @param pageSize
	 * @param theme
	 * @return
	 **/
	@Override
	public List<ConferenceVo> getConferenceList(int pageNumber, int pageSize, String theme, int state){
		int startNo = pageSize * (pageNumber - 1);
		StringBuilder sql = new StringBuilder("select id, hour, person, site, subject, state from conference where 1 = 1");
		if(theme != null){
            sql.append(" and subject like '%").append(theme).append("%'");
        }
		if(state >= 0){
			sql.append(" and state = ").append(state);
		}
		sql.append(" order by id desc");
		sql.append(" limit ").append(startNo).append(",").append( pageSize);
        List<Object[]> objlist = findListbySql(sql.toString());
        List<ConferenceVo> result = new ArrayList<>();
        DateFormat pattern = new SimpleDateFormat("yyyy-MM-dd");
		try{
            for(Object[] objects : objlist){
                ConferenceVo conf = new ConferenceVo();
                conf.setId((int)objects[0]);
                conf.setHour(pattern.parse(objects[1].toString()));
                conf.setPerson((String)objects[2]);
                conf.setSite((String)objects[3]);
                conf.setSubject((String)objects[4]);
				conf.setState((int)objects[5]);
                result.add(conf);
            }
        }catch (Exception e){
		    e.printStackTrace();
        }
		return result;
	}

	@Override
	public int getListCount(String theme, int state){
		StringBuilder sql = new StringBuilder("select count(1) from conference where 1 = 1");
		if(theme != null && !"".equals(theme)){
			sql.append(" and subject like '%").append(theme).append("%'");
		}
		if(state >= 0){
			sql.append(" and state = ").append(state);
		}
		List list = findListbySql(sql.toString());
		return Integer.parseInt(list.get(0).toString());
	}


}
