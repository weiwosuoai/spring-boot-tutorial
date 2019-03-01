package site.exception.springbootinterceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import site.exception.springbootinterceptor.interceptor.LoginValidationInterceptor;

/**
 * @author www.exception.site (exception 教程网)
 * @date 2019/2/27
 * @time 12:17
 * @discription
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 配置拦截器
     * @param interceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        // 拦截所有 /admin/** 的访问地址
        interceptorRegistry.addInterceptor(new LoginValidationInterceptor()).addPathPatterns("/admin/**");
    }
}
