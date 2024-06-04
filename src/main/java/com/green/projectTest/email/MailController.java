package com.green.projectTest.email;

import com.green.projectTest.email.model.EmailCheckDto;
import com.green.projectTest.email.model.EmailRequestDto;
import com.green.projectTest.email.model.UserEntityEmail;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.*;
import java.io.UnsupportedEncodingException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/mail")
public class MailController {
    private final MailSendService mailService;

    @PostMapping ("/send")
    public String mailSend(@RequestBody @Valid EmailRequestDto emailDto) throws AddressException  {
        try {
            System.out.println("이메일 인증 요청이 들어옴");
            System.out.println("이메일 인증 이메일 :" + emailDto.getEmail());
            return mailService.joinEmail(emailDto.getEmail());
        } catch (Exception e){
            throw new AddressException();
        }
    }

    @PostMapping("/auth_check")
    public boolean AuthCheck(@RequestBody @Valid EmailCheckDto emailCheckDto){
        Boolean Checked= mailService.CheckAuthNum(emailCheckDto.getEmail(),emailCheckDto.getAuthNum());
        if(Checked){
            return Checked;
        }
        else{
            throw new NullPointerException("다시 확인해주세요!");
        }
    }
}
