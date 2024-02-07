package com.kitri.springbasicboot.lesson.mapping;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller // 1. 빈등록
public class MappingController {
    // 2. @ResponseBody : return 값을 responseBody에 넣겠다
    @GetMapping("/get")
    @ResponseBody
    public String get() { // 모델에 담기
        return "hello";
    }

    @GetMapping("/get2")
    public String get2(Model model) { // 모델에 담기
        model.addAttribute("message", "GET2");
        return "/lesson/mapping"; // 뷰를 설정
    }

    @GetMapping("/get3")
    public String get3(HttpServletRequest request) { // 모델에 담기
        request.setAttribute("message", "GET3");
        return "/lesson/mapping"; // 뷰를 설정
    }

    @RequestMapping(value = "/get4", method = RequestMethod.GET)
    public ModelAndView get4(ModelAndView mv) { // 모델에 담기
        mv.addObject("message", "GET4");
        mv.setViewName("/lesson/mapping");
        return mv; // 뷰를 설정
    }

    @RequestMapping(
            value = {"/a", "/b", "/c"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String multiURL(Model model) {
        model.addAttribute("message", "MULTI_URL_MAPPING");// 모델에 담기
        return "/lesson/mapping"; // 뷰를 설정
    }

    @PostMapping("/post")
    public String post(Model model) {
        // postman 다운로드
        model.addAttribute("message", "POST");
        return "/lesson/mapping";
    }
}