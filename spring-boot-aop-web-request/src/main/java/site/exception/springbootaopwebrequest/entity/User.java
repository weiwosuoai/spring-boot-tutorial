package site.exception.springbootaopwebrequest.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author www.exception.site (exception 教程网)
 * @date 2019/2/16
 * @time 21:00
 * @discription
 **/
@Data
public class User implements Serializable {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    private Long userGroupId;
    private String staffNo;
}
