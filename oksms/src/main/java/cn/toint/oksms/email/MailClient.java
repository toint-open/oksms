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

import cn.hutool.v7.core.bean.BeanUtil;
import cn.hutool.v7.core.collection.CollUtil;
import cn.hutool.v7.extra.mail.Mail;
import cn.hutool.v7.extra.mail.MailAccount;
import cn.toint.oksms.email.model.MailClientConfig;
import cn.toint.oksms.email.model.MailSendRequest;
import cn.toint.oksms.email.model.MailSendResponse;
import cn.toint.oktool.util.Assert;

import java.io.File;
import java.util.List;

/**
 * 邮件客户端
 */
public class MailClient {

    private final MailAccount mailAccount;

    public MailClient(MailClientConfig mailClientConfig) {
        mailAccount = new MailAccount();
        BeanUtil.copyProperties(mailClientConfig, mailAccount);
    }

    /**
     * 发送邮件
     */
    public MailSendResponse send(MailSendRequest request) {
        Assert.validate(request);

        Mail mail = Mail.of(mailAccount);

        // 设置是否使用全局会话
        mail.setUseGlobalSession(request.isUseGlobalSession());

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
            mail.addFiles(files.toArray(new File[0]));
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
