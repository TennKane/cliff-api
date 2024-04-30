package top.traviskey.cliffapicommon.service;

import top.traviskey.cliffapicommon.model.entity.InterfaceLog;

public interface InnerInterfaceLogService {

    /**
     * 存储日志
     */
    boolean save(InterfaceLog interfaceLog);

}
