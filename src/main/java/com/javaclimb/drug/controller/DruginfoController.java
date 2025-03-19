package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Druginfo;
import com.javaclimb.drug.service.IDruginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;



@Controller
@RequestMapping(value = "/druginfo")
public class DruginfoController {
    @Autowired
    private IDruginfoService iDruginfoService;



    @RequestMapping
    public String login(){
        return "/druginfo";
    }


    @RequestMapping(value = "/druginfoQueryPage")
    @ResponseBody
    public HashMap<String, Object> druginfoQueryPage(String param, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        try {
            IPage<Druginfo> iPage = iDruginfoService.selectSupperPage(page, limit, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/druginfoPage")
    public String druginfoPage(){
        return "/druginfoPage";
    }


    @RequestMapping(value = "/druginfoAdd")
    @ResponseBody
    public Object druginfoAdd(Druginfo druginfo){
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(date);

            int i = iDruginfoService.addDruginfo(druginfo);

            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/druginfoQueryById")
    public String druginfoQueryById(@RequestParam(name = "id",required = true) Integer id, Model model){
        Druginfo druginfo = iDruginfoService.queryDruginfoById(id);
        model.addAttribute("obj",druginfo);

        return "/druginfoPage";
    }

    @RequestMapping(value = "/druginfoEdit")
    @ResponseBody
    public Object druginfoEdit(Druginfo druginfo){
        try {
            int i = iDruginfoService.editDruginfo(druginfo);

            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/druginfoDelById")
    @ResponseBody
    public Object druginfoDelById(Integer id){
        try {
            int i = iDruginfoService.delqueryDruginfoById(id);

            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/druginfoList")
    @ResponseBody
    public Object druginfoList(){
        List<Druginfo> druginfoList =iDruginfoService.queryDruginfoList();
        return ResultMapUtil.getHashMapList(druginfoList);
    }


    @RequestMapping(value = "warranty")
    public String warranty(){
        return "/warranty";
    }

}
