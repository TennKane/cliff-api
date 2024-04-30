package top.traviskey.cliffapibackend.common.request;


import lombok.Data;

import java.util.List;

/**
 * @author 关生
 */
@Data
public class DeleteListRequest {
    /**
     * id组
     */
    private List<Long> ids;

    private static final long serialVersionUID = 1L;
}
