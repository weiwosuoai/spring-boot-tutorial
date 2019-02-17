package site.exception.springbootdateformat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author www.exception.site (exception 教程网)
 * @date 2019/2/16
 * @time 20:55
 * @discription
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 配置日期格式化
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }
}
