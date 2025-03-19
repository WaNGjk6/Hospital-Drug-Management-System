package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Problem;
import com.javaclimb.drug.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;


@Controller
@RequestMapping(value = "/problem")
public class ProblemController {
    @Autowired
    private IProblemService iProblemService;



    @RequestMapping
    public String login(){
        return "/problem";
    }


    @RequestMapping(value = "/problemQueryPage")
    @ResponseBody
    public HashMap<String, Object> problemQueryPage(String param, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        try {
            IPage<Problem> iPage = iProblemService.selectProblemPage(page, limit, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/problemPage")
    public String problemPage(){
        return "/problemPage";
    }


    @RequestMapping(value = "/problemAdd")
    @ResponseBody
    public Object problemAdd(Problem problem){
        try {
            problem.setCreatetime(new Date());
            int i = iProblemService.addProblem(problem);

            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/problemQueryById")
    public String problemQueryById(@RequestParam(name = "id",required = true) Integer id, Model model){
        Problem problem = iProblemService.queryProblemById(id);
        model.addAttribute("obj",problem);

        return "/problemPage";
    }

    @RequestMapping(value = "/problemEdit")
    @ResponseBody
    public Object problemEdit(Problem problem){
        try {
            int i = iProblemService.editProblem(problem);

            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/problemDelById")
    @ResponseBody
    public Object problemDelById(Integer id){
        try {
            int i = iProblemService.delProblemById(id);

            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

}
