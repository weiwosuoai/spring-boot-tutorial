package site.exception.springbootaopwebrequest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.exception.springbootaopwebrequest.entity.User;

/**
 * @author www.exception.site (exception 教程网)
 * @date 2019/2/16
 * @time 21:03
 * @discription
 **/
@RestController
@Slf4j
public class UserController {

    /**
     * 定义一个创建用户的接口
     * @param user
     * @return
     */
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        log.info("create user ...");
        return user;
    }

    /**
     * 定义一个创建用户的接口
     * @param user
     * @return
     */
    @PostMapping("/user/{username}")
    public User createUser(@PathVariable("username") String username, @RequestBody User user) {
        log.info("create user ...");
        return user;
    }
}
