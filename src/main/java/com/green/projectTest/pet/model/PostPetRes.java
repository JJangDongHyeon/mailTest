package com.green.projectTest.pet.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PostPetRes {
    private long petId;
    private long userId;
    private String petName;
    private String petCategory;
    private String petImage;
    private String petIcon;
    private String petBackColor;
}
