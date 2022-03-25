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
    @Query(value = "SELECT comments.*, user.name FROM comments JOIN user ON user.id = comments.user_id WHERE comments.free_board_id = :fboardid", nativeQuery = true)
    List<CommentUserInterface> commentList(@Param("fboardid") Long id);

    /* FREE_BOARD_ID = NULL 데이터 삭제*/
    @Modifying
    @Query(value = "DELETE FROM comments WHERE free_board_id IS null", nativeQuery = true)
    int deleteNullComment();

    /* 연관관계 해제*/
    @Modifying
    @Query(value = "UPDATE comments SET free_board_id = null WHERE free_board_id = :fboardId", nativeQuery = true)
    int updateCommentNull(@Param("fboardId") Long id);

}

