package site.exception.springbootkafka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 犬小哈（公众号：小哈学Java）
 * @date 2019/4/12
 * @time 下午3:05
 * @discription 订单实体类
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private long orderId;
    private String orderNum;
    private LocalDateTime createTime;
}
