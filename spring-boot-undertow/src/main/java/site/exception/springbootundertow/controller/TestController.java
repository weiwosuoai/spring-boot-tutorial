package site.exception.springbootundertow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangbing(江冰)
 * @date 2019/2/22
 * @time 20:20
 * @discription
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "success !";
    }
}
