package com.kitri.springbasicboot.lesson.MyBatis.todo;
import com.kitri.springbasicboot.lesson.MyBatis.dto.RequestTodo;
import com.kitri.springbasicboot.lesson.MyBatis.dto.ResponseTodo;
import com.kitri.springbasicboot.lesson.MyBatis.mappers.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {

    @Autowired
    TodoMapper todoMapper;

    @GetMapping("")
    public ArrayList<ResponseTodo> todos() {
        ArrayList<ResponseTodo> ResponseTodos = (ArrayList<ResponseTodo>) todoMapper.findAll();
        return ResponseTodos;
    }

//    @PostMapping
//    public void add(@RequestBody RequestTodo todo) {
//        todoMapper.save(todo);
//    }
//
//    @PutMapping
//    public void line(@RequestBody RequestTodo todo) {
//        todoMapper.save(todo);
//    }

    //등록
    @PostMapping("/addTodo")
    public void add(@RequestBody RequestTodo todo) {
        todoMapper.save(todo);
    }


    //취소선 상태 유지
    @PutMapping("/updateTodo")//rest 방식을 사용하려면 ("{id}") 규칙을 지켜야함
    public void update(@RequestBody RequestTodo todo){
        todoMapper.update(todo);
    }

    //삭제 상태 유지
    @DeleteMapping("/deleteTodo")//rest 방식을 사용하려면 ("{id}") 규칙을 지켜야함
    public void delete(@RequestBody RequestTodo todo){
        todoMapper.deleteById(todo.getId());
    }
}
