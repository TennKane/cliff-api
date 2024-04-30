package top.traviskey.cliffapibackend.service.impl.inner;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import top.traviskey.cliffapibackend.service.UserInterfaceInfoService;
import top.traviskey.cliffapicommon.service.InnerUserInterfaceInfoService;

/**
 * @author 关生
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Autowired
    private UserInterfaceInfoService userInterfaceInfoService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean invoke(Long interfaceInfoId, Long userId) {
        return userInterfaceInfoService.invoke(interfaceInfoId, userId);
    }
}
