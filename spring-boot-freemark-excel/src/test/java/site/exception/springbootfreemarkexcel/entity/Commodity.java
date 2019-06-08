package site.exception.springbootfreemarkexcel.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 犬小哈 （微信公众号: 小哈学Java）
 * @site www.exception.site
 * @date 2019/5/21
 * @time 上午10:57
 * @discription
 **/
@Data
@Builder
public class Commodity {
    private String     name;
    private Integer    num;
    private int        num1;
    private BigDecimal price;
    private Double     price2;
    private Float price3;
    private Date       createTime;
    private Long       timestamp;
}
