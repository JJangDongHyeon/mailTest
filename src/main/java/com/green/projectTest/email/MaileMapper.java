package com.green.projectTest.email;

import com.green.projectTest.email.model.UserEntityEmail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaileMapper {
    UserEntityEmail getUserByEmail(String email);
}
