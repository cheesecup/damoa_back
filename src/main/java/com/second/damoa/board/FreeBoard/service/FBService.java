package com.second.damoa.board.FreeBoard.service;




import com.second.damoa.board.FreeBoard.model.FreeBoard;

import java.util.List;

public interface FBService {
    public List<FreeBoard> list() throws Exception; // 그룹 목록 조회
    public Long saveGroup(FreeBoard freeBoard) throws Exception; // 그룹 생성
    public FreeBoard readList(Long id) throws Exception; // 그룹 상세 정보 조회
    public Long savePost(FreeBoard freeBoard) throws Exception;
    public FreeBoard delete(Long id) throws Exception; // 글 삭제  service


}
