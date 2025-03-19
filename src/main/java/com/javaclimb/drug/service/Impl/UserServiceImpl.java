package com.javaclimb.drug.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.User;
import com.javaclimb.drug.mapper.UserMapper;
import com.javaclimb.drug.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
 * @author admin
 * @version 1.0.0
 * @ClassName IuserServiceImpl.java
 * @Description TODO  用户service实现类
 * @createTime 2024年09月02日 11:51:00
 */
@Service

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 根据用户查询用户对象
     * @param user
     * @return
     */
    @Override
    public User queryUserByUsername(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        return userMapper.selectOne(wrapper);
    }
}
