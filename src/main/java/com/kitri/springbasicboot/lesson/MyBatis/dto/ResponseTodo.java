package com.kitri.springbasicboot.lesson.MyBatis.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseTodo {

    // 응답할 땐 요청때와 다르게, 생성일 수정일이 있다. (DB기준)
    Long id;
    String content;
    boolean done;
    LocalDateTime createdAt;
    LocalDateTime modifiedAt;

}
