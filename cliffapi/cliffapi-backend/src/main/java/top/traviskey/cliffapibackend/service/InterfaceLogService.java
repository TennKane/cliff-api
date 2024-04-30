package top.traviskey.cliffapibackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.traviskey.cliffapicommon.model.entity.InterfaceLog;

/**
* @author 关生
* @description 针对表【interface_log】的数据库操作Service
* @createDate 2024-02-22 14:27:42
*/
public interface InterfaceLogService extends IService<InterfaceLog> {

    /**
     * 非空判断
     * @param interfaceLog
     * @param add
     */
     void validInterfaceLog(InterfaceLog interfaceLog, boolean add);

    /**
     * 获取接口调用平均时间（最近一千条）
     * @return
     */
    Integer getInterfaceInfoAverageCost();
}
