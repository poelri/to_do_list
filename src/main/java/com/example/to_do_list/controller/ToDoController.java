package com.example.to_do_list.controller;

import com.example.to_do_list.DTO.RequestDTO;
import com.example.to_do_list.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/to-do")
public class ToDoController {
    @Autowired
    ToDoService service;

    @PostMapping //Response 받기 Request 요청
    public ResponseEntity<Void> add(@RequestBody RequestDTO todo) { // param은 주소 body는 통째로, json(key,value)으로 넘어와서
        service.addList(todo.getContent());
        System.out.println(todo.getContent());
        return ResponseEntity.status(HttpStatus.CREATED).build();
        //http://localhost:8081/add?todo=popo
    }

    @GetMapping
    public List<Object> getList() {
        return service.getList();
        //http://localhost:8081/list
    }

    @PutMapping("/{id}")
    public String edit(@RequestParam String ori, String todo) {
        service.edit(ori, todo);
        return "수정 성공 " + ori + "를 " + todo + " 수정하였습니다.";
        // http://localhost:8081/edit?ori=100&todo=poporing
    }

    @DeleteMapping("/{id}")
    public String delete(@RequestParam String todo) {
        service.deleteList(todo);
        return "삭제 성공: " + todo;
        // http://localhost:8081/delete?todo=poporing
    }
}