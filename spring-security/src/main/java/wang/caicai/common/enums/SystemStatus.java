package wang.caicai.common.enums;

/**
 * @author wangpeixu
 * @date 2021/12/5 13:01
 * @message 返回状态码
 */
public enum SystemStatus {
    SUCCESS(200, "成功")

    , ERROR_PARAMETER(400, "参数错误")
    , ERROR_NOT_FOUND(404,"没有找到资源")
    , NOT_LOG_IN(302,"用户没有登录,请先登录")
    , IN_THE_PAYMENT(305,"支付中")
    , UNKNOWN_ERROR(500, "服务器错误")
    ;

    private int code;
    private String message;

    SystemStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
