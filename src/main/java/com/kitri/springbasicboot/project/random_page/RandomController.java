package com.kitri.springbasicboot.project.random_page;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Random;

@Controller
@RequestMapping("/random")
public class RandomController {

    @GetMapping("/color")
    public String randomColor(Model model) { // 모델에 담기
        Random r = new Random();
        int n = r.nextInt();
        String Hexadecimal = Integer.toHexString(n);
        model.addAttribute("color", "#"+Hexadecimal);
        return "/project/random_page"; // 뷰를 설정
    }

    @GetMapping("/number/{n}")
    @ResponseBody
    public String number (@PathVariable int n) {

        ArrayList<Integer>number = new ArrayList<>();

        for (int i=0; i < n; i++) {
            number.add(i);
        }
        return "Number" + number;
    }
}
