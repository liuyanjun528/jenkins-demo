package com.fnm.jenkins.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanjun.liu
 * @date 2020/9/14--20:48
 */
@RestController
public class Test {

    @GetMapping("/test")
    public String tset(){
        return "欢迎来到jenkins";
    }
}
