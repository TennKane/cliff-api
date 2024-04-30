package top.traviskey.cliffapibackend.utils.redis;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Redis 数据
 * @author 关生
 */
@Data
public class RedisData {
    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 数据
     */
    private Object data;
}
