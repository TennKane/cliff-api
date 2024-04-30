package top.traviskey.cliffapicommon.service;

import top.traviskey.cliffapicommon.model.entity.User;

/**
 * 用户服务
 *
 * @author 关生
 
 */
public interface InnerUserService {

    /**
     * 获取数据库中是否已分配给用户密钥（secretId）
     */
    User getInvokeUser(String secretId);
}
