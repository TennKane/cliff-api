package top.traviskey.cliffapicommon.model.vo.analysis;

import lombok.Data;
import top.traviskey.cliffapicommon.model.entity.InterfaceInfoProportion;

import java.io.Serializable;
import java.util.List;

@Data
public class ProportionSalesVO implements Serializable {

    public static final Long SerialVersionUID = 1L;

    private List<InterfaceInfoProportion> interfaceInfoProportionList;
}
