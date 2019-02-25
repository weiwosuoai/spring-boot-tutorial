package site.exception;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author www.exception.site(exception 教程网)
 * @date 2019/1/30
 * @time 11:07
 * @discription
 **/
public class GirlFriendServiceImpl implements GirlFriendService {

    @Autowired
    private GirlFriendServiceProperties girlFriendServiceProperties;

    /**
     * 打招呼
     *
     */
    @Override
    public void say() {
        String message = girlFriendServiceProperties.getMessage();
        System.out.println("Girl Friend: " + message);
    }
}
