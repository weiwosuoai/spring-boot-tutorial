package site.exception.springbootaopwebrequest.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 犬小哈 （微信号：小哈学Java）
 * @site www.exception.site
 * @date 2019/2/12
 * @time 下午9:19
 * @discription
 **/
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
