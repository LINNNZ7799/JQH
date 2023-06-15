package com.jqh.jqh.config;

import com.jqh.jqh.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    /**
     * Filter（过滤器）、Interceptor（拦截器）几乎拥有相同的功能，有什么区别？
     * 1、Filter是Servlet定义的原生组件。好处，脱离Spring应用也能使用
     * 2、Interceptor是Spring定义的接口。
     */
//    @Autowired
//    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    //拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //所有请求都被拦截包括静态资源！
                .excludePathPatterns("/","/login","/areaman","/fonts/**","/images/**","/js/**","/sql"); //放行的请求
//        registry.addInterceptor(redisUrlCountInterceptor)
//                .addPathPatterns("/**") //所有请求都被拦截包括静态资源！
//                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**"); //放行的请求
    }
}