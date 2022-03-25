package com.second.damoa.chat.repository;

import com.second.damoa.chat.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    /* 작성자 이름, 고유번호 조회*/
    @Modifying
    @Query(value = "SELECT CHAT.*, USER.NAME FROM CHAT JOIN USER ON USER.ID = CHAT.USER_ID WHERE CHAT.GROUP_INFO_ID = :groupinfoid", nativeQuery = true)
    List<ChatUserInterface> ChatList(@Param("groupinfoid") Long id);

}

