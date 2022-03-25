package com.second.damoa.board.PromotionBoard.service;




import com.second.damoa.board.FreeBoard.model.FreeBoard;
import com.second.damoa.board.PromotionBoard.model.PromotionBoard;

import java.util.List;

public interface PBService {
    public List<PromotionBoard> list() throws Exception; // 그룹 목록 조회
    public Long saveGroup(PromotionBoard promotionBoard) throws Exception; // 그룹 생성
    public PromotionBoard readList(Long id) throws Exception; // 그룹 상세 정보 조회
    public Long savePost(PromotionBoard promotionBoard) throws Exception; // 글 수정
    public PromotionBoard delete(Long id) throws Exception; // 글 삭제  service

}
