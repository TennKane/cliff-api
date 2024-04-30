package top.traviskey.cliffapibackend.model.dto.productorder;

import lombok.Data;

import java.io.Serializable;

/**
 * 支付创建订单dto
 *
 * @author 关生
 */
@Data
public class PayCreateOrderRequest implements Serializable {

    private String payType;

    private Long productId;

    private static final long serialVersionUID = 1L;
}
