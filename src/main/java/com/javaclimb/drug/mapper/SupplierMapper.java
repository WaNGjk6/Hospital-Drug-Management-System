package com.javaclimb.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaclimb.drug.entity.Supplier;
import org.springframework.stereotype.Repository;


/**
 * 供应商的增删改查Mapper层
 */
@Repository
public interface SupplierMapper extends BaseMapper<Supplier> {
}
