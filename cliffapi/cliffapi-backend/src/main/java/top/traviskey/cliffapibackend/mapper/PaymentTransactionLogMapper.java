package top.traviskey.cliffapibackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.traviskey.cliffapicommon.model.entity.PaymentTransactionLog;

/**
* @author 关生
* @description 针对表【payment_transaction_log(付款信息)】的数据库操作Mapper
* @createDate 2024-02-29 17:06:18
* @Entity generator.domain.PaymentTransactionLog
*/
@Mapper
public interface PaymentTransactionLogMapper extends BaseMapper<PaymentTransactionLog> {

}




