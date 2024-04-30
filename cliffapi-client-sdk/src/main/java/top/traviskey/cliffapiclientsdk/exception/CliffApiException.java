package top.traviskey.cliffapiclientsdk.exception;

public class CliffApiException extends Exception{

    private int code;

    public CliffApiException(int code, String message) {
        super(message);
        this.code = code;
    }

    public CliffApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public CliffApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public CliffApiException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
