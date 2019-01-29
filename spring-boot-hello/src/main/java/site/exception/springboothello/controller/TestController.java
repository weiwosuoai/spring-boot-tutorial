package site.exception.springboothello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author www.exception.site(Exception 教程网)
 * @date 2019/1/29
 * @time 13:58
 * @discription
 **/
@RestController
public class TestController {

    @GetMapping("/hello")
    String hello() {
        return "Hello, Spring Boot !";
    }
}

