package top.traviskey.cliffapibackend.common.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 关生
 */
@Data
public class IdRequest implements Serializable {

    /**
     * 主键
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}
