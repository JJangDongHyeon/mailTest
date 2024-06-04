package com.green.projectTest.email;

import com.green.projectTest.email.model.UserEntityEmail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailMapper {
    UserEntityEmail getUserByEmail(String email);
}
