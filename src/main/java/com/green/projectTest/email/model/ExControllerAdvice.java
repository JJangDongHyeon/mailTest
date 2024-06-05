package com.green.projectTest.email.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.mail.internet.AddressException;

//NullPointer 예외가 발생하였을때 이렇게 응답할 것입니다.
@Slf4j
@RestControllerAdvice
public class ExControllerAdvice {
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErrorResult> testing(NullPointerException e){
//        ErrorResult errorResult=new ErrorResult("INVALID_CHECK",e.getMessage());
//        return new ResponseEntity<>(errorResult,HttpStatus.BAD_REQUEST);
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(AddressException.class)
//    public ResponseEntity<ErrorResult> handleAddressException(AddressException e) {
//        String errorMessage = "이메일을 다시 적어주세요";
//        ErrorResult errorResult = new ErrorResult("INVALID_ADDRESS", errorMessage);
//        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResult> validException(MethodArgumentNotValidException e) {
////        String errorMessage = "이메일을 다시 적어주세요";
//        ErrorResult errorResult = new ErrorResult("INVALID_VALIDATION", "유효성 검사를 해주세요");
//        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
//    }



}