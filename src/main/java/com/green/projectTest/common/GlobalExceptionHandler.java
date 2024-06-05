package com.green.projectTest.exception;


import com.green.projectTest.email.model.ErrorResult;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        //errors라는 이름의 HashMap을 생성합니다.
        //이 맵은 필드명과 에러 메시지를 저장하는 용도로 사용됩니다.

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            //ex.getBindingResult().getFieldErrors()//유효성 검사에서 실패한 필드들에 대한 에러 정보를 가져옵니다.
            //.forEach(error -> { ... }):
            //각 에러 정보를 순회하면서 처리합니다.
            String fieldName = error.getField();
            //에러가 발생한 필드의 이름을 저장합니다.
            String errorMessage = error.getDefaultMessage();
            //해당 필드의 에러 메시지를 저장합니다.
            //이 메시지는 @Pattern 등의 어노테이션에 정의된 message 값입니다.
            String errorCode = "INVALID_" + fieldName.toUpperCase();
            // 에러 코드 값을 저장합니다.
            //여기서는 필드명을 대문자로 변환한 후, "INVALID_" 문자열을 앞에 붙여서 에러 코드를 생성합니다.

//            if (fieldName.equals("nickname")) {
//                errorCode = "INVALID_NICKNAME";
//            }
            errors.put("code", errorCode);
            errors.put("message", errorMessage);
            //errors 맵에 code 키로 errorCode 값을 저장하고, message 키로 errorMessage 값을 저장합니다.
            //이 맵은 마지막에 에러 응답 객체를 생성하는 데 사용됩니다.
        });

        String code = errors.get("code");
        String message = errors.get("message");
        //errors 맵에서 code와 message 값을 각각 가져옵니다.
        //이 값들을 사용하여 ErrorResult 객체를 생성합니다.

        ErrorResult errorResult = new ErrorResult(code, message);
        //에러 코드를 포함한 응답 본문을 나타냅니다
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
        //생성된 ErrorResult 객체를 ResponseEntity로 감싸서 반환합니다.
        //HTTP 상태 코드는 400 Bad Request로 설정합니다.
    }
}
