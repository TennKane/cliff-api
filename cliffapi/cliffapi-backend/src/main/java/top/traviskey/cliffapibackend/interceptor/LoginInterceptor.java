package top.traviskey.cliffapibackend.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.traviskey.cliffapibackend.common.ErrorCode;
import top.traviskey.cliffapibackend.exception.BusinessException;
import top.traviskey.cliffapibackend.utils.UserHolder;
import top.traviskey.cliffapicommon.model.vo.LoginUserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 登录拦截器
 * @author 关生
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoginUserVO user = UserHolder.getUser();
        if(user == null){
            //未获取到登录信息
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        log.debug("LoginInterceptor资源放行.....");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
