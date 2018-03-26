package com.xujin.ad_sender.controller;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.xujin.ad_sender.entity.ADInfoEntity;
import com.xujin.ad_sender.service.ADInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.UUIDEditor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/getAllADInformation")
    public List<ADInfoEntity> getAllADInformation() {
        return adInfoService.getAllADInformation();
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
}
