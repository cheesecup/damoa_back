package com.second.damoa.comment.service;

import com.second.damoa.board.FreeBoard.model.FreeBoard;
import com.second.damoa.board.FreeBoard.repository.FBRepository;
import com.second.damoa.comment.model.Comment;
import com.second.damoa.comment.repository.CommentRepository;
import com.second.damoa.comment.repository.CommentUserInterface;
import com.second.damoa.social.model.User;
import com.second.damoa.social.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final com.second.damoa.board.FreeBoard.repository.FBRepository FBRepository;

    /* CREATE */
    @Transactional
    public String commentSave(String name, Long id, String comment) {
        User user = userRepository.findByName(name);
        FreeBoard freeBoard = FBRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + id));
        Comment comment1 = new Comment();
        comment1.setUser(user);
        comment1.setFreeBoard(freeBoard);
        comment1.setComment(comment);

        commentRepository.save(comment1);
        return ""; }

    /* 조회 */
    @Transactional
    public List<CommentUserInterface> commentList(Long id) {
        List<CommentUserInterface> commentList = commentRepository.commentList(id);
        return commentList;
    }


}

