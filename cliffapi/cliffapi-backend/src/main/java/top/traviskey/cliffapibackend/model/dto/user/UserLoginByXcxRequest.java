package top.traviskey.cliffapibackend.model.dto.user;

import lombok.Data;

/**
 * @author 关生
 */
@Data
public class UserLoginByXcxRequest {

    private static final long serialVersionUID = 1L;

    private String code;

    private String scene;
}
