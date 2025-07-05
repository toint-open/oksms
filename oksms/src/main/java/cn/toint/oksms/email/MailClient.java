package cn.toint.oksms.email;

import cn.toint.oksms.email.model.MailClientConfig;
import cn.toint.oksms.email.model.MailSendRequest;
import cn.toint.oksms.email.model.MailSendResponse;
import cn.toint.oktool.util.Assert;
import org.dromara.hutool.core.collection.CollUtil;
import org.dromara.hutool.extra.mail.Mail;

import java.io.File;
import java.util.List;

/**
 * 邮件客户端
 */
public class MailClient {

    private final MailClientConfig mailClientConfig;

    public MailClient(MailClientConfig mailClientConfig) {
        this.mailClientConfig = mailClientConfig;
    }

    /**
     * 发送邮件
     */
    public MailSendResponse send(MailSendRequest request) {
        Assert.notNull(request, "邮件发送请求不能为空");
        Assert.validate(request, "邮件发送请求校验失败: {}");

        final Mail mail = Mail.of(mailClientConfig).setUseGlobalSession(request.isUseGlobalSession());

        // 抄送人
        List<String> ccs = request.getCcs();
        if (CollUtil.isNotEmpty(ccs)) {
            mail.setCcs(ccs.toArray(new String[0]));
        }

        // 密送人
        List<String> bccs = request.getBccs();
        if (CollUtil.isNotEmpty(bccs)) {
            mail.setBccs(bccs.toArray(new String[0]));
        }

        // 回信地址
        List<String> replys = request.getReplys();
        if (CollUtil.isNotEmpty(replys)) {
            mail.setReply(replys.toArray(new String[0]));
        }

        // 附件
        List<File> files = request.getFiles();
        if (CollUtil.isNotEmpty(files)) {
            mail.setFiles(files.toArray(new File[0]));
        }

        mail.setTos(request.getTos().toArray(new String[0]));
        mail.setTitle(request.getSubject());
        mail.setContent(request.getContent());
        mail.setHtml(request.isHtml());

        String msgId = mail.send();

        MailSendResponse mailSendResponse = new MailSendResponse();
        mailSendResponse.setMsgId(msgId);
        return mailSendResponse;
    }
}
