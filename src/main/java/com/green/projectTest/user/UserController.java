package com.green.projectTest.user;

import com.green.projectTest.common.model.ResultDto;
import com.green.projectTest.email.MailSendService;
import com.green.projectTest.email.model.ErrorResult;
import com.green.projectTest.user.model.ChangePasswordPatchReq;
import com.green.projectTest.user.model.SignInPostReq;
import com.green.projectTest.user.model.SignInRes;
import com.green.projectTest.user.model.UserPostReq;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;
    private final MailSendService mailSendService;

    @PostMapping("sign-up")
    @Operation(summary = "회원가입", description = "프로필 사진은 필수가 아님")
    public ResponseEntity<ErrorResult> postUser(@Valid @RequestBody UserPostReq p) {
        String msg = "회원가입에 성공했습니다.";

        int result = service.postUser(p);
        ErrorResult successResult = new ErrorResult("OK", msg);
        return new ResponseEntity<>(successResult, HttpStatus.OK);
    }

}
