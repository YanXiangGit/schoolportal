package com.portal.controller;

import com.portal.model.BaseXtgn;
import com.portal.model.BaseYh;
import com.portal.service.BaseXtgnService;
import com.portal.service.BaseYhService;
import com.portal.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {
    @Autowired
    private BaseYhService baseYhService;
    @Autowired
    private BaseXtgnService baseXtgnService;

    @RequestMapping(value = {"/"})
    public String view(Model map) {
        return "login";
    }

    @RequestMapping(value = {"/login"})
    public String login(HttpServletRequest request, HttpSession session, String dlmc, String mm) {
        if (Utils.isNotEmpty(dlmc) && Utils.isNotEmpty(mm)) {
            BaseYh baseYh = baseYhService.queryByDlmcAndMm(dlmc, mm);
            if (baseYh != null) {
                List<BaseXtgn> baseXtgns = new ArrayList<BaseXtgn>();
                //处一级菜单外
                List<BaseXtgn> basextgn = new ArrayList<BaseXtgn>();
                // 根据用户编号和该用户第一个一级菜单编号查询子功能项用于显示在页面左端
                List<Map> firstList = baseXtgnService.queryFirstXtgnListByYhbh(baseYh.getYhbh());
                String firstgnxbh = "";
                String firstgnxurl = "";
                if (Utils.isNotEmpty(firstList)) {
                    firstgnxbh = "" + firstList.get(0).get("gnxbh");
                    firstgnxurl = "" + firstList.get(0).get("url");
                }
                List<Map> list = baseXtgnService.queryFirstXtgnListByYhbhAndGnxbh(baseYh.getYhbh(), firstgnxbh);
                createXtgnList(baseXtgns, basextgn, list);
                session.setAttribute("firstList", firstList);
                session.setAttribute("baseYh", baseYh);
                request.setAttribute("baseXtgns", baseXtgns);
                request.setAttribute("baseXtgn", basextgn);
                request.setAttribute("gnxbh", firstgnxbh);
                request.setAttribute("gnxbhurl", firstgnxurl);
                return "index";
            }
            return "login";
        }
        return "login";
    }
    private void createXtgnList(List<BaseXtgn> carryxtgn,List<BaseXtgn> basextgn, List<Map> list) {
        if(Utils.isNotEmpty(list)){
            for (int i = 0; i < list.size(); i++) {
                Map map = list.get(i);
                BaseXtgn carryXtgn = new BaseXtgn();
                carryXtgn.setGnxbh(""+map.get("GNXBH"));
                carryXtgn.setGnxmc(""+map.get("GNXMC"));
                carryXtgn.setPx(Integer.parseInt(""+map.get("PX")) );
                carryXtgn.setUrl(""+map.get("URL"));
                carryXtgn.setSjgnbh(""+map.get("SJGNBH"));
                carryXtgn.setCdjb(Integer.parseInt(""+map.get("CDJB")));
                carryXtgn.setTp(""+map.get("TP"));
                carryXtgn.setBz(""+map.get("BZ"));
                carryXtgn.setZt(""+map.get("ZT"));
                if("2".equals(map.get("CDJB").toString().trim())){
                    carryxtgn.add(carryXtgn);
                }else{
                    basextgn.add(carryXtgn);
                }
            }
        }
    }
}
