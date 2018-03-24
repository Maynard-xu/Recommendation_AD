package com.xujin.ad_sender.service;

import com.xujin.ad_sender.dao.ProfessionDao;
import com.xujin.ad_sender.entity.ProfessionEntity;
import com.xujin.ad_sender.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionServiceImpl implements ProfessionService{
    @Autowired
    ProfessionDao professionDao;

    @Override
    public ProfessionEntity SearchProfession() {
        return professionDao.SearchProfession();
    }
}
