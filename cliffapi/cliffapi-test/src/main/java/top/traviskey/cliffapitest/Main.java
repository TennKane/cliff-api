package top.traviskey.cliffapitest;

import top.traviskey.cliffapiclientsdk.client.CliffApiClient;
import top.traviskey.cliffapiclientsdk.exception.CliffApiException;
import top.traviskey.cliffapiclientsdk.model.response.LoveTalkResponse;
import top.traviskey.cliffapiclientsdk.model.response.UserResponse;

import javax.annotation.Resource;



public class Main {

    @Resource
    private CliffApiClient cliffApiClient;

    public static void main(String[] args) throws CliffApiException {
        CliffApiClient cliffApiClient = new CliffApiClient("4a81da1bed82d415a7ff8320e7e35db2","123b8fad45c913b1a526ee7bae9ee776");
        LoveTalkResponse loveTalk = cliffApiClient.getLoveTalk();
        System.out.println(loveTalk);
    }

    public void getNameTest(){

    }


}
