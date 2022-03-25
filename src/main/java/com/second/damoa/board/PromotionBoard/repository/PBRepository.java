package com.second.damoa.board.PromotionBoard.repository;


import com.second.damoa.board.PromotionBoard.model.PromotionBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PBRepository extends JpaRepository<PromotionBoard, Long> {
}
