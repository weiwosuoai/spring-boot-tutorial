package site.exception.springbootmail.service;

/**
 * @author 犬小哈(微信号: 小哈学Java)
 * @site 个人网站: www.exception.site
 * @date 2019/4/10
 * @time 下午4:19
 * @discription
 **/
public interface MailService {

    /**
     * 发送简单文本的邮件
     * @param to
     * @param subject
     * @param content
     * @return
     */
    boolean send(String to, String subject, String content);

    /**
     * 发送 html 的邮件
     * @param to
     * @param subject
     * @param html
     * @return
     */
    boolean sendWithHtml(String to, String subject, String html);

    /**
     * 发送带有图片的 html 的邮件
     * @param to
     * @param subject
     * @param html
     * @param cids
     * @param filePaths
     * @return
     */
    boolean sendWithImageHtml(String to, String subject, String html, String[] cids, String[] filePaths);


    /**
     * 发送带有附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePaths
     * @return
     */
    boolean sendWithWithEnclosure(String to, String subject, String content, String[] filePaths);

}
