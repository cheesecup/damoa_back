package com.second.damoa.comment.model;

import com.second.damoa.board.BaseTimeEntity;
import com.second.damoa.board.FreeBoard.model.FreeBoard;
import com.second.damoa.social.model.User;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "comments")
@Entity
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment; // 댓글 내용

//    @Column(name = "created_date")
//    @CreatedDate
//    private String createdDate;
//
//    @Column(name = "modified_date")
//    @LastModifiedDate
//    private String modifiedDate;

    @ManyToOne
    @JoinColumn(name = "freeBoard_id")
    private FreeBoard freeBoard;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 작성자
 }
