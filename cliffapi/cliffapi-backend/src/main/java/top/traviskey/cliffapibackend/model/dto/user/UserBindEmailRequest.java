package top.traviskey.cliffapibackend.model.dto.user;


import lombok.Data;

@Data
public class UserBindEmailRequest {

    /**
     * 邮箱
     */
    private String email;

    /**
     * 验证码
     */
    private String verificationCode;
}
