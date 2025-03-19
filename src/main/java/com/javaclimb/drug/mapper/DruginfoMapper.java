package com.javaclimb.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaclimb.drug.entity.Druginfo;
import org.springframework.stereotype.Repository;


/**
 * 药品的增删改查Mapper层
 */
@Repository
public interface DruginfoMapper extends BaseMapper<Druginfo> {
}
