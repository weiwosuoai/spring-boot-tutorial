package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 犬小哈（微信公众号: 小哈学Java）
 * @site 个人网站: www.exception.site
 * @date 2019/4/14
 * @time 下午7:49
 * @discription
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot !";
    }
}
