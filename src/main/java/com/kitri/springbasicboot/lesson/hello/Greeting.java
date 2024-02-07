package com.kitri.springbasicboot.lesson.hello;

import org.springframework.context.annotation.ComponentScan;

//@ComponentScan // Greeting 을 Bean 으로 등록해준다.
public interface Greeting {

    String hello();

}