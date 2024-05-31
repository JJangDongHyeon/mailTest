package com.green.projectTest.user;

import com.green.projectTest.common.CustomFileUtils;
import com.green.projectTest.common.model.ResultDto;
import com.green.projectTest.email.MailController;
import com.green.projectTest.email.model.EmailCheckDto;
import com.green.projectTest.email.model.EmailRequestDto;
import com.green.projectTest.user.model.*;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final CustomFileUtils customFileUtils;

    @Transactional
    public int postUser(UserPostReq p){
        UserEntity userEntity = mapper.getUserById(p.getEmail());
        if(userEntity != null){
            throw new RuntimeException("이미 있는 아이디입니다!");
        }
        String hashedPassword = BCrypt.hashpw(p.getUpw() , BCrypt.gensalt());
        p.setUpw(hashedPassword);
//        String filename = customFileUtils.makeRandomFileName(file);
//        p.setProfilePic(filename);
//        int result = mapper.postUser(p);
//
//        if(p.getProfilePic() == null){
//            return result;
//        }
//        try {
//            String path = String.format("user/%d" , p.getUserId());
//            customFileUtils.makeFolders(path);
//            String target = String.format("%s/%s", path,filename);
//            customFileUtils.transferTo(file,target);
//        } catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("파일 오류");
//        }
        return mapper.postUser(p);

    }

//    public SignInRes postSignIn(SignInPostReq p) {
//        UserEntity entity = mapper.getUserById(p.getUid());
//        if(entity == null) {
//            throw new RuntimeException("이메일을 확인해주세요");
//        }else if(!BCrypt.checkpw(p.getUpw(), entity.getUpw())) {
//            throw new RuntimeException("비밀번호를 확인해주세요");
//        }
////        //1 > 로그인 성공
////        //2 > 아이디를 확인해 주세요.
////        //3 > 비밀번호를 확인해 주세요.
////        String msg = switch (result) {
////            case 1 -> "로그인 성공";
////            case 2 -> "아이디를 확인해 주세요.";
////            case 3 -> "비밀번호를 확인해 주세요.";
////            default -> "알수 없는 에러 발생";
////        };
//        return SignInRes.builder()
//                .userId(entity.getUserId())
//                .email(entity.getEmail())
//                .profilePic(entity.getProfileUpdate())
//                .nickname(entity.getNickname())
//                .build();
//    }

//    public int patchPassword(ChangePasswordPatchReq p){
//        UserEntity entity = mapper.getUserById(p.getUid());
//        if(entity == null ) {return  2; }
//        if(!BCrypt.checkpw(p.getCurrentPw() , entity.getUpw())) {
//            return  3;
//        }
//        String hashedPassword =  BCrypt.hashpw(p.getNewPw() , BCrypt.gensalt());
//        p.setNewPw(hashedPassword);
//        p.setUserId(entity.getUserId());
//        return mapper.patchPassword(p);
//    }
}
