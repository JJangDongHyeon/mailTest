package com.green.projectTest.pet.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PutPetReq {
    @Schema(example = "바둑이", description = "애완동물 이름", requiredMode = Schema.RequiredMode.REQUIRED)
    private String petName;

    @Schema(example = "강아지", description = "애완동물 종류(카테고리)", requiredMode = Schema.RequiredMode.REQUIRED)
    private String petCategory;

    @Schema(example = "sadqwlkm.jpg", description = "애완동물 사진," +
            "사진을 안바꿀땐 petImage에 아무 값이 안들어가도록 해주세요.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String petImage;

    @Schema(example = "icon-1", description = "애완동물 아이콘", requiredMode = Schema.RequiredMode.REQUIRED)
    private String petIcon;

    @Schema(example = "back-1", description = "애완동물 배경색", requiredMode = Schema.RequiredMode.REQUIRED)
    private String petBackColor;

    @Schema(example = "1", description = "애완동물 pk, 무조건 들어가야합니다", requiredMode = Schema.RequiredMode.REQUIRED)
    private long petId;

    @Schema(example = "1", description = "로그인한 유저 pk, 무조건 들어가야합니다", requiredMode = Schema.RequiredMode.REQUIRED)
    private long userId;
}
