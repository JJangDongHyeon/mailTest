package com.green.projectTest.pet;

import com.green.projectTest.common.CustomFileUtils;
import com.green.projectTest.pet.model.GetPetListRes;
import com.green.projectTest.pet.model.PostPetReq;
import com.green.projectTest.pet.model.PostPetRes;
import com.green.projectTest.pet.model.PutPetReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PetService {
    private final PetMapper mapper;
    private final CustomFileUtils customFileUtils;

    @Transactional
    public PostPetRes postPet(MultipartFile pic , PostPetReq p){

        try {
            String saveFileName = customFileUtils.makeRandomFileName(pic);
            p.setPetImage(saveFileName);
            int affectedRow = mapper.postPet(p);
            String path = String.format("user/%d/%d",p.getUserId(),p.getPetId());
            customFileUtils.makeFolders(path);
            String target = String.format("%s/%s",path,saveFileName);
            customFileUtils.transferTo(pic,target);
        } catch (Exception e){
            throw new RuntimeException("펫 등록 오류");
        }

        return PostPetRes.builder()
                .petId(p.getPetId())
                .userId(p.getUserId())
                .petName(p.getPetName())
                .petCategory(p.getPetCategory())
                .petImage(p.getPetImage())
                .petIcon(p.getPetIcon())
                .petBackColor(p.getPetBackColor()).build();
    }

    public List<GetPetListRes> getPetNameList(long userId){
        List<GetPetListRes> list = mapper.getPetNameList(userId);

        return list;
    }

    public int delPet(long petId){
        int result = mapper.delPet(petId);

        return result;
    }
    @Transactional
    public int putPet(MultipartFile pic, PutPetReq p){

        if (pic != null){
        String saveFileName = customFileUtils.makeRandomFileName(pic);
        p.setPetImage(saveFileName);
        int result = mapper.putPet(p);
            String midPath = String.format("user/%d/%d", p.getUserId(),p.getPetId());
        try {
            String delAbsoluteFolderPath = String.format("%s%s", customFileUtils.uploadPath, midPath);
            customFileUtils.deleteFolder(delAbsoluteFolderPath);

            customFileUtils.makeFolders(midPath);
            String filePath = String.format("%s/%s", midPath, saveFileName);
            customFileUtils.transferTo(pic, filePath);
        } catch (Exception e){
            throw new RuntimeException("애완동물 수정 오류");
        }
        return result;
        } else {
            int result = mapper.putPet(p);
            return result;
        }

    }
}
