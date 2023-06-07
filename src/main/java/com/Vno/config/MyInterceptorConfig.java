package com.vno.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 全局拦截配置，随着Springboot 启动就会加载
 * @ClassName: MyInterceptorConfig
 * @Author: dx
 * @Date: 2023/6/2 10:19
 * @Version: 1.0
 */
public class MyInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/end/page/**")
                .excludePathPatterns("/end/page/login.html");

    }
}
