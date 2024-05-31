package com.green.projectTest.pet;

import com.green.projectTest.common.model.ResultDto;
import com.green.projectTest.pet.model.GetPetListRes;
import com.green.projectTest.pet.model.PostPetReq;
import com.green.projectTest.pet.model.PostPetRes;
import com.green.projectTest.pet.model.PutPetReq;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/pet")
public class PetController {
    private final PetService service;

    @PostMapping
    @Operation(summary = "애완동물 등록" , description = "애완동물 등록" )
    public ResultDto<PostPetRes> postPet(@RequestPart MultipartFile pic , @RequestPart PostPetReq p){
        PostPetRes result = service.postPet(pic, p);

        return ResultDto.<PostPetRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result)
                .build();
    }

    @GetMapping
    @Operation(summary = "애완동물 불러오기" , description = "애완동물 선택창에 있는, 이름만 불러오기" +
            "                                              userId는 로그인한 유저 pk")
    public ResultDto<List<GetPetListRes>> getPetNameList(@RequestParam long userId){
        List<GetPetListRes> list = service.getPetNameList(userId);

        return ResultDto.<List<GetPetListRes>>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(list).
                build();
    }

    @DeleteMapping
    @Operation(summary = "애완동물 삭제" , description = "애완동물 선택창에 있는, 애완동물 삭제" +
            "                                           userId는 로그인한 유저 pk" )
    public ResultDto<Integer> delPet(@ParameterObject @RequestParam long petId){
        int result = service.delPet(petId);

        return ResultDto.<Integer>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).
                build();
    }

    @PutMapping
    @Operation(summary = "애완동물 정보 수정" , description = "애완동물 상세페이지 수정" +
            "                                                로그인한 유저 pk 도 필요합니다")
    public ResultDto<Integer> putPet( @RequestPart PutPetReq p,
                                     @RequestPart(required = false) MultipartFile pic){
        int list = service.putPet(pic, p);

        return ResultDto.<Integer>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(list).
                build();
    }
}
