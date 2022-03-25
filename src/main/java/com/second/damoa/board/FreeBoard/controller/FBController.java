package com.second.damoa.board.FreeBoard.controller;


import com.second.damoa.board.FreeBoard.model.FreeBoard;
import com.second.damoa.board.FreeBoard.service.FBService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RestController
@RequestMapping("/oauth2/redirect")
@RequiredArgsConstructor
public class FBController {

    private final FBService fbService;

    // 글 저장
    @PostMapping("/fboard")
    public void posttestFBoard(@ModelAttribute FreeBoard freeBoard, HttpServletResponse response) throws Exception{
        fbService.saveGroup(freeBoard);
        response.sendRedirect("http://localhost:3000/freepost/1");
    }

    // 글 목록 조회
    @GetMapping("/fboard/list")
    public List<FreeBoard> gettestFBoard() throws Exception {
        List<FreeBoard> membersList = fbService.list();
        return membersList;
    }

    // 글 상세 조회
    @GetMapping("/fboard/list/{id}")
    public FreeBoard detailFBoard(@PathVariable Long id, Model model) throws Exception {
        FreeBoard detailfboard = fbService.readList(id);
//        model.addAttribute("detailfboard", detailfboard);
        return detailfboard;
    }

    //게시글 수정

    @GetMapping("/fboard/edit/{id}")
    public FreeBoard edit(@PathVariable Long id, Model model) throws Exception {
        FreeBoard editfboard = fbService.readList(id);
        return editfboard;
    }

    @PutMapping("/fboard/edit/{id}")
    public void update(@PathVariable Long id, FreeBoard freeBoard, HttpServletResponse response) throws Exception {
        fbService.savePost(freeBoard);
        response.sendRedirect("http://localhost:3000/");
    }

    //게시글 삭제
    @DeleteMapping("/fboard/delete/{id}")
    public Long delete(@PathVariable Long id) throws Exception {
        fbService.delete(id);
        return id;
    }


}
