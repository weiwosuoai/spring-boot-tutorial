package site.exception.springbootdateformat.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import site.exception.springbootdateformat.entity.User;

/**
 * @author www.exception.site (exception 教程网)
 * @date 2019/2/16
 * @time 21:03
 * @discription
 **/
@RestController
public class UserController {

    /**
     * 定义一个创建用户的接口
     * @param user
     * @return
     */
    @PostMapping("/user")
    public String createUser(User user) {
        // 打印创建时间
        System.out.println(user.getCreateTime().toString());
        return "Create user success !";
    }
}
