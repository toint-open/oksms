package cn.toint.oksms.aliyun.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AliyunRegionEnum {
    CN_CHENGDU("cn-chengdu", AliyunEndpointEnum.CHINA),
    CN_SHENZHEN("cn-shenzhen", AliyunEndpointEnum.CHINA),
    CN_HUHEHAOTE("cn-huhehaote", AliyunEndpointEnum.CHINA),
    CN_HANGZHOU("cn-hangzhou", AliyunEndpointEnum.CHINA),
    CN_ZHANGJIAKOU("cn-zhangjiakou", AliyunEndpointEnum.CHINA),
    CN_QINGDAO("cn-qingdao", AliyunEndpointEnum.CHINA);

    private final String regionId;
    private final AliyunEndpointEnum endpoint;
}
