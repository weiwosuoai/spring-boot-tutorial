package site.exception.springbootinterceptor.entity;

import java.io.Serializable;

/**
 * @author www.exception.site (exception 教程网)
 * @date 2019/3/1
 * @time 21:15
 * @discription
 **/
public class User implements Serializable {
    private String usernmae;
    private String password;

    public String getUsernmae() {
        return usernmae;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
