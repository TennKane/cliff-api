package top.traviskey.cliffapicommon.model.vo.analysis;

import lombok.Data;
import top.traviskey.cliffapicommon.model.entity.ProductOrderPayoutRank;
import top.traviskey.cliffapicommon.model.entity.ProductOrderTotalDay;

import java.io.Serializable;
import java.util.List;

/**
 * @author 关生
 */
@Data
public class SalesCardVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 每天收入额
     */
    private List<ProductOrderTotalDay> totalDay;

    /**
     * 收入用户排名
     */
    private List<ProductOrderPayoutRank> payoutRank;
}
