package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Returngoods;

public interface IReturngoodsService extends IService<Returngoods> {

    public IPage<Returngoods> selectReturngoodsPage(int pageNum, int pageSize, String param);

    public int addReturngoods(Returngoods returngoods);


    public int editReturngoods(Returngoods returngoods);


    public Returngoods queryReturngoodsById(Integer id);


    public int delReturngoodsById(Integer id);

}
