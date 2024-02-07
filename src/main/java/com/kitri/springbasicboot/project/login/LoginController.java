package com.kitri.springbasicboot.project.login;

import com.kitri.springbasicboot.lesson.mapping.Student;
import com.kitri.springbasicboot.project.login.dto.LoginSignUpFormDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    static int id = 3;
    static HashMap<Integer, LoginSignUpFormDto> loginList = new HashMap<>();
    // 키 : Long id / 값 : Student 객체

    static {
        // static으로 선언했다면 static 은 아래와 같이 초기화 할 수 있다.
        loginList.put(1, new LoginSignUpFormDto("1111@naver.com", "1111", "1111@naver"));
        loginList.put(2, new LoginSignUpFormDto("2222@naver.com", "2222", "2222@naver"));
    }

    @GetMapping
    public String login() {
        return "redirect:/login/login.html";
    }

    @GetMapping("/signup")
    public String loginSignUp() {
        return "redirect:/login/signup.html";
    }

    @PostMapping("/signup")
    public String signUp(@Valid LoginSignUpFormDto form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 에러가 있을 때
            return "redirect:/login/signup.html";
        }
        if (!form.getPassword1().equals(form.getPassword2())) {
            return "redirect:/login/signup.html";
        }

        for (Map.Entry<Integer, LoginSignUpFormDto> loginLists : loginList.entrySet()) {

            if (loginLists.getValue().getEmail().equals(form.getEmail())
                    || loginLists.getValue().getPassword1().equals(form.getPassword1())) {
                return "redirect:/login/signup.html";
            }
        }
        loginList.put(id, new LoginSignUpFormDto(form.getEmail(), form.getName(), form.getPassword1()));
        id++;
        // 에러가 없을 때
        return "redirect:/login/after-login.html";
    }


    @PostMapping("/loginChk")
    public String loginForm(LoginSignUpFormDto form, HttpServletRequest request) {

        for (Map.Entry<Integer, LoginSignUpFormDto> loginLists : loginList.entrySet()) {
            String emailCheck = loginLists.getValue().getEmail();
            String passwordCheck = loginLists.getValue().getPassword1();

            if (emailCheck.equals(form.getEmail()) && passwordCheck.equals(form.getPassword1())) {
                HttpSession session = request.getSession();
                // 세션정보를 setAttribute로 담아준다.
                session.setAttribute("sessionId", form.getEmail());
                return "redirect:/login/after-login.html";
            }
        }
        return "redirect:/login/login.html";
    }

    @GetMapping("/logout")
    public String deleteSession (HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null); {
            session.invalidate(); // 세션을 지워주는 역할
        }
        return "redirect:/login/login.html";
    }
}

