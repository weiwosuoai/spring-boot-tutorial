package site.exception.springboothello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author www.exception.site(Exception 教程网)
 * @date 2019/1/29
 * @time 13:58
 * @discription
 **/
@RestController
@Slf4j
public class TestController {

    @GetMapping("/hello")
    String hello() throws InterruptedException {
        log.info("===================== start =====================");
        // 模拟一个 50 ms 的业务处理时间
        TimeUnit.MILLISECONDS.sleep(50);
        log.info("===================== end =====================");
        return "Hello, Spring Boot !";
    }
}

