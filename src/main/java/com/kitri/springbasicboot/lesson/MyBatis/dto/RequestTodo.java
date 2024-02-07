package com.kitri.springbasicboot.lesson.MyBatis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestTodo {

    // 요청할 때 필요한 것, DB에서는 id를 넉넉하게 주기 때문에 Long 으로 바꾼다.
    Long id;
    String content;
    boolean done;

}
