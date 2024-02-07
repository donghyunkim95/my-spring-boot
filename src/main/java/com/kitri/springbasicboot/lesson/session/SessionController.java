package com.kitri.springbasicboot.lesson.session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {

    @PostMapping
    public String makeSession (HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        // 세션정보를 setAttribute로 담아준다.
        session.setAttribute("id", request.getParameter("id"));
        return (String) session.getAttribute("id");
    }

    // 세션은 request에 담겨있을 것이다.
//    @GetMapping
//    public String readSession (HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        return (String) session.getAttribute("id");
//    }

    @GetMapping("/read")
    public String readSession2 (@SessionAttribute (name = "id", required = false) String id) {
        return id;
    }

    @DeleteMapping
    public void deleteSession (HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null); {
            session.invalidate(); // 세션을 지워주는 역할
        }
    }
}
