package top.traviskey.cliffapibackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 关生
 */
@Data
public class UserNameUpdateRequest implements Serializable {

    private final Long SerialVersionUID = 1L;

    private Long id;

    private String userName;
}
