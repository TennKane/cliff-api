package top.traviskey.cliffapicommon.model.vo.analysis;

import lombok.Data;
import top.traviskey.cliffapicommon.model.entity.InterfaceLogWeekCount;

import java.io.Serializable;
import java.util.List;

/**
 * @author 关生
 */
@Data
public class TopInterfaceInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 接口调用数（一周）
     */
    private List<InterfaceLogWeekCount> interfaceLogWeekCounts;

    /**
     * 接口调用排行（）
     */
    private List<InterfaceInfoTotalCountVO> interfaceInfoTotalCount;

    /**
     * 最受欢迎
     */
    private String mostPopular;
}
