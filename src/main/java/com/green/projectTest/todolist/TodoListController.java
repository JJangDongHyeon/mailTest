package com.green.projectTest.todolist;

import com.green.projectTest.common.model.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todolist")
public class TodoListController {
    private final TodoListService service;

    @PostMapping
    public ResultDto<>
}
