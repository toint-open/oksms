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

import java.io.File;
import java.util.List;
import java.util.Objects;

public class MailSendRequest {
    /**
     * 收信人
     */
    private List<String> tos;

    /**
     * 抄送人列表，可以为null或空
     */
    private List<String> ccs;

    /**
     * 密送人列表，可以为null或空
     */
    private List<String> bccs;

    /**
     * 主题
     */
    private String subject;

    /**
     * 内容
     */
    private String content;

    /**
     * 是否为html
     */
    private boolean html;

    /**
     * 附件列表
     */
    private List<File> files;

    /**
     * 回复地址
     */
    private List<String> replys;

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        MailSendRequest that = (MailSendRequest) object;
        return html == that.html && Objects.equals(tos, that.tos) && Objects.equals(ccs, that.ccs) && Objects.equals(bccs, that.bccs) && Objects.equals(subject, that.subject) && Objects.equals(content, that.content) && Objects.equals(files, that.files) && Objects.equals(replys, that.replys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tos, ccs, bccs, subject, content, html, files, replys);
    }

    public List<String> getTos() {
        return tos;
    }

    public void setTos(List<String> tos) {
        this.tos = tos;
    }

    public List<String> getCcs() {
        return ccs;
    }

    public void setCcs(List<String> ccs) {
        this.ccs = ccs;
    }

    public List<String> getBccs() {
        return bccs;
    }

    public void setBccs(List<String> bccs) {
        this.bccs = bccs;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isHtml() {
        return html;
    }

    public void setHtml(boolean html) {
        this.html = html;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public List<String> getReplys() {
        return replys;
    }

    public void setReplys(List<String> replys) {
        this.replys = replys;
    }
}
