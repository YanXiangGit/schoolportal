package com.portal.controller;

import com.portal.model.BaseYh;
import com.portal.service.BaseYhService;
import com.portal.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
    @Autowired
    private BaseYhService baseYhService;

    @RequestMapping(value = {"/"})
    public String view(Model map) {
        return "login";
    }

    @RequestMapping(value = {"/login"})
    public String view(String dlmc,String mm) {
        if(Utils.isNotEmpty(dlmc)&& Utils.isNotEmpty(mm)){
            BaseYh baseYh =  baseYhService.queryByDlmcAndMm(dlmc,mm);
            if(baseYh != null){
                return  "index";
            }
        }
        return "login";
    }
}
