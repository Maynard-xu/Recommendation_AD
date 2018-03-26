package com.xujin.ad_sender.controller;

import com.xujin.ad_sender.entity.ProfessionEntity;
import com.xujin.ad_sender.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profession")
public class ProfessionController {
    @Autowired
    ProfessionService professionService;

    /**
     * 初始化profession框。
     * @return
     */
    @GetMapping("/initprofession")
    public List<ProfessionEntity> initprofession() {
        return professionService.InitProfession();
    }

}
