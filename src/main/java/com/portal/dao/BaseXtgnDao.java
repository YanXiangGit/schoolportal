package com.portal.dao;

import com.portal.model.BaseXtgn;
import com.portal.model.BaseYh;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("BaseXtgnDao")
public interface BaseXtgnDao {

    String TABLE_NAEM = "base_xtgn";
    String INSERT_FIELDS = "gnxmc,px,url,sjgnbh,cdjb,tp,zt,bz,gxsj";
    String SELECT_FIELDS = " gnxbh, " + INSERT_FIELDS;

    @Select({"select distinct b.yhbh,a.gnxbh,c.gnxmc,c.px,url,c.sjgnbh,c.cdjb,c.tp,c.bz,c.zt from base_jsgn a,base_yhqx b,base_xtgn c where instr(b.jsbh,a.jsbh)>0 and a.gnxbh=c.gnxbh and c.zt='1' and  c.cdjb='1' and b.yhbh=#{yhbh} order by c.px"})
    public List<Map> queryFirstXtgnListByYhbh(String yhbh);

    @Select({"select distinct b.yhbh,a.gnxbh,c.gnxmc,c.px,url,c.sjgnbh,c.cdjb,c.tp,c.bz,c.zt from base_jsgn a,base_yhqx b,base_xtgn c where instr(b.jsbh,a.jsbh)>0 and a.gnxbh=c.gnxbh and c.zt='1' and  c.cdjb!='1' and b.yhbh=${yhbh} and c.sjgnbh like '%${gnxbh}%' order by c.px"})
    public List<Map> queryFirstXtgnListByYhbhAndGnxbh(Map map);
}
