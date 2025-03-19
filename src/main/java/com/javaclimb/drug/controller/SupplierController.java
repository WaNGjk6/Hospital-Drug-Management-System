package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping(value = "/supplier")  // /supplier/supplierList
public class SupplierController {
    @Autowired
    private ISupplierService iSupplierService;


    @RequestMapping
    public String login(){
        return "/supplier";
    }


    @RequestMapping(value = "/supplierQueryPage")
    @ResponseBody
    public HashMap<String, Object> supplierQueryPage(String param, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        try {
            IPage<Supplier> iPage = iSupplierService.selectSupperPage(page, limit, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/supplierPage")
    public String supplierPage(){
        return "/supplierPage";
    }


    @RequestMapping(value = "/supplierAdd")
    @ResponseBody
    public Object supplierAdd(Supplier supplier){
        try {
            supplier.setCreatetime(new Date());
            int i = iSupplierService.addSupplier(supplier);

            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/supplierQueryById")
    public String supplierQueryById(@RequestParam(name = "id",required = true) Integer id, Model model){
        Supplier supplier = iSupplierService.querySupplierById(id);
        model.addAttribute("obj",supplier);

        return "/supplierPage";
    }

    @RequestMapping(value = "/supplierEdit")
    @ResponseBody
    public Object supplierEdit(Supplier supplier){
        try {
            int i = iSupplierService.editSupplier(supplier);

            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/supplierDelById")
    @ResponseBody
    public Object supplierDelById(Integer id){
        try {
            int i = iSupplierService.delquerySupplierById(id);

            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/supplierList")
    @ResponseBody
    public Object supplierList(){
        List<Supplier> supplierList = iSupplierService.querySupplierList();
        return ResultMapUtil.getHashMapList(supplierList);
    }
}
