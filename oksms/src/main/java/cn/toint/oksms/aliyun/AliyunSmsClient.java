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

package cn.toint.oksms.aliyun;

import cn.toint.oksms.aliyun.model.AliyunSmsClientConfig;
import cn.toint.oksms.aliyun.model.AliyunSmsSendRequest;
import cn.toint.oksms.aliyun.model.AliyunSmsSendResponse;
import cn.toint.oktool.util.Assert;
import cn.toint.oktool.util.JacksonUtil;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.aliyun.teaopenapi.models.Config;
import cn.hutool.v7.core.map.MapUtil;

import java.util.Map;

/**
 * 阿里云短信
 */
public class AliyunSmsClient {

    private final Client client;

    public AliyunSmsClient(AliyunSmsClientConfig aliyunSmsClientConfig) {
        Assert.notNull(aliyunSmsClientConfig, "阿里云短信配置不能为空");

        Config config = new Config();
        config.setAccessKeyId(aliyunSmsClientConfig.getAccessKeyId());
        config.setAccessKeySecret(aliyunSmsClientConfig.getAccessKeySecret());
        config.setEndpoint(aliyunSmsClientConfig.getEndpoint());
        config.setRegionId(aliyunSmsClientConfig.getRegionId());
        config.setReadTimeout(aliyunSmsClientConfig.getReadTimeout());
        config.setConnectTimeout(aliyunSmsClientConfig.getConnectTimeout());

        try {
            client = new Client(config);
        } catch (Exception e) {
            throw new RuntimeException("阿里云短信客户端初始化失败: " + e.getMessage(), e);
        }
    }

    /**
     * 发送短信
     */
    public AliyunSmsSendResponse send(AliyunSmsSendRequest aliyunSmsSendRequest) {
        String phoneNumbers = String.join(",", aliyunSmsSendRequest.getPhoneNumbers());

        try {
            SendSmsRequest sendSmsRequest = new SendSmsRequest();
            sendSmsRequest.setPhoneNumbers(phoneNumbers);
            sendSmsRequest.setSignName(aliyunSmsSendRequest.getSignName());
            sendSmsRequest.setTemplateCode(aliyunSmsSendRequest.getTemplateCode());

            Map<String, Object> templateParam = aliyunSmsSendRequest.getTemplateParam();
            if (MapUtil.isNotEmpty(templateParam)) {
                sendSmsRequest.setTemplateParam(JacksonUtil.writeValueAsString(templateParam));
            }

            SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
            SendSmsResponseBody responseBody = sendSmsResponse.getBody();

            AliyunSmsSendResponse aliyunSmsSendResponse = new AliyunSmsSendResponse();
            aliyunSmsSendResponse.setBizId(responseBody.getBizId());
            aliyunSmsSendResponse.setCode(responseBody.getCode());
            aliyunSmsSendResponse.setMessage(responseBody.getMessage());
            aliyunSmsSendResponse.setRequestId(responseBody.getRequestId());
            return aliyunSmsSendResponse;
        } catch (Exception e) {
            throw new RuntimeException("阿里云短信发送失败: " + e.getMessage(), e);
        }
    }
}
