package com.javaclimb.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaclimb.drug.entity.User;
import org.springframework.stereotype.Repository;


/**
 * 用户表的增删改查Mapper层
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
