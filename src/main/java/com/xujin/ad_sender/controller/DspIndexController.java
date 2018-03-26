package com.xujin.ad_sender.controller;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.gson.Gson;
import com.xujin.ad_sender.entity.ADInfoEntity;
import com.xujin.ad_sender.service.ADInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.UUIDEditor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* Description: DSP主页控制层
 * \* User: xujin
 * \* Date: 2018/3/24
 * \* Time: 18:04
 * \
 */
@RestController
@RequestMapping("/dsp")
public class DspIndexController {
    @Autowired
    ADInfoService adInfoService;

    @GetMapping("/InitADInformation")
    public List<ADInfoEntity> InitADInformation() {
        return adInfoService.InitADInformation();
    }

    @PostMapping("/upload")
    public Map<String, Object> upload(MultipartFile file, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String path = "/Users/xujin/Desktop/毕业设计/implement_code/ad_sender/src/main/resources/static/upload_images/";
        String fileName = file.getOriginalFilename();
        try {
            new FileWriter(path + fileName);
            file.transferTo(new File(path + fileName));
            map.put("state", 1);
            map.put("message", "upload successful");
            map.put("picturePath", path + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("state", 0);
        }
        return map;
    }

    //    广告路径 images/upload_images/
    @PostMapping("/addADInfo")
    public Map<String, Object> addADInfo(@RequestBody String adInfo) {
        String url = "images/upload_images/";
        ADInfoEntity adInfoEntity = new Gson().fromJson(adInfo, ADInfoEntity.class);
        Map<String, Object> map = new HashMap<>();
        System.out.println(adInfoEntity.getADClasses());
        adInfoEntity.setUploadPicture(url + adInfoEntity.getUploadPicture());
        adInfoService.addADInfo(adInfoEntity);
        map.put("success", true);
        map.put("message", "ADD successful");
        map.put("code", "200");
        return map;
    }
}
