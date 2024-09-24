package com.example.to_do_list.controller;

import com.example.to_do_list.DTO.RequestDTO;
import com.example.to_do_list.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class ToDoController {

    private final ToDoService service;

    @PostMapping // Todo 추가
    public ResponseEntity<Void> add(@RequestBody RequestDTO todo) {
        service.addList(todo.getContent());
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created 반환
    }

    @GetMapping // Todo 목록 조회
    public ResponseEntity<List<Object>> getList() {
        List<Object> todos = service.getList();
        return ResponseEntity.ok(todos); // 200 OK 반환
    }

    @PutMapping("/{ori}") // 특정 Todo 수정
    public ResponseEntity<String> edit(@PathVariable String ori, @RequestBody String todo) {
        service.edit(ori, todo); // ori를 통한 수정
        return ResponseEntity.ok("수정 성공: " + ori + "를 " + todo + "로 수정하였습니다."); // 200 OK 반환
    }

    @DeleteMapping("/{ori}") // 특정 Todo 삭제
    public ResponseEntity<String> delete(@PathVariable String ori) {
        service.deleteList(ori); // ori를 통한 삭제
        return ResponseEntity.ok("삭제 성공: " + ori); // 200 OK 반환
    }
}
