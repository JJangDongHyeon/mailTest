package com.green.projectTest.todolist.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTodoListRes {
    @Schema(example = "1", description = "할 일 pk", requiredMode = Schema.RequiredMode.REQUIRED)
    private long listId;

    @Schema(example = "밥 주기", description = "할 일 내용", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    @Schema(example = "0 or 1", description = "0이면 체크해제 1이면 체크 돼 있음", requiredMode = Schema.RequiredMode.REQUIRED)
    private int isCompleted;

    @Schema(example = "2024-05-30 15:38:30", description = "등록 시간", requiredMode = Schema.RequiredMode.REQUIRED)
    private String createdAt;
}
