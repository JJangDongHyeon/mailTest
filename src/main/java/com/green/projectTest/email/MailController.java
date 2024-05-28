package com.green.projectTest.email;

import com.green.projectTest.email.model.EmailCheckDto;
import com.green.projectTest.email.model.EmailRequestDto;
import com.green.projectTest.email.model.UserEntityEmail;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {
    private final MailSendService mailService;

    @PostMapping ("/mailSend")
    public String mailSend(@RequestBody @Valid EmailRequestDto emailDto){
        System.out.println("이메일 인증 요청이 들어옴");
        System.out.println("이메일 인증 이메일 :"+emailDto.getEmail());
        return mailService.joinEmail(emailDto.getEmail());
    }
    @PostMapping("/mailauthCheck")
    public boolean AuthCheck(@RequestBody @Valid EmailCheckDto emailCheckDto){
        Boolean Checked=mailService.CheckAuthNum(emailCheckDto.getEmail(),emailCheckDto.getAuthNum());
        if(Checked){
            return Checked;
        }
        else{
            throw new NullPointerException("다시 확인해주세요!");
        }
    }
}
