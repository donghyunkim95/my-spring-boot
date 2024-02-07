package com.kitri.springbasicboot.lesson.request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

// 국가를 하나 찾아보자
@Controller
@RequestMapping("/countries")
public class RequestResponseController {
    // 국가, 수도 반환해주는

    static HashMap<String, String> countries = new HashMap<>();

    static {
        countries.put("한국", "서울");
        countries.put("미국", "워싱턴D.C");
        countries.put("프랑스", "파리");
        countries.put("몽골", "울란바토르");
        countries.put("아르헨티나", "부에노아이레스");
    }

    static HashMap<String, Country> countries2 = new HashMap<>();

    static {
        countries2.put("한국", new Country("한국", "서울"));
        countries2.put("미국", new Country("미국", "워싱턴D.C"));
        countries2.put("프랑스", new Country("프랑스", "파리"));
        countries2.put("몽골", new Country("몽골", "울란바토르"));
        countries2.put("아르헨티나", new Country("아르헨티나", "부에노아이레스"));
    }


    @GetMapping("/{name}")
    public String searchCountry(@PathVariable String name, Model model) {
        String capital = countries.get(name);
        if (capital == null) {
            throw new RuntimeException("찾으려는 국가가 없습니다.");
        }
        model.addAttribute("name", name);
        model.addAttribute("capital", capital);
        return "/lesson/reqres/countries";
        // 국가랑 수도를 넘겨줘야 하니까 Model model 을 사용해야 한다.
    }

//    @GetMapping("/searchCapital")
//    public String searchCapital(@RequestParam("name") String name, Model model) {
//        // 생략 가능한 3가지 방법
//        // 1. @RequestParam("name") String nam
//        // 2. @RequestParam String name
//        // 3. String name
//        String capital = countries.get(name);
//        if (capital == null) {
//            throw new RuntimeException("찾으려는 국가가 없습니다.");
//        }
//        model.addAttribute("name", name);
//        model.addAttribute("capital", capital);
//        return "/lesson/reqres/countries";
//
//    }

    @GetMapping("/searchCapital")
    public String searchCapital2(@RequestParam String name, Model model) {
        // 생략 가능한 3가지 방법
        // 1. @RequestParam("name") String nam
        // 2. @RequestParam String name
        // 3. String name
        String capital = countries.get(name);
        if (capital == null) {
            throw new RuntimeException("찾으려는 국가가 없습니다.");
        }
        model.addAttribute("name", name);
        model.addAttribute("capital", capital);
        return "/lesson/reqres/countries";

    }


    // 요청하는 것 어떻게 받는지 배워보자!
    // 1. RequestParam
    @PostMapping("/addCountry") // post면 바디에 담겨져서 올것이다.// /addCountry 하면 데이터가 같이 올 것이다.
    public String addCountry(@RequestParam String name, @RequestParam String capital) {
                                                                    // Model model 은 삭제해주었다.
        countries.put(name, capital);
        // 내가 등록한 name 이 잘 등록되었는지 확인하려면 ?
        // searchCapital 적어주기
        return "redirect:/";
    }


    // 2. RequestBody
    @PostMapping("/addCountry2") // post면 바디에 담겨져서 올것이다.// /addCountry 하면 데이터가 같이 올 것이다.
    public void addCountry2(@RequestBody Country country) {
    // 객체를 읽을때 RequestBody를 사용한다.
        countries2.put(country.getName(), country);

    }
}

