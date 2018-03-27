package com.xujin.ad_sender.service;

import com.xujin.ad_sender.dao.ADInfoDao;
import com.xujin.ad_sender.entity.ADInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* Description:
 * \* User: xujin
 * \* Date: 2018/3/24
 * \* Time: 18:25
 * \
 */
@Service
public class ADInfoServiceImpl implements ADInfoService {
    @Autowired
    ADInfoDao adInfoDao;

    @Override
    public List<ADInfoEntity> InitADInformation() {
        return adInfoDao.InitADInformation();
    }

    @Override
    public void addADInfo(ADInfoEntity adInfoEntity) {
        adInfoDao.addADInfo(adInfoEntity);
    }

    @Override
    public void updateADInfo(ADInfoEntity adInfoEntity) {
        adInfoDao.updateADInfo(adInfoEntity);
    }

    @Override
    public void deleteADInfo(ADInfoEntity adInfoEntity) {
        adInfoDao.deleteADInfo(adInfoEntity);
    }


}