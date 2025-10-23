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

package cn.toint.oksms.aliyun.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AliyunSmsSendRequest {
    /**
     * 接收短信的手机号码
     * 手机号码格式：
     * - 国内短信：+/+86/0086/86 或无任何前缀的手机号码，例如 1390000****。
     * - 国际/港澳台消息：国际区号+号码，例如 852000012****。
     * - 接收测试短信的手机号：必须先在控制台绑定测试手机号后才可以发送。
     * 支持向不同的手机号码发送短信，上限为 1000 个手机号码。批量发送相对于单条发送，及时性稍有延迟。验证码类型的短信，建议单条发送。
     */
    private List<String> phoneNumbers;

    /**
     * 短信签名名称
     * 例如：整数软件
     */
    private String signName;

    /**
     * 短信模板 Code
     * 示例：SMS_15305****
     */
    private String templateCode;

    /**
     * 短信模板变量对应的实际值，请传入JSON 字符串。当您选择的模板内容含有变量时，此参数必填。参数个数应与模板内变量个数一致。
     * 示例：{"name":"张三","number":"1390000****"}
     */
    private Map<String, Object> templateParam;

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        AliyunSmsSendRequest that = (AliyunSmsSendRequest) object;
        return Objects.equals(phoneNumbers, that.phoneNumbers) && Objects.equals(signName, that.signName) && Objects.equals(templateCode, that.templateCode) && Objects.equals(templateParam, that.templateParam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumbers, signName, templateCode, templateParam);
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public Map<String, Object> getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(Map<String, Object> templateParam) {
        this.templateParam = templateParam;
    }
}
