package com.second.damoa.board.FreeBoard.repository;


import com.second.damoa.board.FreeBoard.model.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FBRepository extends JpaRepository<FreeBoard, Long> {
}
