package site.exception.springbootjetty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author www.exception.site (exception 教程网)
 * @date 2019/2/25
 * @time 19:58
 * @discription
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "success !";
    }
}
