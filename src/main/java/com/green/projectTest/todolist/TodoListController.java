package com.green.projectTest.todolist;

import com.green.projectTest.common.model.ResultDto;
import com.green.projectTest.todolist.model.GetTodoListReq;
import com.green.projectTest.todolist.model.GetTodoListRes;
import com.green.projectTest.todolist.model.PostTodoListReq;
import com.green.projectTest.todolist.model.PutTodoListReq;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/todolist")
public class TodoListController {
    private final TodoListService service;


    @PostMapping
    @Operation(summary = "일정 등록" , description = "")
    public ResultDto<Integer> postTodoList(@ParameterObject @ModelAttribute PostTodoListReq p){
        int listId= service.postTodoList(p);

        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("TodoList 추가 완료")
                .resultData(listId)
                .build();
    }

    @GetMapping
    @Operation(summary = "일정 불러오기" , description = "완료된 일정까지 모두 불러옵니다.")
    public ResultDto<List<GetTodoListRes>> getTodoList(@ParameterObject @ModelAttribute GetTodoListReq p){
        List<GetTodoListRes> list = service.getTodoList(p);

        return ResultDto.<List<GetTodoListRes>>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(list).
                build();
    }


    @DeleteMapping
    @Operation(summary = "일정 삭제" , description = "listId는 일정의 pk")
    public ResultDto<Integer> delTodoList(@ParameterObject @RequestParam long listId){
        int result = service.delTodoList(listId);

        return ResultDto.<Integer>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).
                build();
    }
    @PutMapping
    @Operation(summary = "일정 수정" , description = "listId는 일정의 pk")
    public ResultDto<Integer> putTodoList(@ParameterObject @ModelAttribute PutTodoListReq p){
        int list = service.putTodoList(p);

        return ResultDto.<Integer>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(list).
                build();
    }
}
