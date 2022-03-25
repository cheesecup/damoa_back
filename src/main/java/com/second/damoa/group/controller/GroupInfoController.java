package com.second.damoa.group.controller;

import com.second.damoa.group.dto.GroupInfoDTO;
import com.second.damoa.group.model.GroupInfo;

import com.second.damoa.group.model.UserGroupInfo;
import com.second.damoa.group.repository.GroupListInterface;
import com.second.damoa.group.repository.JoinUserInterface;
import com.second.damoa.group.service.GroupImgStore;
import com.second.damoa.group.service.GroupInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/oauth2/redirect/groupinfo")
@RequiredArgsConstructor
public class GroupInfoController {

    // 업로드 이미지 저장 경로
    @Value("${file.dir}")
    private String fileDir;

    private final GroupInfoService groupInfoService;
    private final GroupImgStore groupImgStore;

    // 그룹 목록 조회
    @GetMapping("/list")
    public List<GroupListInterface> groupList() throws Exception {
        List<GroupListInterface> groupInfo = groupInfoService.list();
        return groupInfo;
    }

    //

    // 입력한 그룹 정보 저장
    @PostMapping("/add")
    public void saveGroup(@ModelAttribute GroupInfo groupInfo,
                          @RequestParam("userid") Long userid,
                          @RequestParam("uploadImg") MultipartFile uploadImg,
                          HttpServletResponse response) throws Exception {
        String groupImg = groupImgStore.storeImg(uploadImg); // 업로드 이미지 파일 이름 랜덤 변경
        groupInfo.setGroupImg(groupImg);

        groupInfoService.saveGroup(groupInfo);

//        // 그룹 생성자 UserGroupInfo db에 저장
//        Long groupid = groupInfo.getId();
//        groupInfoService.joinGroup(groupid, userid);
        response.sendRedirect("http://13.124.89.93/");
    }

    // 그룹 정보 조회
    @GetMapping("/read/{id}")
    public GroupInfoDTO groupRead(@PathVariable Long id) throws Exception {
        GroupInfo groupInfo = groupInfoService.readGroup(id);
        GroupInfoDTO groupInfoDTO = new GroupInfoDTO(groupInfo);
        return groupInfoDTO;
    }

    // 그룹 가입
    @PostMapping("/join/{id}")
    public void joinGroup(@PathVariable Long id,
                          @RequestParam("userid") Long userid,
                          HttpServletResponse response) throws Exception {
        groupInfoService.joinGroup(id, userid); // 성공시 int '1' 반환
        response.sendRedirect("http://13.124.89.93/GroupInfCheck/" + id);
    }

    // 그룹 탈퇴
    @PostMapping("/leave/{id}")
    public void leaveGroup(@PathVariable Long id,
                           @RequestParam("userid") Long userid,
                           HttpServletResponse response) throws Exception {
        groupInfoService.leaveGroup(id, userid);
        response.sendRedirect("http://13.124.89.93/GroupInfCheck/" + id);
    }

    // 그룹에 가입한 회원 조회
    @GetMapping("/join/user/{id}")
    public List<JoinUserInterface> joinUser(@PathVariable Long id) throws Exception {
        List<JoinUserInterface> joinUser = groupInfoService.joinList(id);
        return joinUser;
    }

    // 그룹 대표 이미지 경로
    @GetMapping("/image/{filename}")
    public Resource groupImg(@PathVariable String filename) throws MalformedURLException {
        return new UrlResource("file:" + groupImgStore.getFullPath(filename));
    }

    // 그룹 대표 이미지 변경
    @PostMapping("/imgupdate")
    public void groupImgUpdate(@RequestParam("id") Long id,
                                 @RequestParam("uploadImg") MultipartFile uploadImg,
                                 HttpServletResponse response) throws Exception {
        String groupImg = groupImgStore.storeImg(uploadImg);

        groupInfoService.imgUpdate(id, groupImg);
        response.sendRedirect("http://13.124.89.93/GroupInfCheck/" + id);
    }

}
