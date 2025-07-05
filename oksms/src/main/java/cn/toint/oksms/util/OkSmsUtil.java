/*
 * Copyright 2025 Toint (599818663@qq.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
