package top.traviskey.cliffapibackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 关生
 */
@Data
public class UserLoginXcxCheckRequest implements Serializable {

    private String scene;

    private static final long serialVersionUID = 1L;

}
