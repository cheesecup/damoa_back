package com.second.damoa.comment.repository;

import com.second.damoa.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    /* 작성자 이름, 고유번호 조회*/
    @Modifying
    @Query(value = "SELECT COMMENTS.*, USER.NAME FROM COMMENTS JOIN USER ON USER.ID = COMMENTS.USER_ID WHERE COMMENTS.FREE_BOARD_ID = :fboardid", nativeQuery = true)
    List<CommentUserInterface> commentList(@Param("fboardid") Long id);

    /* FREE_BOARD_ID = NULL 데이터 삭제*/
    @Modifying
    @Query(value = "DELETE FROM COMMENTS WHERE FREE_BOARD_ID IS NULL", nativeQuery = true)
    int deleteNullComment();

    /* 연관관계 해제*/
    @Modifying
    @Query(value = "UPDATE COMMENTS SET FREE_BOARD_ID = NULL WHERE FREE_BOARD_ID = :fboardId", nativeQuery = true)
    int updateCommentNull(@Param("fboardId") Long id);

}

