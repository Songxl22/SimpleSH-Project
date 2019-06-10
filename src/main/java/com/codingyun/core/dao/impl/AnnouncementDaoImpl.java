package com.codingyun.core.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.codingyun.core.dao.AnnouncementDao;
import com.codingyun.core.entity.vo.AnnouncementVo;

import javax.servlet.http.HttpServletRequest;

@Repository
public class AnnouncementDaoImpl extends GenericBaseCommonDao implements AnnouncementDao {

	Logger logger = Logger.getLogger(this.getClass());

    @Override
    public List<AnnouncementVo> getAnnouncementList(int pageNumber, int pageSize){
        int startNo = pageSize * (pageNumber - 1);
        StringBuilder hql = new StringBuilder("from AnnouncementVo where 1 = 1");
        hql.append(" order by id desc");
        List<AnnouncementVo> result = new ArrayList<>();
        try{
            result = findByQueryString(hql.toString(), startNo, pageNumber);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getListCount(){
        StringBuilder sql = new StringBuilder("select count(1) from announcement where 1 = 1");
        List list = findListbySql(sql.toString());
        return Integer.parseInt(list.get(0).toString());
    }

    @Override
    public void deleteAnnouncement(int id) throws Exception{
        AnnouncementVo announcementVo = new AnnouncementVo();
        deleteEntityById(announcementVo.getClass(), id);
    }

    @Override
    public List<AnnouncementVo> getAnnouncementById(int id) {
        String hql = "from AnnouncementVo where id = " + id;
        List<AnnouncementVo> list = findByQueryString(hql);
        return list;
    }

    @Override
    public void saveAnnouncement(AnnouncementVo announcementVo, HttpServletRequest request) {
        saveOrUpdate(announcementVo);
    }
}


