//package com.second.damoa.comment.dto;
//
//import com.second.damoa.comment.model.Comment;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@RequiredArgsConstructor
//@Getter
//public class CommentResponseDto {
//    private Long id;
//    String comment;
//    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
//    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
//    private String nickname;
//    private Long postsId;
//    private Long userId;
//
//
//
//    /* Entity -> Dto*/
//    public CommentResponseDto(Comment comment) {
//        this.id = comment.getId();
//        this.comment = comment.getComment();
//        this.createdDate = comment.getCreatedDate();
//        this.modifiedDate = comment.getModifiedDate();
//        this.nickname = comment.getUser().getName();
//        this.postsId = comment.getFreeBoard().getId();
//    }
//}
//
//
//
