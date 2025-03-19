package com.javaclimb.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaclimb.drug.entity.Saleinfo;
import org.springframework.stereotype.Repository;


/**
 * 药品销售记录的增删改查Mapper层
 */
@Repository
public interface SaleinfoMapper extends BaseMapper<Saleinfo> {
}
