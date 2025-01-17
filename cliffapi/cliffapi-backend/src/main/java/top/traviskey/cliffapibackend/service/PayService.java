package top.traviskey.cliffapibackend.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 关生
 */
public interface PayService {

    /**
     * 微信支付
     * @param outTradeNo
     * @param description
     * @param Amount
     * @return
     */
    String pay(String outTradeNo, String description, Integer Amount);


    /**
     * 支付回调修改订单状态
     * @param notifyData
     * @param request
     * @return
     */
    String doPaymentNotify(String notifyData, HttpServletRequest request);
}
