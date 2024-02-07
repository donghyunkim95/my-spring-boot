package com.kitri.springbasicboot.lesson.filter;


import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class Log2Filter implements Filter {
    @Override // Filter를 구현하기 위해 필요한 필수 메서드 (추상 메서드)
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("로그2 메시지 : doFilter() 호출됨");
        chain.doFilter(request, response);
    }

    @Override // default 메서드 (삭제해도 괜찮다.)
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("로그2 메시지 : init() 호출됨");
    }

    @Override
    public void destroy() {
        log.info("로그 메시지2 : destroy() 호출됨");
    }


}
