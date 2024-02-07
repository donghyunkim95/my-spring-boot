package com.kitri.springbasicboot.lesson.MyBatis.mappers;
import com.kitri.springbasicboot.lesson.MyBatis.dto.RequestTodo;
import com.kitri.springbasicboot.lesson.MyBatis.dto.ResponseTodo;
import com.kitri.springbasicboot.lesson.MyBatis.todo.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    // 이 인터페이스를 호출해서 쿼리를 날릴 수 있다. -> 기존 DAO 역할
    List<ResponseTodo> findAll();

    // 하나만 가져오는 것
    Todo findById(Long id);

    void save(RequestTodo todo);

    void update(RequestTodo todo);

    void deleteById(Long id);

}

// 데이터베이스에 있는