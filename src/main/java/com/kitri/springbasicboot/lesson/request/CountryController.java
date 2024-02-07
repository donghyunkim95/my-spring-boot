package com.kitri.springbasicboot.lesson.request;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;


@RestController
//@RequestMapping("/countries")
public class CountryController {

    static HashMap<String, Country> countries = new HashMap<>();

    static {
        countries.put("한국", new Country("한국", "서울"));
        countries.put("미국", new Country("미국", "워싱턴D.C"));
        countries.put("프랑스", new Country("프랑스", "파리"));
        countries.put("몽골", new Country("몽골", "울란바토르"));
        countries.put("아르헨티나", new Country("아르헨티나", "부에노아이레스"));
    }

    // API 방식에서 전체 리스트 볼 땐 어떻게 할까?
    // static 에 있는 목록들을 ArrayList 로 던져주면 된다.
    @GetMapping
    public ArrayList<Country> countries() {
        return new ArrayList<>(countries.values());
    }

    // 클라이언트에서 보낸 것 서버에서 데이터를 받을 때의 방법 4가지

//    @PostMapping("")
                                //querystring으로 담김 (param)
    public Country addCountry (@RequestParam String name, @RequestParam String capital) {
        countries.put(name, new Country(name, capital));
        return countries.get(name);
    }
//    @PostMapping("")  // postman 에서 raw 에서 JSON으로 보내고 받을때 requestbody 사용
    public String addCountry2 (@RequestBody Country country) {
        countries.put(country.getName(), country);
        return "redirect:/countries";
    }

    // body로 보내서 null 로 들어올 것이다.
    // parameter로 보내줘야 한다.
//    @PostMapping("")  // form
    public Country addCountry3 (@ModelAttribute Country country) {
        countries.put(country.getName(), country); //객체로 받음 (string x)
        return countries.get(country.getName());
    }

    // REntity 통해서 상태번호를 변환
    // 임의로 에러메시지를 넣어줌. (
    // 문제가 없는 거에다가 문제가 있다고 일방적으로 넣어준 것임. => 커스터마이징 할 수 있다.

    @PostMapping("/4")
    public ResponseEntity<Country> addCountry4 (@ModelAttribute Country country) {
        countries.put(country.getName(), country);
        return new ResponseEntity<>(countries.get(country.getName()), HttpStatus.UNAUTHORIZED);
    }
}
