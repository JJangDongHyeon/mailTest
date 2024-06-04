package com.green.projectTest.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostReq {
    private String email;

    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z]).{8,16}", message = "비밀번호는 영문과 숫자를 포함하여 8~16자리여야 합니다.")
    private String password;

    @Pattern(regexp = "^([가-힣]*|[a-zA-Z]*)$", message = "한글과 영어를 혼합해서 쓰지말아주세요.")
    private String nickname;
//    private String authNum;

    @JsonIgnore
    private String profilePic;
    @JsonIgnore
    private long userId;


}
