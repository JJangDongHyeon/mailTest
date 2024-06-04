package com.green.projectTest.user;

import com.green.projectTest.common.model.ResultDto;
import com.green.projectTest.email.MailSendService;
import com.green.projectTest.user.model.ChangePasswordPatchReq;
import com.green.projectTest.user.model.SignInPostReq;
import com.green.projectTest.user.model.SignInRes;
import com.green.projectTest.user.model.UserPostReq;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;
    private final MailSendService mailSendService;
    @PostMapping("sign-up")
    @Operation(summary = "회원가입" , description = "프로필 사진은 필수가 아님")
    public ResultDto<Integer> postUser(@Valid @RequestBody UserPostReq p){

        String msg;

//        if(mailSendService.CheckAuthNum(p.getEmail(),p.getAuthNum())  ){
           msg = "회원가입 완료";
            int result = service.postUser(p);
            return ResultDto.<Integer>builder()
                    .statusCode(HttpStatus.OK)
                    .resultMsg(msg)
                    .resultData(result).build();
//        } else {
//            msg = "인증번호를 확인해주세요";
//            return ResultDto.<Integer>builder()
//                    .statusCode(HttpStatus.BAD_REQUEST)
//                    .resultMsg(msg)
//                    .build();
//        }


    }

//    @PostMapping("sign-in")
//    public ResultDto<SignInRes> postSignin(@RequestBody SignInPostReq p) {
//        SignInRes result = service.postSignIn(p);
//        return ResultDto.<SignInRes>builder()
//                .statusCode(HttpStatus.OK)
//                .resultMsg("로그인 성공")
//                .resultData(result).build();
//
//
//
//    }
//
//    @PatchMapping("passwordPatch")
//    public ResultDto<Integer> patchPassword(@RequestBody ChangePasswordPatchReq p){
//        int result = service.patchPassword(p);
//
//        return ResultDto.<Integer>builder()
//                .statusCode(HttpStatus.OK)
//                .resultMsg(HttpStatus.OK.toString())
//                .resultData(result)
//                .build();
//    }

}
