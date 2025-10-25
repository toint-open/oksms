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

package cn.toint.oksms.email;

import cn.toint.oksms.email.model.MailClientConfig;
import cn.toint.oksms.email.model.MailSendRequest;
import cn.toint.oksms.email.model.MailSendResponse;
import cn.toint.oktool.util.Assert;

import java.util.List;
import java.util.Optional;

/**
 * 邮件客户端
 */
public class MailClient {

    private final MailClientConfig mailClientConfig;

    public MailClient(MailClientConfig mailClientConfig) {
        this.mailClientConfig = mailClientConfig;
        mailClientConfig.defaultIfEmpty();
    }

    /**
     * 发送邮件
     */
    public MailSendResponse send(MailSendRequest request) {

        Assert.notEmptyParam(request.getTos(), "收信人");
        List<String> tos = request.getTos();
        List<String> ccs = Optional.ofNullable(request.getCcs()).orElse(List.of());
        List<String> bccs = Optional.ofNullable(request.getBccs()).orElse(List.of());
        List<String> reply = Optional.ofNullable(request.getReplys()).orElse(List.of());

        String msgId = SMTPMessage.of(mailClientConfig, mailClientConfig.isUseGlobalSession(), mailClientConfig.getDebugOutput())
                // 标题
                .setTitle(request.getSubject())
                // 收件人
                .setTos(tos.toArray(String[]::new))
                // 抄送人
                .setCcs(ccs.toArray(String[]::new))
                // 密送人
                .setBccs(bccs.toArray(String[]::new))
                // 回复地址(reply-to)
                .setReply(reply.toArray(String[]::new))
                // 内容和附件
                .setContent(request.getContent(), request.isHtml())
                .send();

        MailSendResponse mailSendResponse = new MailSendResponse();
        mailSendResponse.setMsgId(msgId);
        return mailSendResponse;
    }
}
