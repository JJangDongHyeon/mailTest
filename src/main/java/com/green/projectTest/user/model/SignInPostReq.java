package com.green.projectTest.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInPostReq {
    private String email;
    private String upw;
}
