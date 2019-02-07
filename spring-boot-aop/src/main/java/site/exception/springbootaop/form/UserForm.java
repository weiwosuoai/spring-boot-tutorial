package site.exception.springbootaop.form;

import java.io.Serializable;

/**
 * @author www.exception.site(Exception 教程网)
 * @date 2019/2/6
 * @time 20:17
 * @discription
 **/
public class UserForm implements Serializable {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

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
}
