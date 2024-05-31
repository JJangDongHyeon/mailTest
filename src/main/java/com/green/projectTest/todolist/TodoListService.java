package com.green.projectTest.todolist;

import com.green.projectTest.common.CustomFileUtils;
import com.green.projectTest.todolist.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class TodoListService {
    private final TodoListMapper mapper;
    private final CustomFileUtils customFileUtils;

    @Transactional
    public int postTodoList(PostTodoListReq p){
       int affectedRow =  mapper.postTodoList(p);
        return affectedRow;
    }

    public List<GetTodoListRes> getTodoList(GetTodoListReq p){
        List<GetTodoListRes> list = mapper.getTodoList(p);
        return list;
    }

    public int delTodoList(long listId){
        return mapper.delTodoList(listId);
    }

    public int putTodoList(PutTodoListReq p){
        return mapper.putTodoList(p);
    }
}
