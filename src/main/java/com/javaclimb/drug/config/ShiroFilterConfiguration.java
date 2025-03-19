package com.javaclimb.drug.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroFilterConfiguration {


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager());

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/static/**","anon");
        filterMap.put("/login","anon");
        filterMap.put("/toLogin","anon");
        filterMap.put("/**","authc");
        factoryBean.setFilterChainDefinitionMap(filterMap);

        factoryBean.setLoginUrl("/login");


        factoryBean.setSuccessUrl("/index");
        return factoryBean;
    }


    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm());
        return manager;
    }


    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }


    @Bean
    public ShiroDialect shiroDialect(){
        return  new ShiroDialect();
    }
}
