package com.second.damoa.board.PromotionBoard.service;

import com.second.damoa.board.FreeBoard.model.FreeBoard;
import com.second.damoa.board.PromotionBoard.model.PromotionBoard;
import com.second.damoa.board.PromotionBoard.repository.PBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PBServiceImpl implements PBService {

    private final PBRepository pbRepository;

    @Override
    public Long saveGroup(PromotionBoard promotionBoard) throws Exception {
        PromotionBoard result = pbRepository.save(promotionBoard);
        return result.getId();
    }

    @Override
    public List<PromotionBoard> list() throws Exception {
        List<PromotionBoard> boardInfoList = pbRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        return boardInfoList;
    }

    @Override
    public PromotionBoard readList(Long id) throws Exception {
        Optional<PromotionBoard> promotionBoard = pbRepository.findById(id);
        return promotionBoard.get();
    }

    @Override
    public Long savePost(PromotionBoard promotionBoard) throws Exception {

        return pbRepository.save(promotionBoard).getId();
    }

    //삭제 메소드
    @Override
    public PromotionBoard delete (Long id) {
        PromotionBoard promotionBoard = pbRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게실글이 없습니다. id=" + id));
        pbRepository.delete(promotionBoard);
        return promotionBoard;
    }
}
