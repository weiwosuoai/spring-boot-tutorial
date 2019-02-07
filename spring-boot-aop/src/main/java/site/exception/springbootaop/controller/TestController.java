package site.exception.springbootaop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.exception.springbootaop.form.UserForm;

/**
 * @author www.exception.site(Exception 教程网)
 * @date 2019/2/6
 * @time 20:11
 * @discription
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(String name) {
        return "Hello, Aop !";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserForm userForm) {
        return "Hello, Aop2 !";
    }
}
