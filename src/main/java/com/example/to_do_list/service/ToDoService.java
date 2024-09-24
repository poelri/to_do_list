package com.example.to_do_list.service;

import com.example.to_do_list.repository.ToDoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ToDoService {

    @Autowired
    private ToDoDao toDoDao;

    //추가 수정
    public void addList(String todo){
        toDoDao.add(todo);
    }

    public List<Object> getList(){
        return toDoDao.getToDoList();
    }

    public void edit(String ori, String todo) {
        toDoDao.edit(ori, todo);
    }

    public void deleteList(String todo){
        toDoDao.delete(todo);
    }

}
