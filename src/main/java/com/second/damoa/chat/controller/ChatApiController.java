package com.second.damoa.chat.controller;

import com.second.damoa.chat.repository.ChatUserInterface;
import com.second.damoa.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/oauth2/redirect")
@RestController
public class ChatApiController {
    private final ChatService chatService;

    /* CREATE */
    @PostMapping("/groupinfo/comments")
    public void chatSave(@RequestParam("comment") String comment,
                            @RequestParam("groupInfo") Long groupInfo,
                            @RequestParam("user") String user,
                            HttpServletResponse response) throws Exception
    { //return ResponseEntity.ok(commentService.commentSave(user.getName(), id, dto));

        chatService.chatSave(user, groupInfo, comment);
        response.sendRedirect("http://13.124.89.93/GroupInfCheck/" + groupInfo);
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
    @GetMapping("/groupinfo/{id}/comments/list")
    public List<ChatUserInterface> chatList(@PathVariable Long id) throws Exception {
        List<ChatUserInterface> chatUserInterfaces = chatService.chatList(id);
        return chatUserInterfaces;
    }

}


