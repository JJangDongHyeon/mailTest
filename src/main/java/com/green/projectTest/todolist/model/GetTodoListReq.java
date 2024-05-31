package com.green.projectTest.todolist.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTodoListReq {
    @Schema(example = "1", description = "로그인된 유저 pk", requiredMode = Schema.RequiredMode.REQUIRED)
    private long userId;
}
