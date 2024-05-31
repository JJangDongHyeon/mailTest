package com.green.projectTest.pet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostPetReq {
    @Schema(example = "1", description = "로그인된 유저 pk", requiredMode = Schema.RequiredMode.REQUIRED)
    private long userId;

    @Schema(example = "바둑이", description = "애완동물 이름", requiredMode = Schema.RequiredMode.REQUIRED)
    private String petName;

    @Schema(example = "갱얼쥐", description = "애완동물 종류(카테고리)", requiredMode = Schema.RequiredMode.REQUIRED)
    private String petCategory;


    @Schema(example = "fdmlakmsdf.jpg", description = "애완동물 사진", requiredMode = Schema.RequiredMode.REQUIRED)
    private String petImage;

    @Schema(example = "icon-1", description = "애완동물 아이콘", requiredMode = Schema.RequiredMode.REQUIRED)
    private String petIcon;

    @Schema(example = "back-1", description = "애완동물 배경색", requiredMode = Schema.RequiredMode.REQUIRED)
    private String petBackColor;

    @JsonIgnore
    private long petId;
}
