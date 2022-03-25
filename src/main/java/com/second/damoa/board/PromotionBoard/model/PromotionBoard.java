package com.second.damoa.board.PromotionBoard.model;

import com.second.damoa.board.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "promotionboard")
public class PromotionBoard extends BaseTimeEntity {

    @Id
    @Column(name = "board_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String name;

    @Lob
    private String content;



}
