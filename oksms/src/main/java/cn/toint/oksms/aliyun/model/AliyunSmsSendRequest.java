package cn.toint.oksms.aliyun.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
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
}
