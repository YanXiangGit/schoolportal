package com.portal.dao;

import com.portal.model.BaseYh;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BaseYhDao {
    String TABLE_NAEM = "base_yh";
    String INSERT_FIELDS = "dlmc,yhmc,yhlx,mm,bmbm,bmmc,sfzmhm,sjhm,lxdh,dzyx,yhzt,bz,gxsj,gxr";
    String SELECT_FIELDS = " yhbh, " + INSERT_FIELDS;

    @Insert({"insert into", TABLE_NAEM, "(", INSERT_FIELDS, ") values (#{dlmc},#{yhmc},#{yhlx},#{mm},#{bmbm},#{bmmc},#{sfzmhm},#{sjhm},#{lxdh},#{dzyx},#{yhzt},#{bz},#{gxsj},#{gxr})"})
    public void insertUser(BaseYh baseYh);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAEM, "where dlmc=#{0} and mm=#{1}"})
    public BaseYh queryByDlmcAndMm(String dlmc,String mm);


    @Delete({"delete from", TABLE_NAEM, "where yhbh=#{id}"})
    public void deleteById(int id);
}
