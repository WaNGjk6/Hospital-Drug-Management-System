package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Supplier;

import java.util.List;



public interface ISupplierService extends IService<Supplier> {

    public IPage<Supplier> selectSupperPage(int pageNum,int pagesSize,String param);


    public int addSupplier(Supplier supplier);

    public int editSupplier(Supplier supplier);

    public Supplier querySupplierById(Integer id);


    public int delquerySupplierById(Integer id);


    public List<Supplier> querySupplierList();

}
