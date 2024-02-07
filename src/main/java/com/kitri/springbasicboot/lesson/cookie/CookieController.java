package com.kitri.springbasicboot.lesson.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cookie")
public class CookieController {

        @PostMapping
        public String makeCookie (HttpServletRequest request, HttpServletResponse response) {
//        System.out.println(request.getCookies());
        Cookie cookie = new Cookie ("id", request.getParameter("id"));
        cookie.setMaxAge(10); // 쿠키 만료기간설정
        response.addCookie(cookie);
        return cookie.getValue();
    }

//        @GetMapping
//        public String readCookie (HttpServletRequest request, HttpServletResponse response) {
//            Cookie [] cookies = request.getCookies();
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("id")) return cookie.getValue();
//                         // getName: key 역할, "name 이 id 일 때 그에 해당하는 쿠키의 값을 리턴해줘라." 라는 의미
//            }
//
//            // 쿠키값이 없다면 null로 반환
//            return null;
//        }

        @GetMapping("/read")
        public String readCookie2 (@CookieValue (name="id", required = false) String id) {
            return id;
        }


        // response에 쿠키를 담아줘야 클라이언트 측에서 쿠키의 유효기간을 세팅할 것이다.
        @DeleteMapping
        public void deleteCookie (HttpServletRequest request, HttpServletResponse response) {
            Cookie [] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
}
