package com.second.damoa.board.FreeBoard.service;

import com.second.damoa.board.FreeBoard.model.FreeBoard;
import com.second.damoa.board.FreeBoard.repository.FBRepository;
import com.second.damoa.chat.repository.ChatRepository;
import com.second.damoa.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FBServiceImpl implements FBService{

    private final FBRepository fbRepository;
    private final CommentRepository commentRepository;

    @Override
    public Long saveGroup(FreeBoard freeBoard) throws Exception {
        FreeBoard result = fbRepository.save(freeBoard);
        return result.getId();
    }

    @Override
    public List<FreeBoard> list() throws Exception {
        List<FreeBoard> boardInfoList = fbRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        return boardInfoList;
    }

    @Override
    public FreeBoard readList(Long id) throws Exception {
        Optional<FreeBoard> freeBoard = fbRepository.findById(id);
        return freeBoard.get();
    }

    @Override
    public Long savePost(FreeBoard freeBoard) throws Exception {

        return fbRepository.save(freeBoard).getId();
    }

    //삭제 메소드
    @Override
    public FreeBoard delete (Long id) {
        FreeBoard freeBoard = fbRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게실글이 없습니다. id=" + id));
        commentRepository.updateCommentNull(id); // 게시글-댓글 연관관계 해제 -> UPDATE FREE_BOARD_ID=NULL
        fbRepository.delete(freeBoard); // 게시글 삭제
        commentRepository.deleteNullComment(); // 댓글 삭제
        return freeBoard;
    }

}
