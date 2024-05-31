package com.green.projectTest.pet;

import com.green.projectTest.pet.model.GetPetListRes;
import com.green.projectTest.pet.model.PostPetReq;
import com.green.projectTest.pet.model.PutPetReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PetMapper {
    int postPet(PostPetReq p);
    List<GetPetListRes> getPetNameList(long userId);
    int delPet(long petId);
    int putPet(PutPetReq p);
}
