package site.exception.springbootkafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.exception.springbootkafka.provider.KafkaProvider;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 犬小哈（公众号：小哈学Java）
 * @date 2019/4/12
 * @time 下午3:05
 * @discription
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootKafkaApplicationTests {

    @Autowired
    private KafkaProvider kafkaProvider;

    @Test
    public void sendMessage() throws InterruptedException {
        // 发送 1000 个消息
        for (int i = 0; i < 1000; i++) {
            long orderId = i+1;
            String orderNum = UUID.randomUUID().toString();
            kafkaProvider.sendMessage(orderId, orderNum, LocalDateTime.now());
        }

        TimeUnit.MINUTES.sleep(1);
    }

}
