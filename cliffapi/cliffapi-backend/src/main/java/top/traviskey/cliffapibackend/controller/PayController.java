package top.traviskey.cliffapibackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.traviskey.cliffapibackend.common.BaseResponse;
import top.traviskey.cliffapibackend.common.ResultUtils;
import top.traviskey.cliffapibackend.service.ProductOrderService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 支付
 * @author 关生
 */
@RestController
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Resource
    private ProductOrderService productOrderService;

    /**
     * 解析订单通知结果
     * 通知频率为15s/15s/30s/3m/10m/20m/30m/30m/30m/60m/3h/3h/3h/6h/6h - 总计 24h4m
     *
     * @param notifyData 通知数据
     * @param request    请求
     * @return {@link String}
     */
    @PostMapping("/order/notify")
    public BaseResponse<String> parseOrderNotifyResult(@RequestBody String notifyData, HttpServletRequest request) {
        return ResultUtils.success(productOrderService.doOrderNotify(notifyData, request));
    }

}
