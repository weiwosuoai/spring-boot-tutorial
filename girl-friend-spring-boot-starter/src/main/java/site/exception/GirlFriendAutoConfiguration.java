package site.exception;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author www.exception.site(exception 教程网))
 * @date 2019/1/30
 * @time 11:11
 * @discription
 **/
@Configuration
@ConditionalOnClass(GirlFriendService.class)
@EnableConfigurationProperties(GirlFriendServiceProperties.class)
public class GirlFriendAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public GirlFriendService girlFriendService() {
        return new GirlFriendServiceImpl();
    }
}
