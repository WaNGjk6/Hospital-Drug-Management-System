package com.javaclimb.drug.controller;

import com.javaclimb.drug.common.ResultMapUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class UserController {

    @RequestMapping(value = "/login")
    public String login(){
        return "/login";
    }

    @RequestMapping(value = "/toLogin")
    @ResponseBody
    public Object toLogin(String username, String password) {
        if (username == null || password == null) {
            return ResultMapUtil.getHashMapLogin("用户名密码不能为空", "2");
         }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token  = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return ResultMapUtil.getHashMapLogin("用户名不存在", "2");
        } catch (IncorrectCredentialsException e) {
            return ResultMapUtil.getHashMapLogin("密码错误", "2");
        }
        return ResultMapUtil.getHashMapLogin("验证成功", "1");
    }

    /**
     * 转向后台首页
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "/index";
    }


    /**
     * 退出登录
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
        
    }
}
