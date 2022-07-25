package wang.caicai.common.exceptionHandler;


import lombok.Getter;
import wang.caicai.common.enums.SystemStatus;

/**
 * @author wangpeixu
 * @date 2021/12/5 21:37
 * @description 自定义异常
 */
@Getter
public class SystemRuntimeException extends RuntimeException {
    private int code;
    private String message;

    public SystemRuntimeException(SystemStatus systemStatus) {
        super(systemStatus.getMessage());
        this.code = systemStatus.getCode();
        this.message = systemStatus.getMessage();
    }

    public SystemRuntimeException(SystemStatus systemStatus, String message) {
        super(systemStatus.getMessage());
        this.code = systemStatus.getCode();
        this.message = message;
    }

    public SystemRuntimeException(SystemStatus systemStatus, Throwable throwable) {
        super(throwable);
        this.code = systemStatus.getCode();
        this.message = systemStatus.getMessage();
    }

}
