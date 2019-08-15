package site.exception.springbootkafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author 犬小哈（公众号：小哈学Java）
 * @date 2019/4/12
 * @time 下午3:05
 * @discription 消息消费者
 **/
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "xiaoha", groupId = "group_id")
    public void consume(String message) {
        log.info("## consume message: {}", message);
    }

}
