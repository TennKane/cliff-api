package top.traviskey.cliffapiclientsdk;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import top.traviskey.cliffapiclientsdk.client.CliffApiClient;

/**
 * 配置类，用于配置Cliff API客户端的相关参数
 * @author 关生
 */
@Configuration
@ConfigurationProperties("cliff-api.client")
@Data
@ComponentScan
public class CliffApiClientConfig {

    /**
     * secretId
     */
    private String secretId;

    /**
     * secretId
     */
    private String secretKey;

    /**
     * 返回CliffApiClient的Bean
     *
     * @return CliffApiClient对象
     */
    @Bean
    public CliffApiClient cliffApiClient(){
        return new CliffApiClient(secretId, secretKey);
    }
}
