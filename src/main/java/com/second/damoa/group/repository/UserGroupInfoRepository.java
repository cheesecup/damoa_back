package com.second.damoa.group.repository;

import com.second.damoa.group.model.UserGroupInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserGroupInfoRepository extends JpaRepository<UserGroupInfo, Long> {

    // 그룹에 가입한 회원 조회
    @Modifying
    @Query(value = "select user.name, user.id from user_group_info join User on User.id = user_group_info.user_id where user_group_info.group_id = :group_id",
            nativeQuery = true)
    List<JoinUserInterface> joinUser(@Param("group_id") Long id);

    // 그룹 가입
    @Modifying
    @Query(value = "insert into user_group_info(group_id, user_id) values(:group_id, :user_id)", nativeQuery = true)
    int joinGroup(@Param("group_id") Long groupid, @Param("user_id") Long userid);

    // 그룹 탈퇴
    @Modifying
    @Query(value = "delete from user_group_info where group_id = :group_id and user_id = :user_id", nativeQuery = true)
    int leaveGroup(@Param("group_id") Long groupid, @Param("user_id") Long userid);

}
