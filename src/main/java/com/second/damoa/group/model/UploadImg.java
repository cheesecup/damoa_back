package com.second.damoa.group.model;

import lombok.Data;

@Data
public class UploadImg {

    private String uploadImgName; // 사용자가 업로드 한 이미지 파일 이름
    private String storeImgName; // 로컬에 저장되는 이미지 파일 이름

    public UploadImg(String uploadImgName, String storeImgName) {
        this.uploadImgName = uploadImgName;
        this.storeImgName = storeImgName;
    }

}
