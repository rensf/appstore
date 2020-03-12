package com.sys.appstore.annotation;

import com.sys.appstore.exception.GlobalException;
import com.sys.appstore.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckTokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(handler.getClass().isAssignableFrom(HandlerMethod.class)) {

            CheckToken checkToken = ((HandlerMethod)handler).getMethodAnnotation(CheckToken.class);

            if(checkToken == null || !checkToken.mustToke()) {
                return true;
            }

            if(request.getHeader("token") != null) {
                String token = request.getHeader("token");
                if(!redisUtil.hasKey(token)) {
                    throw new GlobalException("20002", "登录过期！请重新登录！");
                }
                return true;
            } else {
                throw new GlobalException("20001", "非法访问！请重新登录！");
            }
        }

        return super.preHandle(request, response, handler);
    }
}
