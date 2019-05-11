package site.exception.springbootexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiangbing(江冰)
 * @date 2019/5/9
 * @time 下午5:01
 * @discription
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String name;

    private String password;

    private Integer age;
}
