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

package cn.toint.oksms.email.model;

import java.util.Arrays;
import java.util.Objects;

public class MailClientConfig {
    /**
     * SMTP服务器域名
     */
    private String host;
    /**
     * SMTP服务端口
     */
    private Integer port;
    /**
     * 是否需要用户名密码验证
     */
    private Boolean auth;
    /**
     * 用户名, 示例: system@mail.toint.cn
     */
    private String user;
    /**
     * 密码<br>
     * 使用char[]保存密码有利于及时擦除<br>
     * 见：https://www.cnblogs.com/okokabcd/p/16456966.html
     */
    private char[] pass;
    /**
     * 发送方，遵循RFC-822标准, 示例: 整数软件<system@mail.toint.cn>
     *
     */
    private String from;
    /**
     * 使用 SSL安全连接
     */
    private Boolean sslEnable;

    /**
     * SMTP超时时长，单位毫秒，缺省值不超时
     */
    private long timeout = 30000;

    /**
     * Socket连接超时值，单位毫秒，缺省值不超时
     */
    private long connectionTimeout = 30000;

    /**
     * Socket写出超时值，单位毫秒，缺省值不超时
     */
    private long writeTimeout = 30000;

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        MailClientConfig that = (MailClientConfig) object;
        return timeout == that.timeout && connectionTimeout == that.connectionTimeout && writeTimeout == that.writeTimeout && Objects.equals(host, that.host) && Objects.equals(port, that.port) && Objects.equals(auth, that.auth) && Objects.equals(user, that.user) && Objects.deepEquals(pass, that.pass) && Objects.equals(from, that.from) && Objects.equals(sslEnable, that.sslEnable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, auth, user, Arrays.hashCode(pass), from, sslEnable, timeout, connectionTimeout, writeTimeout);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Boolean getAuth() {
        return auth;
    }

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public char[] getPass() {
        return pass;
    }

    public void setPass(char[] pass) {
        this.pass = pass;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Boolean getSslEnable() {
        return sslEnable;
    }

    public void setSslEnable(Boolean sslEnable) {
        this.sslEnable = sslEnable;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public long getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(long connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public long getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(long writeTimeout) {
        this.writeTimeout = writeTimeout;
    }
}
