package top.traviskey.cliffapiclientsdk.exception;

import lombok.Data;

/**
 * 异常响应
 * @author 关生
 */
@Data
public class ErrorResponse {

    private int code;

    private String message;
}