package com.kitri.springbasicboot.lesson.mapping;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;


// localhost:8080/students 요청이 들어오면 MappinRestController에서 잡을 수 있다.
// 시작이 localhost:8080/students 요청은 무조건 컨트롤러로 온다.
@RestController
@RequestMapping("/students")
public class MappingRestController {
    static HashMap<Long, Student> students = new HashMap<>();
    // 키 : Long id / 값 : Student 객체

    static {
        // static으로 선언했다면 static 은 아래와 같이 초기화 할 수 있다.
        students.put(1L, new Student(1L,"박준혁"));
        students.put(2L, new Student(2L,"주나영"));
        students.put(3L, new Student(3L,"김성실"));
        students.put(4L, new Student(4L,"한민선"));
    }
    // 레스트컨트롤러를 사용하게 되면 API 방식의 데이터 응답을 해줄 수 있다.

    @GetMapping("/student")
    public String student() {
            return "학생";
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable long id) {
     // getStudent는 method 니까 매개값을 정해줘야 한다. -> @PathVariable 로 동적인 값을 인식해서 Long 으로 id 를 읽겠다. 라는 의미이다.

//        System.out.println(id);
//        return null;
        return students.get(id);
        // 응답을 responseBody에 하는 것이다.
    }
    @GetMapping("")
    public ArrayList<Student> getAll() {
        // 반환 타입이 studentList가 될 것이다.
        // map의 values -> arraylist 가 되야한다.
        // spring 이 알아서 jason 으로 변환
        return new ArrayList<Student>(students.values());
    }

//    @PostMapping(path = "", consumes = {"application/json"})
//    // 매칭할 때 추가적으로 consumes 도 같이 본다.
//    public ArrayList<Student> getAll2() {
//        return new ArrayList<Student>(students.values());
//    }


    @PostMapping(path = "", consumes = {"application/json"})
    // 매칭할 때 추가적으로 consumes 도 같이 본다.
    public Long addStudent() {
        new Student(5l, "김미성");
        return 5L;
    }

    @GetMapping(path = "/produces", produces = {"application/json"})
    public String produces () {
        return "OK";
    }

    // 정규표현식으로 제한도 가능하다.
}

