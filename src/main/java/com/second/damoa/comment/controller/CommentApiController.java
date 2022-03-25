package com.second.damoa.comment.controller;

import com.second.damoa.comment.repository.CommentUserInterface;
import com.second.damoa.comment.service.CommentService;
import com.second.damoa.social.model.User;
import com.second.damoa.social.security.CurrentUser;
import com.second.damoa.social.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/oauth2/redirect")
@RestController
public class CommentApiController {
    private final CommentService commentService;

    /* CREATE */
    @PostMapping("/fboard/comments")
    public void commentSave(@RequestParam("comment") String comment,
                            @RequestParam("freeBoard") Long freeBoard,
                            @RequestParam("user") String user,
                            HttpServletResponse response) throws Exception
    { //return ResponseEntity.ok(commentService.commentSave(user.getName(), id, dto));

        commentService.commentSave(user, freeBoard, comment);
        response.sendRedirect("http://13.124.89.93/freepostdetail/" + freeBoard);
    }

//    /* CREATE */
//    @PostMapping("/fboard/comments")
//    public String commentSave(@RequestBody(required = true) HashMap<String, Object> board
//            ,@CurrentUser User user)
//    { //return ResponseEntity.ok(commentService.commentSave(user.getName(), id, dto));
//
//        System.out.println(user.getName());
//
//        String comment = (String) board.get("comment");
//        String freeBoard_id = (String) board.get("freeBoard");
//        String user_id = (String) board.get("user");
//        commentService.commentSave(user_id, Long.valueOf(freeBoard_id), comment);
//        return "";
//    }

    /* 조회 */
    @GetMapping("/fboard/{id}/comments/list")
    public List<CommentUserInterface> commentList(@PathVariable Long id) throws Exception {
        List<CommentUserInterface> commentUserInterfaces = commentService.commentList(id);
        return commentUserInterfaces;
    }

}


