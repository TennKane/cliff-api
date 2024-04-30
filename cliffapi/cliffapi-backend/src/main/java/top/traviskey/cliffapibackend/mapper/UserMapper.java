package top.traviskey.cliffapibackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.traviskey.cliffapicommon.model.entity.User;

/**
 * 用户数据库操作
 *
 * @author 关生
 
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




