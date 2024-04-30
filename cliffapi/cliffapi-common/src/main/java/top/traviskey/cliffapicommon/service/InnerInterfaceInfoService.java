package top.traviskey.cliffapicommon.service;

import top.traviskey.cliffapicommon.model.entity.InterfaceInfo;


/**
* @author 关生
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-12-05 17:11:19
*/
public interface InnerInterfaceInfoService {

    /**
     * 从数据库中查询模拟接口是否存在（请求路径、请求方法、请求参数）
     */
    InterfaceInfo getInterfaceInfo(String path, String method);
}
