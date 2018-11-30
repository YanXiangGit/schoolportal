package com.portal.controller;

import com.portal.model.BaseYh;
import com.portal.service.BaseYhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
    @Autowired
    private BaseYhService baseYhService;

    @RequestMapping(value = {"/", "/login"})
    public String view(Model map) {
        BaseYh yh = baseYhService.queryByYhbh("1");
        System.out.println(yh.getDlmc());
        return "login";
    }
}
