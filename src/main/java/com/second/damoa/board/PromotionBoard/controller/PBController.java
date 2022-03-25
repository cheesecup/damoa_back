package com.second.damoa.board.PromotionBoard.controller;


import com.second.damoa.board.FreeBoard.model.FreeBoard;
import com.second.damoa.board.PromotionBoard.model.PromotionBoard;
import com.second.damoa.board.PromotionBoard.service.PBService;
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
public class PBController {

    private final PBService pbService;

    // 글 저장
    @PostMapping("/pboard")
    public void posttestPBoard(@ModelAttribute PromotionBoard promotionBoard, HttpServletResponse response) throws Exception{
        pbService.saveGroup(promotionBoard);
        response.sendRedirect("http://localhost:3000/promopost/1");
    }

    // 글 목록 조회
    @GetMapping("/pboard/list")
    public List<PromotionBoard> gettestPBoard(Model model) throws Exception {
        List<PromotionBoard> membersList = pbService.list();
//        membersList = testFBoardService.list();
        return membersList;
    }

    // 글 상세 조회
    @GetMapping("/pboard/list/{id}")
    public PromotionBoard detailPBoard(@PathVariable Long id, Model model) throws Exception {
        PromotionBoard detailfboard = pbService.readList(id);
//        model.addAttribute("detailpboard", detailpboard);
        return detailfboard;
    }

    //게시글 수정
    @GetMapping("/pboard/edit/{id}")
    public PromotionBoard edit(@PathVariable Long id, Model model) throws Exception {
        PromotionBoard editpboard = pbService.readList(id);
        return editpboard;
    }

//    @PostMapping("/pboard/edit")
//    public void update(PromotionBoard promotionBoard, HttpServletResponse response) throws Exception {
//        pbService.savePost(promotionBoard);
//        response.sendRedirect("http://localhost:3000/");
//    }

    //게시글 삭제
    @DeleteMapping("/pboard/delete/{id}")
    public Long delete(@PathVariable Long id) throws Exception {
        pbService.delete(id);
        return id;
    }
}
