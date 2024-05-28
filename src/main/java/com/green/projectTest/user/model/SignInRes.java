package com.green.projectTest.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder

public class SignInRes {
    private long userId;
    private String email;
    private String nickname;
    private String profilePic;
}
