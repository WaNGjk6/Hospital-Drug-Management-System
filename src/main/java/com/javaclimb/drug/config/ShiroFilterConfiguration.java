package com.javaclimb.drug.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroFilterConfiguration {

    // 会话管理器配置
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();

        // 禁用URL重写
        sessionManager.setSessionIdUrlRewritingEnabled(false);

        // 配置安全Cookie
        sessionManager.setSessionIdCookie(secureCookie());

        // 设置会话超时时间
        sessionManager.setGlobalSessionTimeout(1800000); // 30分钟

        return sessionManager;
    }

    private SimpleCookie secureCookie() {
        SimpleCookie cookie = new SimpleCookie("JSESSIONID");

        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");

        cookie.setMaxAge(-1);

        return cookie;
    }

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

        // 注入会话管理器
        manager.setSessionManager(sessionManager());

        return manager;
    }

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
