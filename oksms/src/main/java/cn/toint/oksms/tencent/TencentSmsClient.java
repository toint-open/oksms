//package cn.toint.oksms.tencent;
//
//public class TencentSmsClient {
//    public TencentSmsClient() {
//        try {
//            // 实例化一个认证对象，入参需要传入腾讯云账户 SecretId，SecretKey。
//            // 为了保护密钥安全，建议将密钥设置在环境变量中或者配置文件中，请参考凭证管理 https://github.com/TencentCloud/tencentcloud-sdk-java?tab=readme-ov-file#%E5%87%AD%E8%AF%81%E7%AE%A1%E7%90%86。
//            // 硬编码密钥到代码中有可能随代码泄露而暴露，有安全隐患，并不推荐。
//            // SecretId、SecretKey 查询: https://console.cloud.tencent.com/cam/capi
//            // Credential cred = new Credential("SecretId", "SecretKey");
//            Credential cred = new Credential(System.getenv("TENCENTCLOUD_SECRET_ID"), System.getenv("TENCENTCLOUD_SECRET_KEY"));
//
//            /* 实例化要请求产品(以sms为例)的client对象
//             * 第二个参数是地域信息，可以直接填写字符串ap-guangzhou，支持的地域列表参考 https://cloud.tencent.com/document/api/382/52071#.E5.9C.B0.E5.9F.9F.E5.88.97.E8.A1.A8 */
//            SmsClient client = new SmsClient(cred, "ap-guangzhou");
//
//            /* 实例化一个请求对象，根据调用的接口和实际情况，可以进一步设置请求参数
//             * 您可以直接查询SDK源码确定接口有哪些属性可以设置
//             * 属性可能是基本类型，也可能引用了另一个数据结构
//             * 推荐使用IDE进行开发，可以方便的跳转查阅各个接口和数据结构的文档说明 */
//            SendSmsRequest req = new SendSmsRequest();
//
//            /* 填充请求参数,这里request对象的成员变量即对应接口的入参
//             * 您可以通过官网接口文档或跳转到request对象的定义处查看请求参数的定义
//             * 基本类型的设置:
//             * 帮助链接：
//             * 短信控制台: https://console.cloud.tencent.com/smsv2
//             * 腾讯云短信小助手: https://cloud.tencent.com/document/product/382/3773#.E6.8A.80.E6.9C.AF.E4.BA.A4.E6.B5.81 */
//
//            /* 短信应用ID: 短信SdkAppId在 [短信控制台] 添加应用后生成的实际SdkAppId，示例如1400006666 */
//            // 应用 ID 可前往 [短信控制台](https://console.cloud.tencent.com/smsv2/app-manage) 查看
//            String sdkAppId = "1400009099";
//            req.setSmsSdkAppId(sdkAppId);
//
//            /* 短信签名内容: 使用 UTF-8 编码，必须填写已审核通过的签名 */
//            // 签名信息可前往 [国内短信](https://console.cloud.tencent.com/smsv2/csms-sign) 或 [国际/港澳台短信](https://console.cloud.tencent.com/smsv2/isms-sign) 的签名管理查看
//            String signName = "腾讯云";
//            req.setSignName(signName);
//
//            /* 模板 ID: 必须填写已审核通过的模板 ID */
//            // 模板 ID 可前往 [国内短信](https://console.cloud.tencent.com/smsv2/csms-template) 或 [国际/港澳台短信](https://console.cloud.tencent.com/smsv2/isms-template) 的正文模板管理查看
//            String templateId = "449739";
//            req.setTemplateId(templateId);
//
//            /* 模板参数: 模板参数的个数需要与 TemplateId 对应模板的变量个数保持一致，若无模板参数，则设置为空 */
//            String[] templateParamSet = {"1234"};
//            req.setTemplateParamSet(templateParamSet);
//
//            /* 下发手机号码，采用 E.164 标准，+[国家或地区码][手机号]
//             * 示例如：+8613711112222， 其中前面有一个+号 ，86为国家码，13711112222为手机号，最多不要超过200个手机号 */
//            String[] phoneNumberSet = {"+8621212313123", "+8612345678902", "+8612345678903"};
//            req.setPhoneNumberSet(phoneNumberSet);
//
//            /* 用户的 session 内容（无需要可忽略）: 可以携带用户侧 ID 等上下文信息，server 会原样返回 */
//            String sessionContext = "";
//            req.setSessionContext(sessionContext);
//
//            /* 短信码号扩展号（无需要可忽略）: 默认未开通，如需开通请联系 [腾讯云短信小助手] */
//            String extendCode = "";
//            req.setExtendCode(extendCode);
//
//            /* 国内短信无需填写该项；国际/港澳台短信已申请独立 SenderId 需要填写该字段，默认使用公共 SenderId，无需填写该字段。注：月度使用量达到指定量级可申请独立 SenderId 使用，详情请联系 [腾讯云短信小助手](https://cloud.tencent.com/document/product/382/3773#.E6.8A.80.E6.9C.AF.E4.BA.A4.E6.B5.81)。*/
//            String senderid = "";
//            req.setSenderId(senderid);
//
//            /* 通过 client 对象调用 SendSms 方法发起请求。注意请求方法名与请求对象是对应的
//             * 返回的 res 是一个 SendSmsResponse 类的实例，与请求对象对应 */
//            SendSmsResponse res = client.SendSms(req);
//
//            // 输出json格式的字符串回包
//            System.out.println(SendSmsResponse.toJsonString(res));
//
//            // 也可以取出单个值，您可以通过官网接口文档或跳转到response对象的定义处查看返回字段的定义
//            // System.out.println(res.getRequestId());
//
//            /* 当出现以下错误码时，快速解决方案参考
//             * [FailedOperation.SignatureIncorrectOrUnapproved](https://cloud.tencent.com/document/product/382/9558#.E7.9F.AD.E4.BF.A1.E5.8F.91.E9.80.81.E6.8F.90.E7.A4.BA.EF.BC.9Afailedoperation.signatureincorrectorunapproved-.E5.A6.82.E4.BD.95.E5.A4.84.E7.90.86.EF.BC.9F)
//             * [FailedOperation.TemplateIncorrectOrUnapproved](https://cloud.tencent.com/document/product/382/9558#.E7.9F.AD.E4.BF.A1.E5.8F.91.E9.80.81.E6.8F.90.E7.A4.BA.EF.BC.9Afailedoperation.templateincorrectorunapproved-.E5.A6.82.E4.BD.95.E5.A4.84.E7.90.86.EF.BC.9F)
//             * [UnauthorizedOperation.SmsSdkAppIdVerifyFail](https://cloud.tencent.com/document/product/382/9558#.E7.9F.AD.E4.BF.A1.E5.8F.91.E9.80.81.E6.8F.90.E7.A4.BA.EF.BC.9Aunauthorizedoperation.smssdkappidverifyfail-.E5.A6.82.E4.BD.95.E5.A4.84.E7.90.86.EF.BC.9F)
//             * [UnsupportedOperation.ContainDomesticAndInternationalPhoneNumber](https://cloud.tencent.com/document/product/382/9558#.E7.9F.AD.E4.BF.A1.E5.8F.91.E9.80.81.E6.8F.90.E7.A4.BA.EF.BC.9Aunsupportedoperation.containdomesticandinternationalphonenumber-.E5.A6.82.E4.BD.95.E5.A4.84.E7.90.86.EF.BC.9F)
//             * 更多错误，可咨询[腾讯云助手](https://tccc.qcloud.com/web/im/index.html#/chat?webAppId=8fa15978f85cb41f7e2ea36920cb3ae1&title=Sms)
//             */
//
//        } catch (TencentCloudSDKException e) {
//            e.printStackTrace();
//        }
//    }
//}
