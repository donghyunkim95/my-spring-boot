package com.kitri.springbasicboot.lesson.valid;

import com.kitri.springbasicboot.lesson.valid.dto.SignUpFormDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
    @RequestMapping("/valid")
    public class ValidController {


        @GetMapping
        public String form() {
        return "redirect:/valid/form.html";
    }

    @PostMapping
    public String readForm (@Valid SignUpFormDto form) {
    // 더 쉽게 사용하는 방법 : ModelAttribute ! ModelAttribute는 객체를 받았었다.
        System.out.println(form);
        return "redirect:/valid/success.html";
    }
}
