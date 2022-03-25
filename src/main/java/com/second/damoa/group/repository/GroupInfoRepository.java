package com.second.damoa.group.repository;

import com.second.damoa.group.dto.GroupInfoDTO;
import com.second.damoa.group.model.GroupInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupInfoRepository extends JpaRepository<GroupInfo, Long> {
    // 그룹 리스트 조회
    @Modifying
    @Query(value = "SELECT G.GROUP_NO, G.TITLE, G.LOCAL, G.TYPE FROM GROUPINFO G", nativeQuery = true)
    List<GroupListInterface> groupList();

    // 그룹 이미지 변경
    @Modifying
    @Query(value = "update GroupInfo set groupinfo.group_img = :groupImg where groupinfo.group_no = :id", nativeQuery = true)
    int imgUpdateQuery(@Param("id") Long id, @Param("groupImg") String groupImg);

}
