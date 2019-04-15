package site.exception.springbootwebfluxhello.entity;

/**
 * @author 犬小哈 (微信号: 小哈学Java)
 * @site 个人网站: www.exception.site
 * @date 2019/4/15
 * @time 下午9:12
 * @discription
 **/
public class User {

    /**
     * 姓名
     */
    private String name;
    /**
     * 描述
     */
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
