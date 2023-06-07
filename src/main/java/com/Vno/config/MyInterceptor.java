package com.vno.config;

import com.vno.common.Common;
import com.vno.entity.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 全局拦截器，如果没有登录，重定向登录页
 * @ClassName: MyIntercepter
 * @Author: dx
 * @Date: 2023/6/2 10:12
 * @Version: 1.0
 */
public class MyInterceptor implements HandlerInterceptor {


    /**
     * @description:所有访问后台的请求先要从这里路过
     * @author: dx
     * @date: 2023/6/2 10:15
     * @param: [request, response, handler]
     * @return: boolean
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute(Common.USER_INFO);
        if(userInfo == null){
            //重定向到登录页
            response.sendRedirect("/end/page/login.html");
            return false;
        }
        return true;
    }
}
