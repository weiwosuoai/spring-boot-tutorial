package site.exception.springbootwebfluxhello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import site.exception.springbootwebfluxhello.entity.User;

/**
 * @author 犬小哈 (微信号: 小哈学Java)
 * @site 个人网站: www.exception.site
 * @date 2019/4/15
 * @time 下午9:12
 * @discription
 **/
@RestController
public class HelloWebFluxController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, WebFlux !";
    }

    @GetMapping("/user")
    public Mono<User> getUser() {
        User user = new User();
        user.setName("犬小哈");
        user.setDesc("欢迎关注我的公众号: 小哈学Java");
        return Mono.just(user);
    }


}
