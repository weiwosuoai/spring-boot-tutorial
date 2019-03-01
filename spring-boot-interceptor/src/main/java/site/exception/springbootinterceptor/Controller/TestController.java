package site.exception.springbootinterceptor.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author www.exception.site (exception 教程网)
 * @date 2019/2/28
 * @time 19:21
 * @discription
 **/
@RestController
public class TestController {

    @GetMapping("/admin/test")
    public String test() {
        System.out.println("test");
        return "success";
    }
}
