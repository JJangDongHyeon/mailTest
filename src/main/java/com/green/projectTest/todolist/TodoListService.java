package com.green.projectTest.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoListService {
    private final TodoListMapper mapper;
}
