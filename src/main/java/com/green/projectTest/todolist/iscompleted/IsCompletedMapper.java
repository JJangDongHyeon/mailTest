package com.green.projectTest.todolist.iscompleted;

import com.green.projectTest.todolist.iscompleted.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IsCompletedMapper {
    SelIsCompletedRes SelIsCompleted(ToggleIsCompletedReq p);
    int patchDelIsCompleted(ToggleIsCompletedReq p);
    int patchInsIsCompleted(ToggleIsCompletedReq p);
    List<GetIsCompletedListRes> getIsCompletedList(GetIsCompletedListReq p);
    int DelIsCompletedList(DelIsCompletedListReq p);
}
