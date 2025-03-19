package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.User;


public interface IUserService extends IService<User> {

    public User queryUserByUsername(User user);
}
