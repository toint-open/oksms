package cn.toint.oksms.email.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.File;
import java.util.List;

@Data
public class MailSendRequest {
    /**
     * 收信人
     */
    @NotEmpty
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

//    /**
//     * 图片与占位符，占位符格式为cid:${cid}
//     */
//    private Map<String, InputStream> imageMap;

    /**
     * 全局共享Session
     */
    private boolean useGlobalSession;
}
