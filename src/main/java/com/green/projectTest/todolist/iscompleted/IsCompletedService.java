package com.green.projectTest.todolist.iscompleted;

import com.green.projectTest.todolist.iscompleted.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class IsCompletedService {
    private final IsCompletedMapper mapper;

    public int toggleIsCompleted(ToggleIsCompletedReq p){
        SelIsCompletedRes selIsComplete = mapper.SelIsCompleted(p);

        if(selIsComplete.getIsCompleted() == 1) {
            mapper.patchDelIsCompleted(p);
            return 0;
        } else {
            mapper.patchInsIsCompleted(p);
            return 1;
        }
    }

    public List<GetIsCompletedListRes> getIsCompletedList(GetIsCompletedListReq p){
        List<GetIsCompletedListRes> list = mapper.getIsCompletedList(p);

        return list;
    }

    public int DelIsCompletedList(DelIsCompletedListReq p){
       return mapper.DelIsCompletedList(p);
    }
}
