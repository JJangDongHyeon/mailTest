package com.green.projectTest.todolist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostTodoListReq {
    @JsonIgnore
    private long listId;

    @Schema(example = "1", description = "로그인된 유저 pk", requiredMode = Schema.RequiredMode.REQUIRED)
    private long userId;

    @Schema(example = "밥 주기", description = "할 일 내용", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;
}
