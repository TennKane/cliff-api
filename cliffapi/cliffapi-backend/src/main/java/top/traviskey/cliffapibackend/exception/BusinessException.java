package top.traviskey.cliffapibackend.exception;

import top.traviskey.cliffapibackend.common.ErrorCode;

/**
 * 自定义异常类
 *
 * @author 关生
 
 */
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;


    private final Object data;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.data = null;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.data = null;
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
        this.data = null;
    }

    public BusinessException(int code, Object data, String message) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public BusinessException(ErrorCode errorCode, Object data, String message) {
        super(message);
        this.code = errorCode.getCode();
        this.data = data;
    }

    public int getCode() {
        return code;
    }
}
