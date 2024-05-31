package com.green.projectTest.todolist.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PutTodoListReq {
    @Schema(example = "1", description = "할 일 pk", requiredMode = Schema.RequiredMode.REQUIRED)
    private long listId;

    @Schema(example = "산책 시키기", description = "수정 할 내용", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;
}
