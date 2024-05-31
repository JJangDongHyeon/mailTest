package com.green.projectTest.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {
    private long userId;
    private String email;
    private String upw;
    private String nickname;
    private String createdAt;
    private String profileUpdate;
}
