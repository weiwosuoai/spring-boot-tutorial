package site.exception.springbootaopwebrequest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import site.exception.springbootaopwebrequest.entity.User;

/**
 * @author www.exception.site (exception 教程网)
 * @date 2019/2/16
 * @time 21:03
 * @discription
 **/
@RestController
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * POST 方式接口测试
     * @param user
     * @return
     */
    @PostMapping("/user")
    public User testPost(@RequestBody User user) {
        logger.info("testPost ...");
        return user;
    }

    /**
     * GET 方式接口测试
     * @return
     */
    @GetMapping("/user")
    public String testGet(@RequestParam("username") String username,
                          @RequestParam("password") String password) {
        logger.info("testGet ...");
        return "success";
    }

    /**
     * 单文件上传接口测试
     * @return
     */
    @PostMapping("/file/upload")
    public String testFileUpload(@RequestParam("file") MultipartFile file) {
        logger.info("testFileUpload ...");
        return "success";
    }

    /**
     * 多文件上传接口测试
     * @return
     */
    @PostMapping("/multiFile/upload")
    public String testMultiFileUpload(@RequestParam("file") MultipartFile[] file) {
        logger.info("testMultiFileUpload ...");
        return "success";
    }
}
