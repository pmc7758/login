package com.pang.config;


import com.pang.interceptors.JWTInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//配置拦截器
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptors())  //true 或 false
                .addPathPatterns("/user/test")  //拦截，需要token验证
                .excludePathPatterns("/user/login");  //放行
    }

}
