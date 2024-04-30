package top.traviskey.cliffapibackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.traviskey.cliffapicommon.model.entity.ProductInfo;

/**
* @author 关生
* @description 针对表【product_info(产品信息)】的数据库操作Mapper
* @createDate 2024-01-25 14:05:11
* @Entity generator.domain.ProductInfo
*/
@Mapper
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {

}




