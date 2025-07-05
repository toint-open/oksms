package cn.toint.oksms.util;

import cn.toint.oksms.aliyun.AliyunSmsClient;
import cn.toint.oksms.aliyun.model.AliyunSmsClientConfig;
import cn.toint.oksms.email.MailClient;
import cn.toint.oksms.email.model.MailClientConfig;
import org.dromara.hutool.core.util.RandomUtil;

public class OkSmsUtil {

    /**
     * 邮箱客户端
     */
    public static MailClient mail(MailClientConfig config) {
        return new MailClient(config);
    }

    /**
     * 阿里云短信客户端
     */
    public static AliyunSmsClient aliyunSms(AliyunSmsClientConfig config) {
        return new AliyunSmsClient(config);
    }

    /**
     * 短信验证码
     */
    public static String smsCode4() {
        return String.valueOf(RandomUtil.randomInt(1000, 9999));
    }

    /**
     * 短信验证码
     */
    public static String smsCode6() {
        return String.valueOf(RandomUtil.randomInt(100000, 999999));
    }
}
