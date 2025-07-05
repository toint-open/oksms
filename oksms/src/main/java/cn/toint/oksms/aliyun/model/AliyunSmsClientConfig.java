package cn.toint.oksms.aliyun.model;

import lombok.Data;

@Data
public class AliyunSmsClientConfig {
    private String accessKeyId;
    private String accessKeySecret;
    private String regionId = AliyunRegionEnum.CN_HANGZHOU.getRegionId();
    private String endpoint = AliyunEndpointEnum.CHINA.getValue();
    private int readTimeout = 10000;
    private int connectTimeout = 10000;

    public void regionId(AliyunRegionEnum  aliyunRegionEnum) {
        this.regionId = aliyunRegionEnum.getRegionId();
        this.endpoint = aliyunRegionEnum.getEndpoint().getValue();
    }

    public void endpoint(AliyunEndpointEnum endpointEnum) {
        this.endpoint = endpointEnum.getValue();
    }
}
