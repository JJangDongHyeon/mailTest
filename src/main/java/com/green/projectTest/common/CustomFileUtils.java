package com.green.projectTest.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Component//빈 등록
@Getter
public class CustomFileUtils {
     //file.directory
    public final String uploadPath;//자바 밖에 파일을 두면 컴파일 할 필요가 없다. yaml가서 경로만 바꾸면됨

    public CustomFileUtils(@Value("${file.directory}") String uploadPath) {
        this.uploadPath = uploadPath;
    }
    //yaml에 저장된 경로를 가져와서 쓰는거 실제로는 "${file.directory}"임
    public String makeFolders(String path){
        File folder = new File(uploadPath, path);
        folder.mkdirs();
        return folder.getAbsolutePath();
    }
    //uuid 랜덤파일
    public String makeRandomFileName() {
        return UUID.randomUUID().toString();
    }

    //파일 명에서 확장자
    public String getExt(String fileName) {
        //파일명이 askmv.ddd.jpg 라고 치면 문자열을 자를 위치를 찾아야함
        int idx = fileName.indexOf(".");
        //fileName이 가지고 있는 문자열에서 .을 가지고 있다면 자릿수에 맞는 숫자가 나옴
        int idx2 = fileName.lastIndexOf(".");
        System.out.println("idx: " + idx);
        System.out.println("idx2: " + idx2);
        return fileName.substring(fileName.lastIndexOf("."));
    }

    //랜덤 파일명 with 확장자 만들기
    public String makeRandomFileName(String fileName) {
        return makeRandomFileName() + getExt(fileName);
    }
    //랜덤 파일명 with 확장자 만들기 USING MultipartFile
    public String makeRandomFileName(MultipartFile mf) {
        return mf == null || mf.isEmpty() ? null : makeRandomFileName(mf.getOriginalFilename());
    }
    //파일 저장 (target: 경로 + 파일명)
    public void transferTo(MultipartFile mf, String target) throws Exception {
            File saveFile = new File(uploadPath, target); //최종 경로
            mf.transferTo(saveFile);
        //지금 pic은 메모리에 저장되어있음 이제 File에 저장 할 수있게 옮길거임
        //메소드 호출시 에러 터지면 대부분 throw
    }
    //폴더 삭제                    uploadPath +    "/user/3"
    public void deleteFolder(String absoluteFolderPath) { //D:\2024-01\download\greengram_ver3 상대 주소
        File folder = new File(absoluteFolderPath);
        if(folder.exists() && folder.isDirectory()) {// 폴더가 존재하는지 확인 , 폴더인지 파일인지 확인 (폴더)
            File[] files = folder.listFiles(); // 파일 객체로 객체화 해서 배열 형태로 리턴 해준다.

            for(File f : files) {
                if(f.isDirectory()) {
                    deleteFolder(f.getAbsolutePath());
                } else {
                    f.delete();
                }
            }
            folder.delete();
        }
    }
}

