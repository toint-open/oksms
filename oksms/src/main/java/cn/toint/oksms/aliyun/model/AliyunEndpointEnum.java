package cn.toint.oksms.aliyun.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 阿里云短信域名
 */
@AllArgsConstructor
@Getter
public enum AliyunEndpointEnum {
    /**
     * 国内
     */
    CHINA("dysmsapi.aliyuncs.com"),

    /**
     * 国际
     */
    INTERNATIONAL("dysmsapi.ap-southeast-1.aliyuncs.com");

    private final String value;
}
