package com.green.projectTest.todolist;

import com.green.projectTest.todolist.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoListMapper {
    int postTodoList(PostTodoListReq p);
    List<GetTodoListRes> getTodoList(GetTodoListReq p);
    int delTodoList(long listId);
    int putTodoList(PutTodoListReq p);
}
