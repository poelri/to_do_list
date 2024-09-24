package com.example.to_do_list.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoDao {

    //리스트 생성
    private List<Object> toDoList=new ArrayList<>();

    // 리스트 추가
    public void add(String todo){
        toDoList.add(todo);
    }

    // 리스트 조회
    public List<Object> getToDoList(){
        return toDoList;
    }

    public void edit(String ori,String todo){
        int index=toDoList.indexOf(ori);
        if (index!=-1){ // 입력한 값이 리스트에 없으면
            toDoList.set(index, todo);
        }else {
            throw new RuntimeException("수정 할거 없어용");
        }
    }

    // 삭제
    public void delete(String todo){
        toDoList.remove(todo);
    }

}
