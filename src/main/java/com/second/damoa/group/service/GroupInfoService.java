package com.second.damoa.group.service;

import com.second.damoa.group.dto.GroupInfoDTO;
import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.group.repository.GroupListInterface;
import com.second.damoa.group.repository.JoinUserInterface;

import java.util.List;

public interface GroupInfoService {
    List<GroupListInterface> list() throws Exception; // 그룹 목록 조회
    Long saveGroup(GroupInfo groupInfo) throws Exception; // 그룹 생성
    GroupInfo readGroup(Long id) throws Exception; // 그룹 상세 정보 조회
    List<JoinUserInterface> joinList(Long id) throws Exception; // 그룹에 가입한 회원 조회
    int joinGroup(Long groupid, Long userid) throws Exception; // 그룹 가입
    int leaveGroup(Long groupid, Long userid) throws Exception; // 그룹 탈퇴
    int imgUpdate(Long id, String groupImg) throws Exception; // 그룹 이미지 변경

//    Long updateGroup(GroupInfo groupInfo) throws Exception; // 그룹 정보 수정
//    Long deleteGroup(GroupInfo groupInfo) throws Exception; // 그룹 삭제
//    List<GroupInfo> searchTitle(String search) throws Exception; // 그룹 검색
//    int updateCount(Long id); // 조회수 업데이트

}
