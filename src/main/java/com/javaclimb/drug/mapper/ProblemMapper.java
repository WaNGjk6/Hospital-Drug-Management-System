package com.javaclimb.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaclimb.drug.entity.Problem;
import org.springframework.stereotype.Repository;


/**
 * 问题药品的增删改查Mapper层
 */
@Repository
public interface ProblemMapper extends BaseMapper<Problem> {
}
