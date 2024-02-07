package com.kitri.springbasicboot.lesson.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller // Bean을 등록해주기 위해 @Controller 작성
public class GreetingController {

    @Qualifier ("englishGreeting")
    @Autowired
    Greeting greeting;


//    @Autowired // 1.생성자 주입
//    public GreetingController(Greeting greeting) {
//        this.greeting = greeting;
//    }

    //    @Autowired // 2.setter 주입
//    public void setGreeting(Greeting greeting) {
//        this.greeting = greeting;
//    }

    //    @Autowired // 3.필드 주입
//    Greeting greeting; // 객체 생성 -> 의존성 주입 으로 : 1.생성자 2.setter 3.필드


    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("hello", greeting.hello());
        return "greeting";

    }
}