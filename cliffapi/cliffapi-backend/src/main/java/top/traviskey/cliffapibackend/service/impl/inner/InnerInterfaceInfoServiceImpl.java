package top.traviskey.cliffapibackend.service.impl.inner;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import top.traviskey.cliffapibackend.common.ErrorCode;
import top.traviskey.cliffapibackend.exception.BusinessException;
import top.traviskey.cliffapibackend.service.InterfaceInfoService;
import top.traviskey.cliffapicommon.model.entity.InterfaceInfo;
import top.traviskey.cliffapicommon.service.InnerInterfaceInfoService;

/**
 * @author 关生
 */
@DubboService
@Slf4j
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Autowired
    InterfaceInfoService interfaceInfoService;

    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        log.info("Dubbo调用查询getInvokeUser  url:{}  method:{}", url, method);
        if (StrUtil.isBlank(url) || StrUtil.isBlank(method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

      //  url = "https://localhost:20001/api/poisonousChickenSoup";
       // method = "GET";
        /*QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq()*/
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url", url).eq("method", method);

      /*  LambdaQueryWrapper<InterfaceInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(InterfaceInfo::getUrl, url).eq(InterfaceInfo::getMethod, method);*/
        InterfaceInfo interfaceInfoServiceOne = interfaceInfoService.getOne(queryWrapper);

        return interfaceInfoServiceOne;
    }
}
