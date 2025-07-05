package cn.toint.oksms.aliyun.model;

import com.aliyun.tea.NameInMap;
import lombok.Data;

@Data
public class AliyunSmsSendResponse {
    /**
     * <p>The ID of the delivery receipt.</p>
     * <p>You can call the <a href="~~QuerySendDetails~~">QuerySendDetails</a> operation to query the delivery status based on the receipt ID.</p>
     *
     * <strong>example:</strong>
     * <p>9006197469364984****</p>
     */
    @NameInMap("BizId")
    public String bizId;

    /**
     * <p>The HTTP status code.</p>
     * <ul>
     * <li>The value OK indicates that the request was successful.</li>
     * <li>Other values indicate that the request failed. For more information, see <a href="https://help.aliyun.com/document_detail/101346.html">Error codes</a>.</li>
     * </ul>
     *
     * <strong>example:</strong>
     * <p>OK</p>
     */
    @NameInMap("Code")
    public String code;

    /**
     * <p>The returned message.</p>
     *
     * <strong>example:</strong>
     * <p>OK</p>
     */
    @NameInMap("Message")
    public String message;

    /**
     * <p>The request ID.</p>
     *
     * <strong>example:</strong>
     * <p>F655A8D5-B967-440B-8683-DAD6FF8DE990</p>
     */
    @NameInMap("RequestId")
    public String requestId;
}
