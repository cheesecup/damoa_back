package com.second.damoa.group.dto;

import com.second.damoa.group.model.GroupInfo;
import lombok.Data;

import java.util.Date;

@Data
public class GroupInfoDTO {

    private Long id;
    private String title;
    private String content;
    private String groupImg;
    private int likecount;
    private String type;
    private String local;
    private int count;
    private String memberId;

    public GroupInfoDTO() {
    }

    /*
    * 그룹 상세 정보 페이지 데이터
    * */
    public GroupInfoDTO(GroupInfo groupInfo) {
        id = groupInfo.getId();
        title = groupInfo.getTitle();
        content = groupInfo.getContent();
        groupImg = groupInfo.getGroupImg();
        type = groupInfo.getType();
        local = groupInfo.getLocal();
        memberId = groupInfo.getMemberId();
    }
}
