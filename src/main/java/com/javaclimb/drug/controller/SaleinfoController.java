package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Saleinfo;
import com.javaclimb.drug.service.ISaleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


@Controller
@RequestMapping(value = "/saleinfo")
public class SaleinfoController {
    @Autowired
    private ISaleinfoService iSaleinfoService;



    @RequestMapping
    public String login(){
        return "/saleinfo";
    }


    @RequestMapping(value = "/saleinfoQueryPage")
    @ResponseBody
    public HashMap<String, Object> saleinfoQueryPage(String param, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        try {
            IPage<Saleinfo> iPage = iSaleinfoService.selectSaleinfoPage(page, limit, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/saleinfoPage")
    public String saleinfoPage(){
        return "/saleinfoPage";
    }


    @RequestMapping(value = "/saleinfoAdd")
    @ResponseBody
    public Object saleinfoAdd(Saleinfo saleinfo){
        try {
//            saleinfo.setOperatetime(new Date());
            int i = iSaleinfoService.addSaleinfo(saleinfo);

            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/saleinfoQueryById")
    public String saleinfoQueryById(@RequestParam(name = "id",required = true) Integer id, Model model){
        Saleinfo saleinfo = iSaleinfoService.querySaleinfoById(id);
        model.addAttribute("obj",saleinfo);

        return "/saleinfoPage";
    }

    @RequestMapping(value = "/saleinfoEdit")
    @ResponseBody
    public Object saleinfoEdit(Saleinfo saleinfo){
        try {
            int i = iSaleinfoService.editSaleinfo(saleinfo);

            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/saleinfoDelById")
    @ResponseBody
    public Object saleinfoDelById(Integer id){
        try {
            int i = iSaleinfoService.delSaleinfoById(id);

            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

}
