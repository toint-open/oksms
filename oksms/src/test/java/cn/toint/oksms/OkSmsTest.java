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

package cn.toint.oksms;

import cn.toint.oksms.aliyun.AliyunSmsClient;
import cn.toint.oksms.aliyun.model.AliyunSmsClientConfig;
import cn.toint.oksms.aliyun.model.AliyunSmsSendRequest;
import cn.toint.oksms.aliyun.model.AliyunSmsSendResponse;
import cn.toint.oksms.email.MailClient;
import cn.toint.oksms.email.model.MailClientConfig;
import cn.toint.oksms.email.model.MailSendRequest;
import cn.toint.oksms.email.model.MailSendResponse;
import cn.toint.oksms.util.OkSmsUtil;
import cn.toint.oktool.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

@Slf4j
public class OkSmsTest {
    @Test
    void sendAliyunSms() {
        AliyunSmsClientConfig aliyunSmsClientConfig = new AliyunSmsClientConfig();
        aliyunSmsClientConfig.setAccessKeyId("");
        aliyunSmsClientConfig.setAccessKeySecret("");

        AliyunSmsSendRequest aliyunSmsSendRequest = new AliyunSmsSendRequest();
        aliyunSmsSendRequest.setPhoneNumbers(List.of("", ""));
        aliyunSmsSendRequest.setSignName("整数软件");
        aliyunSmsSendRequest.setTemplateCode("SMS_305130820");
        aliyunSmsSendRequest.setTemplateParam(Map.of("code", OkSmsUtil.smsCode4()));

        AliyunSmsClient aliyunSmsClient = OkSmsUtil.aliyunSms(aliyunSmsClientConfig);
        AliyunSmsSendResponse aliyunSmsSendResponse = aliyunSmsClient.send(aliyunSmsSendRequest);

        log.info("短信下发结果: {}", JacksonUtil.writeValueAsString(aliyunSmsSendResponse));
    }

    @Test
    void sendMail() {
        // 客户端配置
        MailClientConfig mailClientConfig = new MailClientConfig();
        mailClientConfig.setHost("smtpdm.aliyun.com");
        mailClientConfig.setPort(465);
        mailClientConfig.setAuth(true);
        mailClientConfig.setSslEnable(true);
        mailClientConfig.setFrom("整数软件<system@mail.toint.cn>");
        mailClientConfig.setUser("system@mail.toint.cn");
        mailClientConfig.setPass("".toCharArray());

        // 发件信息
        MailSendRequest sendMsgRequest = new MailSendRequest();
        sendMsgRequest.setTos(List.of("599818663@qq.com"));
        sendMsgRequest.setSubject("hello world");
        sendMsgRequest.setContent("hello world");

        // 发送邮件
        MailClient mailClient = OkSmsUtil.mail(mailClientConfig);
        MailSendResponse mailSendResponse = mailClient.send(sendMsgRequest);
        log.info(JacksonUtil.writeValueAsString(mailSendResponse));
    }
}
