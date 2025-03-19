package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Returngoods;
import com.javaclimb.drug.service.IReturngoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


@Controller
@RequestMapping(value = "/returngoods")
public class ReturngoodsController {
    @Autowired
    private IReturngoodsService iReturngoodsService;



    @RequestMapping
    public String login(){
        return "/returngoods";
    }


    @RequestMapping(value = "/returngoodsQueryPage")
    @ResponseBody
    public HashMap<String, Object> returngoodsQueryPage(String param, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        try {
            IPage<Returngoods> iPage = iReturngoodsService.selectReturngoodsPage(page, limit, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/returngoodsPage")
    public String returngoodsPage(){
        return "/returngoodsPage";
    }


    @RequestMapping(value = "/returngoodsAdd")
    @ResponseBody
    public Object returngoodsAdd(Returngoods returngoods){
        try {
//            returngoods.setOperatetime(new Date());
            int i = iReturngoodsService.addReturngoods(returngoods);

            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/returngoodsQueryById")
    public String returngoodsQueryById(@RequestParam(name = "id",required = true) Integer id, Model model){
        Returngoods returngoods = iReturngoodsService.queryReturngoodsById(id);
        model.addAttribute("obj",returngoods);

        return "/returngoodsPage";
    }

    @RequestMapping(value = "/returngoodsEdit")
    @ResponseBody
    public Object returngoodsEdit(Returngoods returngoods){
        try {
            int i = iReturngoodsService.editReturngoods(returngoods);

            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/returngoodsDelById")
    @ResponseBody
    public Object returngoodsDelById(Integer id){
        try {
            int i = iReturngoodsService.delReturngoodsById(id);

            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

}
