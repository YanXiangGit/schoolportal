package com.portal.service;

import com.portal.dao.BaseYhDao;
import com.portal.model.BaseYh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseYhService {

    @Autowired
    private BaseYhDao baseYhDao;

    public void insertUser(BaseYh baseYh){
        baseYhDao.insertUser(baseYh);
    };

    public BaseYh queryByDlmcAndMm(String dlmc,String mm){
        return baseYhDao.queryByDlmcAndMm(dlmc,mm);
    };


    public void deleteById(int id){
        baseYhDao.deleteById(id);
    };
}
