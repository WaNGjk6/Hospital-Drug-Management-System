package com.javaclimb.drug.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试
 */
@Controller
public class TestController {
    @RequestMapping("/testString")
    @ResponseBody
    public String testString(){
        return "...";
    }
}
