package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Owinfo;
import com.javaclimb.drug.service.IOwinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Date;
import java.util.HashMap;



@Controller
@RequestMapping(value = "/owinfo")
public class OwinfoController {
    @Autowired
    private IOwinfoService iOwinfoService;



    @RequestMapping
    public String login(){
        return "/owinfo";
    }


    @RequestMapping(value = "/owinfoQueryPage")
    @ResponseBody
    public HashMap<String, Object> owinfoQueryPage(String param, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        try {
            IPage<Owinfo> iPage = iOwinfoService.selectOwinfoPage(page, limit, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/owinfoPage")
    public String owinfoPage(){
        return "/owinfoPage";
    }


    @RequestMapping(value = "/owinfoAdd")
    @ResponseBody
    public Object owinfoAdd(Owinfo owinfo){
        try {
            owinfo.setCreatetime(new Date());
            int i = iOwinfoService.addOwinfo(owinfo);

            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/owinfoQueryById")
    public String owinfoQueryById(@RequestParam(name = "id",required = true) Integer id, Model model){
        Owinfo owinfo = iOwinfoService.queryOwinfoById(id);
        model.addAttribute("obj",owinfo);

        return "/owinfoPage";
    }

    @RequestMapping(value = "/owinfoEdit")
    @ResponseBody
    public Object owinfoEdit(Owinfo owinfo){
        try {
            int i = iOwinfoService.editOwinfo(owinfo);

            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/owinfoDelById")
    @ResponseBody
    public Object owinfoDelById(Integer id){
        try {
            int i = iOwinfoService.delOwinfoById(id);

            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

}
