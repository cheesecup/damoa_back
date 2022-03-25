package com.second.damoa.chat.model;

import com.second.damoa.board.BaseTimeEntity;

import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.social.model.User;
import lombok.*;


import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "chat")
@Entity
public class Chat extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment; // 댓글 내용

    @ManyToOne
    @JoinColumn(name = "groupInfo_id")
    private GroupInfo groupInfo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 작성자
 }
