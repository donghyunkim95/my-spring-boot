package com.kitri.springbasicboot.lesson.filter;

import com.kitri.springbasicboot.lesson.interceptor.LogInterceptor;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    // [ filter ] WebMvcConfigurer 는 스프링프레임워크에서 사용하는 인터페이스 이다.
    // [ interceptor ] 는 다른 걸 사용한다.


    // 레지스터를 등록할 때 FilterRegistrationBean 을 이용하여 등록할 수 있다.
    @Bean
    public FilterRegistrationBean logFilter() {

        FilterRegistrationBean<Filter> filterRegistration = new FilterRegistrationBean<>();
        filterRegistration.setFilter(new LogFilter());
        filterRegistration.setOrder(2);

        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean log2Filter() {

        FilterRegistrationBean<Filter> filterRegistration = new FilterRegistrationBean<>();
        filterRegistration.setFilter(new Log2Filter());
        filterRegistration.setOrder(1);

        return filterRegistration;
    }
}
