package com.portal.service;

import com.portal.dao.BaseXtgnDao;
import com.portal.dao.BaseYhDao;
import com.portal.model.BaseXtgn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BaseXtgnService {
    @Autowired
    private BaseXtgnDao baseXtgnDao;

    public List<Map> queryFirstXtgnListByYhbh(String yhbh){
        return baseXtgnDao.queryFirstXtgnListByYhbh(yhbh);
    };

    public List<Map> queryFirstXtgnListByYhbhAndGnxbh(Map map){
        return baseXtgnDao.queryFirstXtgnListByYhbhAndGnxbh(map);
    };
}
