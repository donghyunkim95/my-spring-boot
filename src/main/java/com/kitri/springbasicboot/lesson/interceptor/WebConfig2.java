package com.kitri.springbasicboot.lesson.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig2 implements WebMvcConfigurer {
    // [ filter ] WebMvcConfigurer 는 스프링프레임워크에서 사용하는 인터페이스 이다.
    // [ interceptor ] 는 다른 걸 사용한다.


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .addPathPatterns("/rsp/**"); // 이 경로로 올 때만 내가 걸겠다. 라는 의미
    }
}
