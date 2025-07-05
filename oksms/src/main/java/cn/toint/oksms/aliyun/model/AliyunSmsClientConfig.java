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
