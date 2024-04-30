package top.traviskey.cliffapibackend.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.traviskey.cliffapibackend.service.ProductOrderService;
import top.traviskey.cliffapibackend.utils.RedissonLockUtil;
import top.traviskey.cliffapicommon.model.enums.PayTypeEnum;

import javax.annotation.Resource;

@Slf4j
@Component
public class PayJob {

    @Resource
    private ProductOrderService productOrderService;
    @Resource
    private RedissonLockUtil redissonLockUtil;

    /**
     * 微信订单确认
     * 每25s查询一次未支付过期的订单
     */
    @Scheduled(cron = "0/25 * * * * ?")
    public void wxOrderConfirm() {
        redissonLockUtil.redissonDistributedLocks("wxOrderConfirm", () -> {
            productOrderService.noPayOrderByDurationHandler(PayTypeEnum.WX);
        });
    }
}
