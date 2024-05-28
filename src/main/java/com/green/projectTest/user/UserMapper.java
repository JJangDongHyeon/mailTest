package com.green.projectTest.user;

import com.green.projectTest.user.model.ChangePasswordPatchReq;
import com.green.projectTest.user.model.UserEntity;
import com.green.projectTest.user.model.UserPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUser(UserPostReq p);
    UserEntity getUserById(String uid);
    int patchPassword(ChangePasswordPatchReq p);
}
