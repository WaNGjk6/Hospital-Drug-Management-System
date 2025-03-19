package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Druginfo;

import java.util.List;



public interface IDruginfoService extends IService<Druginfo> {

    public IPage<Druginfo> selectSupperPage(int pageNum,int pagesSize,String param);


    public int addDruginfo(Druginfo druginfo);

    public int editDruginfo(Druginfo druginfo);


    public Druginfo queryDruginfoById(Integer id);


    public int delqueryDruginfoById(Integer id);


    public List<Druginfo> queryDruginfoList();

}
