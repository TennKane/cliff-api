package top.traviskey.cliffapibackend.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import top.traviskey.cliffapibackend.service.PayService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 关生
 */
@Service
@Qualifier("ALIPAY")
public class AliPayServiceImpl implements PayService {
    @Override
    public String pay(String outTradeNo, String description, Integer Amount) {
        return null;
    }

    @Override
    public String doPaymentNotify(String notifyData, HttpServletRequest request) {
        return null;
    }
}
