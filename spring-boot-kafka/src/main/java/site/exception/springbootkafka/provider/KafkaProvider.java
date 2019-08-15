package site.exception.springbootkafka.provider;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import site.exception.springbootkafka.model.Order;

import java.time.LocalDateTime;

/**
 * @author 犬小哈（公众号：小哈学Java）
 * @date 2019/4/12
 * @time 下午3:05
 * @discription 消息提供者
 **/
@Component
@Slf4j
public class KafkaProvider {

    /**
     * TOPIC
     */
    private static final String TOPIC = "xiaoha";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(long orderId, String orderNum, LocalDateTime createTime) {
        Order order = Order.builder()
                .orderId(orderId)
                .orderNum(orderNum)
                .createTime(createTime)
                .build();

        // 发送消息
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, JSONObject.toJSONString(order));
        // 监听回调
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("## Send message fail ...");
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("## Send message success ...");
            }
        });
    }

}
