
package top.traviskey.cliffapiclientsdk.client;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import top.traviskey.cliffapiclientsdk.exception.ErrorCode;
import top.traviskey.cliffapiclientsdk.exception.ErrorResponse;
import top.traviskey.cliffapiclientsdk.exception.CliffApiException;
import top.traviskey.cliffapiclientsdk.model.BaseRequest;
import top.traviskey.cliffapiclientsdk.model.entity.User;
import top.traviskey.cliffapiclientsdk.model.enums.UrlToMethodEnum;
import top.traviskey.cliffapiclientsdk.model.params.HoroscopeParams;
import top.traviskey.cliffapiclientsdk.model.params.PublicIpParams;
import top.traviskey.cliffapiclientsdk.model.response.*;
import top.traviskey.cliffapiclientsdk.utils.SignUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 调用第三方客户端接口
 *
 * @author 关生
 */
@Slf4j
@Data
public class CliffApiClient {

    private String secretId;

    private String secretKey;

    //todo 网关地址前缀
    private static final String GATEWAY_URL = "http://47.113.220.158:20001";

    public CliffApiClient() {
    }

    public CliffApiClient(String secretId, String secretKey) {
        this.secretId = secretId;
        this.secretKey = secretKey;
    }

    /**
     * 通过POST请求获取用户名
     *
     * @param user 用户信息
     * @return 用户名
     */
    public UserResponse getUsernameByPost(User user) throws CliffApiException {

        return sendRequest(GATEWAY_URL + UrlToMethodEnum.name.getPath(), "POST", user, UserResponse.class);
    }

    /**
     * 通过GET请求获取毒鸡汤
     *
     * @return 毒鸡汤
     */
    public PoisonousChickenSoupResponse getPoisonousChickenSoup() throws CliffApiException {
        return sendRequest(GATEWAY_URL + UrlToMethodEnum.poisonousChickenSoup.getPath(), "GET", null, PoisonousChickenSoupResponse.class);
    }

    /**
     * 获取微博实时热搜榜
     *
     * @return 微博实时热搜榜
     */
    public WeiboHotSearchResponse getWeiboHotSearch() throws CliffApiException {
        return sendRequest(GATEWAY_URL + UrlToMethodEnum.weiboHotSearch.getPath(), "GET", null, WeiboHotSearchResponse.class);
    }

    /**
     * 获取星座运势
     *
     * @param horoscope 星座运势
     * @return 星座运势
     */
    public HoroscopeResponse getHoroscope(HoroscopeParams horoscope) throws CliffApiException {
        return sendRequest(GATEWAY_URL + UrlToMethodEnum.horoscope.getPath(), "POST", horoscope, HoroscopeResponse.class);
    }

    /**
     * 公网ip
     *
     * @param publicIp 公网ip
     * @return 公网ip
     */
    public PublicIpResponse getPublicIp(PublicIpParams publicIp) throws CliffApiException {
        return sendRequest(GATEWAY_URL + UrlToMethodEnum.publicIp.getPath(), "POST", publicIp, PublicIpResponse.class);
    }

    /**
     * 随机壁纸
     *
     * @return 随机壁纸
     * @throws CliffApiException
     */
    public RandomWallpaperResponse getRandomWallpaper() throws CliffApiException {
        return sendRequest(GATEWAY_URL + UrlToMethodEnum.randomWallpaper.getPath(), "GET", null, RandomWallpaperResponse.class);
    }

    /**
     * 土味情话
     * @return 土味情话
     * @throws CliffApiException
     */
    public LoveTalkResponse getLoveTalk() throws CliffApiException {
        return sendRequest(GATEWAY_URL + UrlToMethodEnum.loveTalk.getPath(), "GET", null, LoveTalkResponse.class);
    }

    /**
     * 天气
     * @return 天气
     * @throws CliffApiException
     */
    public WeatherResponse getWeather() throws CliffApiException {
        return sendRequest(GATEWAY_URL + UrlToMethodEnum.weather.getPath(), "GET", null, WeatherResponse.class);
    }

    // todo 2.添加新的接口调用方法

    /**
     * 解析地址和调用接口
     *
     * @param baseRequest
     * @return
     * @throws CliffApiException
     */
    public Object parseAddressAndCallInterface(BaseRequest baseRequest) throws CliffApiException {
        String path = baseRequest.getPath();
        String method = baseRequest.getMethod();
        Map<String, Object> paramsList = baseRequest.getRequestParams();
        HttpServletRequest userRequest = baseRequest.getUserRequest();
        Class<?> clazz = CliffApiClient.class;
        Object result = null;
        try {
            log.info("请求地址：{}，请求方法：{}，请求参数：{}", path, method, paramsList);
            // 获取名称
            if (path.equals(UrlToMethodEnum.name.getPath())) {
                return invokeMethod(UrlToMethodEnum.name.getMethod(), paramsList, User.class);
            }
            // 获取毒鸡汤
            if (path.equals(UrlToMethodEnum.poisonousChickenSoup.getPath())) {
                return invokeMethod(UrlToMethodEnum.poisonousChickenSoup.getMethod());
            }
            // 获取微博热搜榜
            if (path.equals(UrlToMethodEnum.weiboHotSearch.getPath())) {
                return invokeMethod(UrlToMethodEnum.weiboHotSearch.getMethod());
            }
            // 获取星座运势
            if (path.equals(UrlToMethodEnum.horoscope.getPath())) {
                return invokeMethod(UrlToMethodEnum.horoscope.getMethod(), paramsList, HoroscopeParams.class);
            }
            // 获取公网ip
            if (path.equals(UrlToMethodEnum.publicIp.getPath())) {
                // todo 上线时测试是否获取用户的公网ip，目前本机无法获取到X-Real-IP
                String ipAddress = userRequest.getHeader("X-Real-IP");
                if (ipAddress == null || ipAddress.isEmpty()) {
                    log.info("未携带X-Real-IP请求头，尝试获取");
                    ipAddress = userRequest.getRemoteAddr();
                }
                if (ipAddress == null || ipAddress.isEmpty()) {
                    throw new CliffApiException(ErrorCode.NOT_FOUND_ERROR, "获取公网ip失败");
                }
                log.info("获取到的公网ip：", ipAddress);
                paramsList.put("ipAddress", ipAddress);
                return invokeMethod(UrlToMethodEnum.publicIp.getMethod(), paramsList, PublicIpParams.class);
            }
            // 随机壁纸
            if (path.equals(UrlToMethodEnum.randomWallpaper.getPath())) {
                return invokeMethod(UrlToMethodEnum.randomWallpaper.getMethod());
            }
            // 土味情话
            if (path.equals(UrlToMethodEnum.loveTalk.getPath())) {
                return invokeMethod(UrlToMethodEnum.loveTalk.getMethod());
            }
            // 天气信息
            if (path.equals(UrlToMethodEnum.weather.getPath())) {
                return invokeMethod(UrlToMethodEnum.weather.getMethod());
            }

            // todo 1.添加新的接口地址判断
        } catch (CliffApiException e) {
            throw new CliffApiException(e.getCode(), e.getMessage());
        } catch (Exception e){
            throw new CliffApiException(ErrorCode.SYSTEM_ERROR, e.getMessage());
        }
        if (ObjUtil.isEmpty(result)) {
            throw new CliffApiException(ErrorCode.NOT_FOUND_ERROR, "未找到Url对应资源");
        }
        log.info("返回结果：{}", result);
        return result;
    }


    /**
     * 反射方法(不带参数)
     *
     * @param methodName
     * @return
     * @throws CliffApiException
     */
    private Object invokeMethod(String methodName) throws CliffApiException {
        return this.invokeMethod(methodName, null, null);
    }

    /**
     * 反射方法(带参)
     *
     * @param methodName
     * @param params
     * @param paramsType
     * @return
     * @throws CliffApiException
     */
    private Object invokeMethod(String methodName, Map<String, Object> params, Class<?> paramsType) throws CliffApiException {
        try {
            Class<?> clazz = CliffApiClient.class;
            if (params == null) {
                Method method = clazz.getMethod(methodName);
                return method.invoke(this);
            } else {
                log.info("接收到的参数 params:{} paramsType:{}", params, paramsType);
                Method method = clazz.getMethod(methodName, paramsType);
                // map转Object
                Object paramsObject = BeanUtil.mapToBean(params, paramsType, true, CopyOptions.create());
                log.info("map转Object params:{} paramsType:{}", params, paramsType);
                return method.invoke(this, paramsObject);
            }
        } catch (NoSuchMethodException e){
            throw new CliffApiException(ErrorCode.NOT_FOUND_ERROR, "通过url未找到对应方法");
        } catch (Exception e) {
            // 处理异常
            if (e.getCause() instanceof CliffApiException) {
                CliffApiException cliffApiException = (CliffApiException) e.getCause();
                // 处理 CliffApiException 异常
                throw new CliffApiException(cliffApiException.getCode(),cliffApiException.getMessage());
            }
            throw new CliffApiException(ErrorCode.NOT_FOUND_ERROR, e.getMessage());
        }
    }


    /**
     * 发送请求
     *
     * @param url          请求地址
     * @param method       请求方式
     * @param params       请求参数
     * @param responseType 响应类型
     * @param <T>          响应类型
     * @return 响应结果
     * @throws CliffApiException 异常
     */
    public <T> T sendRequest(String url, String method, Object params, Class<T> responseType) throws CliffApiException {
        HttpRequest request;
        String jsonBody = JSON.toJSONString(params);

        switch (method) {
            case "GET":
                log.info("params:{}", params);
                request = HttpRequest.get(url);
                handleParamsAsQueryParams(request, params);
                break;
            case "POST":
                log.info("封装body:{}", jsonBody);
                request = HttpRequest.post(url);
                handleParamsAsBody(request, jsonBody);
                break;
            // Add more cases for other HTTP methods if needed
            default:
                throw new CliffApiException(ErrorCode.PARAMS_ERROR, "请求方式有误");
        }

        // 添加通用请求头
        request.addHeaders(getHeaderMap(jsonBody));
        // 发送请求并获取响应
        HttpResponse response = request.execute();
        String responseBody = response.body();
        log.info("CliffApi开放平台网关返回responseBody:{}", responseBody);
        if (response.getStatus() != 200) {
            // 处理网关返回异常
            ErrorResponse errorResponse = JSONUtil.toBean(responseBody, ErrorResponse.class);
            throw new CliffApiException(errorResponse.getCode(), errorResponse.getMessage());
        }
        // 获取响应体


        // 解析响应体
        return JSON.parseObject(responseBody, responseType);
    }



    private void handleParamsAsQueryParams(HttpRequest request, Object bodyAndParams) {
        if (bodyAndParams != null) {
            Map<String, Object> paramsMap = convertObjectToMap(bodyAndParams);
            for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
                if (entry.getValue() != null) {
                    request.form(entry.getKey(), entry.getValue().toString());
                }
            }
        }
    }

    private void handleParamsAsBody(HttpRequest request, String bodyJson) {
        if (bodyJson != null) {
            // Convert the entire bodyAndParams map to JSON and set it as the request body
            request.header("Content-Type", "application/json; charset=UTF-8")
                    .body(bodyJson);
        }
    }

    private Map<String, Object> convertObjectToMap(Object object) {
        // Use reflection to get all fields and their values from the object
        Map<String, Object> map = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(object));
            } catch (IllegalAccessException e) {
                // Handle the exception as needed
            }
        }
        return map;
    }

    /**
     * 检查配置
     *
     * @param cliffApiClient api客户端
     * @throws CliffApiException 业务异常
     */
    public void checkConfig(CliffApiClient cliffApiClient) throws CliffApiException {
        if (StrUtil.isBlank(cliffApiClient.getSecretId()) && StrUtil.isBlank(cliffApiClient.getSecretKey())) {
            throw new CliffApiException(ErrorCode.NO_AUTH_ERROR, "请先配置密钥AccessKey/SecretKey");
        }
    }

    /**
     * 获取请求头Map
     *
     * @param body 请求体
     * @return 请求头Map
     */
    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-SecretId", secretId);
        // 一定不能发送给后端SecretKey, 后端会自动计算签名
        headerMap.put("X-Nonce", RandomUtil.randomNumbers(4));
        headerMap.put("X-Body", body);
        headerMap.put("X-Timestamp", System.currentTimeMillis() + "");
        headerMap.put("X-Sign", SignUtils.getSign(body, secretKey));
        return headerMap;
    }


}