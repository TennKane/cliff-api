package top.traviskey.cliffapibackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 关生
 */
@Data
public class UserUpdatePasswordRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String oldPassword;

    private String newPassword;

    private String checkNewPassword;
}
