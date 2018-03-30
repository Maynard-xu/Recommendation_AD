package com.xujin.ad_sender.controller;

import com.sun.deploy.net.HttpResponse;
import com.xujin.ad_sender.entity.ProfessionEntity;
import com.xujin.ad_sender.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/profession")
public class ProfessionController {
    @Autowired
    ProfessionService professionService;

    /**
     * 初始化profession框
     * @return
     */
    @GetMapping("/initprofession")
    public List<ProfessionEntity> initprofession() {
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
        return professionService.InitProfession();
    }

}
