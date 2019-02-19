package site.exception.springbootjackson.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.exception.springbootjackson.entity.User;

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
    public User createUser(@RequestBody User user) {
        System.out.println(user.getCreateTime().toString());
        // 将 user 再以 Json 的形式返回
        return user;
    }
}
