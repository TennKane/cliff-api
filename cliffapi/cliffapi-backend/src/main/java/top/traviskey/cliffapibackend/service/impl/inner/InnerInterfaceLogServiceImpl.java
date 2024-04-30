package top.traviskey.cliffapibackend.service.impl.inner;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import top.traviskey.cliffapibackend.common.ErrorCode;
import top.traviskey.cliffapibackend.exception.BusinessException;
import top.traviskey.cliffapibackend.service.InterfaceLogService;
import top.traviskey.cliffapicommon.model.entity.InterfaceLog;
import top.traviskey.cliffapicommon.service.InnerInterfaceLogService;

/**
 * @author 关生
 */
@DubboService
@Slf4j
public class InnerInterfaceLogServiceImpl implements InnerInterfaceLogService {

    @Autowired
    InterfaceLogService interfaceLogService;

    @Override
    public boolean save(InterfaceLog interfaceLog) {
        if(interfaceLog == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "interfaceLog为空");
        }
        interfaceLogService.validInterfaceLog(interfaceLog, true);
        log.info("存储接口调用日志：",interfaceLog);
        return interfaceLogService.save(interfaceLog);
    }
}
