package com.green.projectTest.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostReq {
    private String email;
    private String upw;
    private String nickname;

    @JsonIgnore
    private String profilePic;
    @JsonIgnore
    private long userId;


}
