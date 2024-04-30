package top.traviskey.cliffapicommon.model.vo.analysis;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author 关生
 */
@Data
public class InterfaceInfoTotalCountVO implements Serializable {

    private Long id;

    private String name;

    private Long totalInvokes;
}
