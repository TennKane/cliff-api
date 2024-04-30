package top.traviskey.cliffapiinterface.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.traviskey.cliffapiclientsdk.client.CliffApiClient;
import top.traviskey.cliffapiclientsdk.model.entity.User;

@SpringBootTest
class APIClientTest {

    @Autowired
    private CliffApiClient cliffApiClient;

    @Test
    void APIClientTest(){
        User user = new User();
        user.setName("潘誉文");

    }
}